# JetBrains UI Kit for Compose Desktop

Cross-platform GUI gRPC debugging proxy like [charles](https://www.charlesproxy.com/) but design for gRPC.

Build with [Netty](https://netty.io/) (proxy protocol), [Compose Desktop](https://www.jetbrains.com/lp/compose/) (GUI), [Sisyphus](https://github.com/ButterCam/sisyphus) (Protobuf Runtime)

![screenshot](docs/screenshot.png)

## Highlight features

✅ **Cross-platform**, works on all your favorite platforms like Windows, macOS, Linux  
✅ **Jetbrains Style GUI**, easily integrating into your desktop  
✅ **Host Rewrite**, redirect the request to beta or test server without modifying client code  
✅ **Server Reflection Support**, parsing gRPC request and response message

## Quick Start

### Install

Download distribution from [release page](https://github.com/ButterCam/Mediator/releases).

MSI for Windows, Dmg for macOS, Dmg(aarch64) for macOS(Apple Silicon), deb for Linux.

### Run

Open the mediator app, the proxy server will listen 8888 port, the internal gRPC server will listen 9999 port by default.

### Config Client

Config the proxy server in your client code.

#### Java Client (Android or Server)

Config proxy server by `proxyDetector` method of channel builder.

```Kotlin
ManagedChannelBuilder.forAddress("foo.barapis.com", 9000)
    .usePlaintext()
    .proxyDetector {
        HttpConnectProxiedSocketAddress.newBuilder()
            .setTargetAddress(it as InetSocketAddress)
            .setProxyAddress(InetSocketAddress("<YOUR PC/MAC IP>", 8888))
            .build()
    }
    .build()
```

#### Objective C Client (iOS)

Set proxy server to Environment variable in `main` function before your app code.

```objc
int main(int argc, char * argv[]) {
    NSString * appDelegateClassName;
    @autoreleasepool {
        setenv("grpc_proxy", "http://<YOUR PC/MAC IP>:8888", 1);
        
        // Setup code that might create autoreleased objects goes here.
        appDelegateClassName = NSStringFromClass([AppDelegate class]);
    }
    return UIApplicationMain(argc, argv, nil, appDelegateClassName);
}
```

#### Go Client (Server)

Set proxy server to Environment variable.

```go
package main

import (
	"os"
)

func main() {
	os.Setenv("HTTP_PROXY", "http://<YOUR PC/MAC IP>:8888")

	// Your code here.
}
```

### Resolve messages

Mediator support renders message as JSON tree if your server supports the [Server Reflection](https://github.com/grpc/grpc/blob/master/doc/server-reflection.md).

If you need to append the metadata to Server Reflection Request, you should config your server rule in settings.

Open the `Mediator Settings`, create a server rule for your server.

Enter the Regex in `Host pattern` input field which to match your server.

Add the metadata in `Reflection api metadata` table.

Enable this rule by `Enable server rule` checkbox.

![Server Rule](docs/screenshot-rule.png)
