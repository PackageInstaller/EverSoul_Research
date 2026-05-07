# Kakao Game SDK - 登录流程 WSS 交互分析

## 📋 目录

- [概述](#概述)
- [整体架构](#整体架构)
- [数据流转过程](#数据流转过程)
- [数据压缩与编码机制](#数据压缩与编码机制)
- [WebSocket通信详解](#websocket通信详解)
- [关键代码位置](#关键代码位置)

---

## 概述

本文档详细分析了 Kakao Game SDK 中登录流程的 WebSocket Secure (WSS) 通信机制，包括从 Unity (IL2CPP) 层到 Android 原生层的完整数据处理流程。

### 核心发现

1. **Unity ↔ Native 通信**：使用 Base64 编码，超过 300KB 使用文件传递
2. **WSS 连接参数**：使用 `Deflate 压缩` + `URL-Safe Base64 编码`
3. **WSS 消息体**：传输未压缩的 JSON 字符串
4. **响应匹配机制**：通过 `transactionNo` 匹配请求与响应

---

## 整体架构

```
┌─────────────────────────────────────────────────────────────┐
│                     Unity (IL2CPP) 层                       │
│                                                             │
│  • 游戏逻辑发起登录请求                                       │
│  • 通过 JNI 调用 Android 原生方法                            │
└──────────────────────────┬──────────────────────────────────┘
                           │ Base64 编码
                           │ (超过 300KB 使用文件)
                           ↓
┌─────────────────────────────────────────────────────────────┐
│                  Android Native 层 (Java)                   │
│                                                             │
│  1. InterfaceBrokerManager  ← 接收 Unity 请求               │
│  2. ServerRequest           ← 构建请求对象                   │
│  3. SessionUtil             ← 压缩并编码                     │
│  4. WebSocketManager        ← 管理 WSS 连接                 │
└──────────────────────────┬──────────────────────────────────┘
                           │ WSS 协议
                           │ (wss://)
                           ↓
┌─────────────────────────────────────────────────────────────┐
│                      游戏服务器                              │
│                                                             │
│  • 接收 WSS 连接和消息                                       │
│  • 处理登录逻辑                                              │
│  • 返回响应数据                                              │
└─────────────────────────────────────────────────────────────┘
```

---

## 数据流转过程

### 完整流程图

```
┌──────────────┐
│ Unity 层      │
│ Login()      │
└──────┬───────┘
       │
       ↓ JNI 调用 (UnitySendMessage)
       │
┌──────────────────────────────────────────────────────┐
│ 1. InterfaceBrokerManager.requestSync()              │
│    ↓                                                 │
│    检查数据大小:                                      │
│    • < 300KB: Base64.encode(data)                   │
│    • ≥ 300KB: 写入文件，传递文件路径                  │
└──────┬───────────────────────────────────────────────┘
       │
       ↓
┌──────────────────────────────────────────────────────┐
│ 2. ServerRequest 构造                                 │
│    ↓                                                 │
│    JSON 数组格式:                                     │
│    [                                                 │
│      "/v1/oauth/login",           // requestUri     │
│      {"txNo": 12345},             // header         │
│      {"appId": "xxx", ...}        // body           │
│    ]                                                 │
└──────┬───────────────────────────────────────────────┘
       │
       ↓
┌──────────────────────────────────────────────────────┐
│ 3. SessionUtil.getConnectParameter()                 │
│    ↓                                                 │
│    压缩与编码:                                        │
│    原始 JSON → Deflate 压缩 → URL-Safe Base64       │
│    ↓                                                 │
│    生成连接参数: "m=eJw7LCkpKQ..."                   │
└──────┬───────────────────────────────────────────────┘
       │
       ↓
┌──────────────────────────────────────────────────────┐
│ 4. WebSocketManager.connectInternal()                │
│    ↓                                                 │
│    建立 WSS 连接:                                     │
│    wss://server.com/session?m=eJw7LCkpKQ...         │
│    ↓                                                 │
│    握手阶段协商:                                      │
│    • Sec-WebSocket-Extensions: permessage-deflate   │
└──────┬───────────────────────────────────────────────┘
       │
       ↓ WSS 连接建立
       │
┌──────────────────────────────────────────────────────┐
│ 5. WebSocketManager.sendInternal()                   │
│    ↓                                                 │
│    发送消息 (未压缩的 JSON):                          │
│    ["/v1/oauth/login", {"txNo": 12345}, {...}]      │
└──────┬───────────────────────────────────────────────┘
       │
       ↓ 等待服务器响应
       │
┌──────────────────────────────────────────────────────┐
│ 6. WebSocketListenerImpl.onMessage()                 │
│    ↓                                                 │
│    接收响应，解析 ServerResponse:                     │
│    • 提取 transactionNo                              │
│    • 匹配对应的请求                                   │
│    • 设置响应数据                                     │
└──────┬───────────────────────────────────────────────┘
       │
       ↓
┌──────────────────────────────────────────────────────┐
│ 7. InterfaceBrokerManager.sendResponse()             │
│    ↓                                                 │
│    返回 Unity:                                        │
│    • Base64.encode(response)                         │
│    • UnitySendMessage("KakaoGameSDK", "OnResult")   │
└──────┬───────────────────────────────────────────────┘
       │
       ↓ JNI 回调
       │
┌──────────────┐
│ Unity 层      │
│ OnResult()   │
└──────────────┘
```

---

## 数据压缩与编码机制

### 1. Unity ↔ Native 层通信

**文件位置**: `com/kakaogame/broker/InterfaceBrokerManager.java`

```java
// 从 Native 返回 Unity
if (responseString.length() > 300000) {
    // 超过 300KB: 写入文件
    invoke = method.invoke(null, "KakaoGameSDK", "OnResultFromFile", 
                           getResponseFilePath(activity, responseString));
} else {
    // 小于 300KB: Base64 编码
    invoke = method.invoke(null, "KakaoGameSDK", "OnResult", 
                           Base64Util.getBase64encode(responseString));
}
```

**编码方式**: 
- 标准 Base64 编码（Android Base64, flag=0）
- UTF-8 字符集

### 2. WebSocket 连接参数压缩

**文件位置**: `com/kakaogame/session/SessionUtil.java`

```java
private final String getCompressedMessage(ServerRequest request) {
    // 1. 获取 JSON 字符串
    String json = request.getRequestMessage();
    
    // 2. Deflate 压缩
    byte[] compressed = StringUtil.compress(json);
    
    // 3. URL-Safe Base64 编码
    return Base64Util.getUrlSafeBase64(compressed);
}
```

**压缩算法**: Java Deflate（`DeflaterOutputStream`）

```java
// StringUtil.compress() 实现
ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream);
deflaterOutputStream.write(source.getBytes(Charsets.UTF_8));
deflaterOutputStream.close();
return byteArrayOutputStream.toByteArray();
```

**编码方式**: URL-Safe Base64
- Android Base64, flag=10 (`URL_SAFE | NO_WRAP`)
- 使用 `-` 和 `_` 替代 `+` 和 `/`
- 无换行符

### 3. WebSocket 消息体

**文件位置**: `com/kakaogame/session/WebSocketManager.java`

```java
// 发送消息（未压缩）
webSocketClient.send(request.getRequestMessage());
```

**格式**: 纯 JSON 字符串，**不进行压缩**

```json
[
  "/v1/oauth/login",
  {
    "txNo": 12345
  },
  {
    "appId": "your-app-id",
    "idpCode": "kakao",
    "token": "access-token"
  }
]
```

---

## WebSocket 通信详解

### 连接建立

**文件位置**: `com/kakaogame/session/WebSocketManager.java`

```java
private final KeyBaseResult<ServerResult> connectInternal(ServerRequest request, long timeout) {
    // 1. 构建连接 URL（包含压缩的请求参数）
    String url = this.serverUrl + '?' + SessionUtil.getConnectParameter(request);
    // 示例: wss://server.com/session?m=eJw7LCkpKQ...
    
    // 2. 创建 WebSocket 客户端
    URI uri = URI.create(url);
    WebSocketClient webSocket = new WebSocketClient(uri, listener, null);
    
    // 3. 建立连接
    webSocket.connect();
    
    // 4. 等待连接成功（使用互斥锁）
    createLock.lock(timeout);
}
```

**连接 URL 格式**:
```
wss://[domain]/session?m=[Deflate+Base64编码的请求数据]
```

### 消息发送

**文件位置**: `com/kakaogame/session/WebSocketManager.java`

```java
private final ServerResult sendInternal(ServerRequest request, long timeout) {
    // 1. 创建同步请求对象
    SyncServerRequest syncRequest = new SyncServerRequest(request, listener);
    
    // 2. 发送消息
    webSocketClient.send(request.getRequestMessage());
    
    // 3. 等待响应
    return syncRequest.getSessionResponse(timeout);
}
```

**特点**:
- 同步等待响应（使用超时机制）
- 通过 `transactionNo` 匹配请求和响应
- 支持多个并发请求

### 消息接收

**文件位置**: `com/kakaogame/session/WebSocketManager.WebSocketListenerImpl`

```java
@Override
public void onMessage(String message) {
    try {
        // 1. 解析响应
        ServerResponse response = ServerResponse.INSTANCE.getResponse(message);
        
        // 2. 处理响应
        handleResponse(response);
    } catch (Exception e) {
        Logger.INSTANCE.m702e(TAG, "onMessage error", e);
    }
}

private void handleResponse(ServerResponse response) {
    // 3. 提取 transactionNo
    int txNo = response.getTransactionNo();
    
    // 4. 查找对应的请求
    SyncServerRequest request = syncRequestMap.get(txNo);
    
    if (request != null) {
        // 5. 设置响应数据
        request.setSessionResponse(response);
    } else {
        // 6. 未匹配的消息 -> 推送通知
        websocketEventListener.onServerMessage(response);
    }
}
```

### 请求/响应匹配机制

**核心机制**: Transaction Number (txNo)

```java
// ServerRequest 构造时自动生成
this.header.put("txNo", Integer.valueOf(requestIdGenerator.nextInt()));

// 发送请求时记录
syncRequestMap.put(txNo, syncRequest);

// 接收响应时匹配
SyncServerRequest request = syncRequestMap.get(txNo);
```

**流程**:
1. 发送请求时生成随机 `txNo`，放入 header
2. 将请求对象存入 `syncRequestMap`
3. 服务器响应时返回相同的 `txNo`
4. 根据 `txNo` 从 map 中找到对应的请求对象
5. 设置响应数据，唤醒等待的线程

---

## 关键代码位置

### Unity ↔ Native 通信

| 功能 | 文件路径 | 关键方法 |
|------|---------|---------|
| 请求同步处理 | `com/kakaogame/broker/InterfaceBrokerManager.java` | `requestSync()` |
| 响应返回 Unity | `com/kakaogame/broker/InterfaceBrokerManager.java` | `sendResponse()` |
| Base64 编码 | `com/kakaogame/util/Base64Util.java` | `getBase64encode()` |

### 数据压缩与编码

| 功能 | 文件路径 | 关键方法 |
|------|---------|---------|
| 连接参数处理 | `com/kakaogame/session/SessionUtil.java` | `getConnectParameter()`, `getCompressedMessage()` |
| Deflate 压缩 | `com/kakaogame/util/StringUtil.java` | `compress()` |
| Deflate 解压 | `com/kakaogame/util/StringUtil.java` | `decompress()` |
| URL-Safe Base64 | `com/kakaogame/util/Base64Util.java` | `getUrlSafeBase64()` |

### WebSocket 通信

| 功能 | 文件路径 | 关键方法 |
|------|---------|---------|
| WSS 管理器 | `com/kakaogame/session/WebSocketManager.java` | `connectInternal()`, `sendInternal()` |
| 请求对象 | `com/kakaogame/server/ServerRequest.java` | `getRequestMessage()` |
| 响应对象 | `com/kakaogame/server/ServerResponse.java` | `getResponse()` |
| 同步请求 | `com/kakaogame/session/SyncServerRequest.java` | `getSessionResponse()` |
| WebSocket 监听器 | `com/kakaogame/session/WebSocketManager.WebSocketListenerImpl` | `onMessage()`, `handleResponse()` |

### 服务层

| 功能 | 文件路径 | 关键方法 |
|------|---------|---------|
| 服务调度 | `com/kakaogame/server/ServerService.java` | `requestServer()`, `requestConnect()` |
| 会话服务 | `com/kakaogame/server/session/SessionService.java` | `requestSession()`, `requestConnect()` |
| 游戏会话 | `com/kakaogame/gameserver/GameSessionService.java` | `requestSessionImpl()` |

### 认证流程

| 功能 | 文件路径 | 关键方法 |
|------|---------|---------|
| 登录实现 | `com/kakaogame/auth/AuthImpl.java` | `loginWithUI()`, `loginWithoutUI()` |
| 登录协程 | `com/kakaogame/KGSession$login$1.java` | `invokeSuspend()` |
| 自定义登录 | `com/kakaogame/KGSessionForCustomUI$login$1.java` | `invokeSuspend()` |

---