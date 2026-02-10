好，那我們直接來一個**「真的像後端在做的專案」**，一步一步來，不玩玩具範例。

目標專案：

> 🎯 **User Management REST API（純 Java + JDBC）**

* 不用 Spring
* 可以用 Postman / curl 打
* 真的連 MySQL
* 架構跟業界一致

你現在做完這個，其實就已經贏一堆 Java 新手了。

---

# Step 1：先建一個乾淨專案（IntelliJ）

### 1️⃣ IntelliJ 建立

```
New Project
→ Java
→ Gradle（或 Maven 都可）
→ JDK 17+
→ Project name: user-api
```

---

# Step 2：專案結構（先照這個建）

```
src/main/java
 └─ org.example
     ├─ Main.java
     ├─ controller/
     │    └─ UserController.java
     ├─ service/
     │    └─ UserService.java
     ├─ dao/
     │    └─ UserDao.java
     └─ model/
          └─ User.java
```

這個結構非常重要，之後你學 Spring 會直接無痛對接。

---

# Step 3：先讓 Server 跑起來（最小可動）

`Main.java`

```java
package org.example;

import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext("/ping", exchange -> {
            String response = "pong";
            exchange.sendResponseHeaders(200, response.length());
            exchange.getResponseBody().write(response.getBytes());
            exchange.close();
        });

        server.start();
        System.out.println("Server started at http://localhost:8080");
    }
}
```

打開瀏覽器：

```
http://localhost:8080/ping
```

看到 `pong` 代表你已經：

> ✅ 成功寫出一個 Java 後端服務

---

# Step 4：先不要急著寫 DB（這一步很關鍵）

很多人會直接爆炸在：

* Driver
* SQL
* JSON
* Exception

我們先確認三件事：

1. IntelliJ 能跑 Java
2. Port 8080 正常
3. 你能用瀏覽器打 API

這一步是「後面 90% 問題的根基」。

---

## 現在你的任務（很單純）

你只要回我一個結果：

* 你用哪個作業系統（Windows / Mac）
* 這支 `/ping` 能不能成功看到 `pong`

我下一步就直接帶你：

> Step 5：加 Jackson → 回 JSON
> Step 6：實作 `/users` API
> Step 7：接 MySQL（JDBC 真實連線）

從這裡開始就正式進入：
**「前端轉後端工程師模式」了。**
