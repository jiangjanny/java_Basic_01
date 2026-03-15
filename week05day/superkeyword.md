# super keyword
太好了！這裡是一個 **箭頭流程圖式的 `super` 用法示意圖**，直觀展示父類別與子類別之間的呼叫關係：

```
        ┌─────────────┐
        │   父類別    │
        │─────────────│
        │ name = "Parent" │
        │ greet()         │
        │ 父類構造方法    │
        └─────┬───────┘
              │
        ┌─────▼─────┐
        │   子類別  │
        │───────────│
        │ name = "Child" │
        │ greet()        │
        │ printNames()   │
        │ 子構造方法     │
        └─────┬────────┘
              │
  ┌───────────┴─────────────┐
  │ super.name → 父類屬性    │
  │ super.greet() → 父類方法 │
  │ super(...) → 父類構造方法 │
  └─────────────────────────┘
```

### 🔹 流程解釋：

1. **屬性衝突解決**：

   * 子類別有 `name`，父類別也有 `name`
   * 用 `super.name` 訪問父類屬性
2. **方法覆寫呼叫**：

   * 子類別覆寫 `greet()`
   * `super.greet()` 可呼叫父類別版本
3. **構造方法呼叫**：

   * 子類別構造方法可用 `super(...)` 呼叫父類別構造方法，完成初始化

---


### 1️⃣ 呼叫父類別的構造方法（Constructor）

當子類別要初始化父類別的屬性時，可以用 `super()` 來呼叫父類別的構造方法。

```java id="1s7n7v"
class 父類別 {
    String name;
    父類別(String name) {
        this.name = name;
        System.out.println("Parent constructor: " + name);
    }
}

class 子類別 extends 父類別 {
    子類別(String name) {
        super(name); // 呼叫父類別構造方法
        System.out.println("Child constructor: " + name);
    }
}

public class Main {
    public static void main(String[] args) {
        子類別 obj = new 子類別("Alice");
    }
}
```

**輸出：**

```
Parent constructor: Alice
Child constructor: Alice
```

> 注意：`super()` 必須放在子類別構造方法的第一行。

---

### 2️⃣ 呼叫父類別的方法

如果子類別覆寫了父類別的方法，但又想在子類別中使用父類別原本的方法，可以用 `super.方法名()`。

```java id="p2tm9f"
class 父類別 {
    void greet() {
        System.out.println("Hello from Parent");
    }
}

class 子類別 extends 父類別 {
    @Override
    void greet() {
        super.greet(); // 呼叫父類別的方法
        System.out.println("Hello from Child");
    }
}

public class Main {
    public static void main(String[] args) {
        子類別 obj = new 子類別();
        obj.greet();
    }
}
```

**輸出：**

```
Hello from Parent
Hello from Child
```

---

### 3️⃣ 訪問父類別的屬性

如果子類別和父類別有同名屬性，可以用 `super.屬性名` 訪問父類別的屬性，避免名稱衝突。

```java id="1lzv85"
class 父類別 {
    String name = "Parent";
}

class 子類別 extends 父類別 {
    String name = "Child";

    void printNames() {
        System.out.println(name);        // 子類別屬性
        System.out.println(super.name);  // 父類別屬性
    }
}

public class Main {
    public static void main(String[] args) {
        子類別 obj = new 子類別();
        obj.printNames();
    }
}
```

**輸出：**

```
Child
Parent
```

---

### ✅ 小結

`super` 可以：

1. `super()` → 呼叫父類別的構造方法
2. `super.方法名()` → 呼叫父類別的方法
3. `super.屬性名` → 訪問父類別的屬性

---


你想看圖示嗎？
