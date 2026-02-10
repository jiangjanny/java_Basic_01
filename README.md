

# 全期總覽（90 天 / 12 週）

目標：

> 從 Java 幾乎新手 → 能獨立做後端服務（可面試）

每天固定 2 小時。

---

# Phase 1（第 1–14 天）

## 純 Java REST API（後端底層）

> 目標：知道後端「本質在幹嘛」

### Day 1

* 安裝 JDK 17
* IntelliJ 建專案
* 跑起 `/ping`

產出：

```
http://localhost:8080/ping → pong
```

---

### Day 2

* 建 package 結構
* 新增 `/hello`
* 理解 main / HttpServer

---

### Day 3

* 新增 `/users`
* 回假資料 List<User>

---

### Day 4

* 加 Jackson
* 回 JSON

---

### Day 5

* 實作 POST /users
* 接收 body

---

### Day 6

* HTTP method 分流
* 狀態碼

---

### Day 7

* 重構整包
* 不看教學重寫一次

---

### Day 8

* Exception handling
* 統一錯誤格式

---

### Day 9

* Path param

```
GET /users/1
```

---

### Day 10

* Query param

```
GET /users?name=Tom
```

---

### Day 11

* Validation
* 空值處理

---

### Day 12

* logging
* 印 request flow

---

### Day 13

* API 文件（自己寫 Markdown）

---

### Day 14

* 回顧週
* 完整重寫一輪

---

# Phase 2（第 15–28 天）

## JDBC + MySQL（後端靈魂）

### Day 15

* 安裝 MySQL
* 建 DB + table

---

### Day 16

* JDBC connect
* 測試 SELECT

---

### Day 17

* UserDao
* 查單筆

---

### Day 18

* 查全部

---

### Day 19

* INSERT user

---

### Day 20

* UPDATE user

---

### Day 21

* DELETE user

---

### Day 22

* 接回 REST API

---

### Day 23

* PreparedStatement

---

### Day 24

* 防 SQL injection

---

### Day 25

* Transaction

---

### Day 26

* 重構 DAO layer

---

### Day 27

* Exception mapping

---

### Day 28

* 完整測試（Postman）

---

# Phase 3（第 29–42 天）

## Spring Boot（主流框架）

### Day 29

* Spring Initializr
* 跑起來

---

### Day 30

* @RestController
* GET API

---

### Day 31

* POST API

---

### Day 32

* JPA Entity

---

### Day 33

* Repository

---

### Day 34

* DTO mapping

---

### Day 35

* Validation

---

### Day 36

* Exception Handler

---

### Day 37

* logback

---

### Day 38

* 分環境設定

---

### Day 39

* 重構整包

---

### Day 40

* API 文件

---

### Day 41

* 自己重寫一次

---

### Day 42

* 對比：純 Java vs Spring

---

# Phase 4（第 43–56 天）

## 真實後端能力

### Day 43

* JWT 原理

---

### Day 44

* 登入 API

---

### Day 45

* Token 驗證

---

### Day 46

* Filter / Interceptor

---

### Day 47

* CORS

---

### Day 48

* RBAC 權限

---

### Day 49

* Refresh token

---

### Day 50

* 登入流程重構

---

### Day 51

* Exception security

---

### Day 52

* log security

---

### Day 53

* 整體測試

---

### Day 54

* API 文件

---

### Day 55

* 自己重寫

---

### Day 56

* 架構圖

---

# Phase 5（第 57–70 天）

## Docker + 部署

### Day 57

* Docker 基礎

---

### Day 58

* Dockerfile

---

### Day 59

* docker-compose

---

### Day 60

* MySQL container

---

### Day 61

* API container

---

### Day 62

* 環境變數

---

### Day 63

* 雲端部署

---

### Day 64

* domain 綁定

---

### Day 65

* HTTPS

---

### Day 66

* log 觀察

---

### Day 67

* crash 測試

---

### Day 68

* 重構 Docker

---

### Day 69

* 文件整理

---

### Day 70

* demo 上線

---

# Phase 6（第 71–90 天）

## 高級 Java 基礎（工程師版）

每天一個主題：

* OOP 深入
* SOLID
* JVM
* GC
* Concurrency
* Collections
* Design Patterns
* Clean Code
* 測試（JUnit）
