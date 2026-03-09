# java 基本認知

## JAVA 常見資料類型

在 **Java** 中，常見的資料類型可以分成 **兩大類**：

1️⃣ **基本資料型別 (Primitive Types)**
2️⃣ **參考資料型別 (Reference Types)**

---

# 1️⃣ 基本資料型別 (Primitive Types)

Java 有 **8 種基本型別**，用來儲存簡單數值。

| 類型        | 大小      | 位元     | 範圍               | 範例                        | 描述                |
| --------- | ------- | ------ | ---------------- | ------------------------- | ----------------- |
| `byte`    | 1 byte  | 8-bit  | -128 ~ 127       | `byte a = 10;`            | 很小的整數，通常用於節省記憶體   |
| `short`   | 2 bytes | 16-bit | -32,768 ~ 32,767 | `short b = 1000;`         | 比 `int` 小的整數      |
| `int`     | 4 bytes | 32-bit | -2³¹ ~ 2³¹-1     | `int age = 30;`           | **最常用的整數型別**      |
| `long`    | 8 bytes | 64-bit | -2⁶³ ~ 2⁶³-1     | `long money = 100000L;`   | 很大的整數             |
| `float`   | 4 bytes | 32-bit | 約 ±3.4E38        | `float price = 10.5f;`    | 單精度浮點數            |
| `double`  | 8 bytes | 64-bit | 約 ±1.7E308       | `double pi = 3.14;`       | **最常用的小數型別 (預設)** |
| `char`    | 2 bytes | 16-bit | 0 ~ 65,535       | `char grade = 'A';`       | 單一字元 (Unicode)    |
| `boolean` | JVM     | —      | true / false     | `boolean isLogin = true;` | 邏輯判斷              |

### 範例

```java
int age = 25;
double height = 175.5;
char grade = 'A';
boolean isStudent = true;
```

---

# 2️⃣ 參考資料型別 (Reference Types)

這類型 **不是直接存資料，而是存記憶體位置 (reference)**。

常見有：

| 類型          | 說明   | 範例                        |
| ----------- | ---- | ------------------------- |
| `String`    | 字串   | `String name = "Tom";`    |
| `Array`     | 陣列   | `int[] nums = {1,2,3};`   |
| `Class`     | 自訂類別 | `User user = new User();` |
| `Interface` | 介面   | `Runnable r = ...`        |
| `Enum`      | 列舉   | `Day.MONDAY`              |

### 範例

```java
String name = "John";

int[] numbers = {1,2,3};

User user = new User();
```


---

# 4️⃣ Java 最常用的資料型別 (實務)

在做 **REST API / DB** 時最常看到：

```java
int
long
double
boolean
String
List<T>
Map<K,V>
```

例如：

```java
public class User {

    private long id;
    private String name;
    private int age;
    private boolean active;

}
```

---

# 5️⃣ 一個很好記的分類

```
Java Data Types
│
├─ Primitive (8)
│  ├─ byte
│  ├─ short
│  ├─ int
│  ├─ long
│  ├─ float
│  ├─ double
│  ├─ char
│  └─ boolean
│
└─ Reference
   ├─ String
   ├─ Array
   ├─ Class
   ├─ Interface
   └─ Enum
```


---

# 1️⃣ MySQL ↔ Java 資料型別對照

| MySQL        | Java Primitive | Java Wrapper                | 常見用途         |
| ------------ | -------------- | --------------------------- | ------------ |
| `INT`        | `int`          | `Integer`                   | id、數量        |
| `BIGINT`     | `long`         | `Long`                      | 大型 ID        |
| `TINYINT(1)` | `boolean`      | `Boolean`                   | true / false |
| `DECIMAL`    | ❌              | `BigDecimal`                | 金額           |
| `FLOAT`      | `float`        | `Float`                     | 小數           |
| `DOUBLE`     | `double`       | `Double`                    | 小數           |
| `VARCHAR`    | ❌              | `String`                    | 文字           |
| `TEXT`       | ❌              | `String`                    | 長文字          |
| `DATE`       | ❌              | `LocalDate`                 | 日期           |
| `DATETIME`   | ❌              | `LocalDateTime`             | 日期時間         |
| `TIMESTAMP`  | ❌              | `Instant` / `LocalDateTime` | 系統時間         |

---

# 2️⃣ 實際資料表範例

假設 MySQL 有一個 `users` table

```sql
CREATE TABLE users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50),
    password VARCHAR(100),
    age INT,
    active TINYINT(1),
    created_at DATETIME
);
```

---

# 3️⃣ Java Model 寫法

```java
import java.time.LocalDateTime;

public class User {

    private Long id;
    private String username;
    private String password;
    private Integer age;
    private Boolean active;
    private LocalDateTime createdAt;

}
```

注意幾個重點：

### 1️⃣ DB 通常用 Wrapper

例如

```java
Integer
Long
Boolean
```

原因：

因為 **資料庫可能為 NULL**

primitive 不行：

```java
int age; // 不能是 null
```

wrapper 可以：

```java
Integer age; // 可以 null
```

---

# 4️⃣ PreparedStatement 取資料

例如 DAO 讀取資料：

```java
ResultSet rs = stmt.executeQuery();

while (rs.next()) {

    Long id = rs.getLong("id");
    String username = rs.getString("username");
    Integer age = rs.getInt("age");
    Boolean active = rs.getBoolean("active");

}
```

---

# 5️⃣ 寫入 DB

```java
PreparedStatement stmt = conn.prepareStatement(
    "INSERT INTO users(username, password, age, active) VALUES (?, ?, ?, ?)"
);

stmt.setString(1, "tom");
stmt.setString(2, "123456");
stmt.setInt(3, 25);
stmt.setBoolean(4, true);

stmt.executeUpdate();
```

---

# 6️⃣ REST API 回傳 JSON

如果你用 **Jackson**

```java
ObjectMapper mapper = new ObjectMapper();

String json = mapper.writeValueAsString(user);
```

回傳會變成：

```json
{
  "id": 1,
  "username": "tom",
  "age": 25,
  "active": true
}
```

---

# 7️⃣ 新手最常犯的型別錯誤

❌ 錯誤

```java
double price;   // 金額
```

✅ 正確

```java
BigDecimal price;
```

原因：

**double 會有精度問題**

---

# 8️⃣ 後端工程師最常用型別 (必背)

其實 90% API 都只會用這些：

```java
String
Integer
Long
Boolean
BigDecimal
LocalDate
LocalDateTime
List<T>
Map<K,V>
```

---


