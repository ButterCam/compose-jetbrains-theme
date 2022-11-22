package io.kanro.compose.jetbrains.expui.util

import sun.misc.Unsafe
import java.lang.reflect.AccessibleObject

internal object UnsafeAccessing {
    val unsafe: Unsafe by lazy {
        val theUnsafe = Unsafe::class.java.getDeclaredField("theUnsafe")
        theUnsafe.isAccessible = true
        theUnsafe.get(null) as Unsafe
    }

    val desktopModule by lazy {
        ModuleLayer.boot().findModule("java.desktop").get()
    }

    val ownerModule by lazy {
        this.javaClass.module
    }

    private val isAccessibleFieldOffset: Long by lazy {
        unsafe.objectFieldOffset(Parent::class.java.getDeclaredField("first"))
    }

    private val implAddOpens by lazy {
        Module::class.java.getDeclaredMethod(
            "implAddOpens", String::class.java, Module::class.java
        ).accessible()
    }

    fun assignAccessibility(obj: AccessibleObject) {
        unsafe.putBooleanVolatile(obj, isAccessibleFieldOffset, true)
    }

    fun assignAccessibility(module: Module, packages: List<String>) {
        packages.forEach {
            implAddOpens.invoke(module, it, ownerModule)
        }
    }

    private class Parent {
        var first = false

        @Volatile
        var second: Any? = null
    }
}

internal fun <T : AccessibleObject> T.accessible(): T {
    return apply {
        UnsafeAccessing.assignAccessibility(this)
    }
}
