# Java繼承
在 **Java** 中，繼承（Inheritance）是一種**面向對象程式設計**的機制，它允許一個類別（子類別）從另一個類別（父類別）獲取屬性（變數）和方法（函數）。這可以幫助程式碼重用、提高可維護性，並實現多態性（Polymorphism）。

 **Java 繼承與接口的簡易結構圖**

```
             Object
               |
           ┌───┴────┐
           父類別A   父類別B
               |
           子類別C
               |
       ┌───────┴─────────┐
   實現接口X            實現接口Y
   (Flyable)            (Swimmable)
       |                     |
   子類別Duck ----------> 可以同時實現多個接口
```

### 說明：

1. **單繼承**：Java 每個類別只能繼承一個父類別（如 `子類別C extends 父類別A`）。
2. **多層繼承**：父類別可以有自己的父類別（如 `Object -> 父類別A -> 子類別C`）。
3. **接口實現**：子類別可以實現多個接口（如 `Duck implements Flyable, Swimmable`），解決多重繼承問題。
4. **Object 類**：所有類別最終都隱式繼承自 `Object`。

---



下面我幫你梳理 **Java 繼承的核心概念**：

---

### 1. 基本語法

```java
class 父類別 {
    String name;

    void greet() {
        System.out.println("Hello from Parent");
    }
}

// 子類別使用 extends 關鍵字繼承父類別
class 子類別 extends 父類別 {
    void sayName() {
        System.out.println("My name is " + name);
    }
}

public class Main {
    public static void main(String[] args) {
        子類別 obj = new 子類別();
        obj.name = "Alice";
        obj.greet();   // 繼承自父類別的方法
        obj.sayName(); // 子類別自己的方法
    }
}
```

**解釋：**

* `extends` 用於子類別繼承父類別。
* 子類別會自動獲得父類別的屬性和方法。
* 可以覆寫（Override）父類別的方法來改變行為。

---

### 2. 方法覆寫（Overriding）

子類別可以重新定義父類別的方法：

```java
class 父類別 {
    void greet() {
        System.out.println("Hello from Parent");
    }
}

class 子類別 extends 父類別 {
    @Override
    void greet() {
        System.out.println("Hello from Child");
    }
}

public class Main {
    public static void main(String[] args) {
        父類別 obj1 = new 父類別();
        obj1.greet(); // Hello from Parent

        子類別 obj2 = new 子類別();
        obj2.greet(); // Hello from Child
    }
}
```

---

### 3. super 關鍵字

* `super` 可以用來呼叫父類別的屬性或方法。

```java
class 父類別 {
    void greet() {
        System.out.println("Hello from Parent");
    }
}

class 子類別 extends 父類別 {
    void greet() {
        super.greet(); // 呼叫父類別的 greet()
        System.out.println("Hello from Child");
    }
}
```

---

### 4. Java 繼承特性

1. Java **單繼承**：每個類別只能有一個直接父類別。
2. 可以有多層繼承：`A -> B -> C`
3. `Object` 是所有類別的根父類別。
4. 子類別可以訪問父類別的 `public` 和 `protected` 成員，但不能訪問 `private` 成員。

---

### 5. 接口（Interface）與多重繼承

Java 不支援多個父類別，但可以實現多個介面：

```java
interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

class Duck implements Flyable, Swimmable {
    public void fly() {
        System.out.println("Duck can fly");
    }
    public void swim() {
        System.out.println("Duck can swim");
    }
}
```

---

