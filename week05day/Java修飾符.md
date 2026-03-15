# Java修飾符

你這段筆記有些小地方可以整理和修正，我幫你把 **Java 修飾符** 的內容整理成完整、清楚的版本，並補充你最後漏掉的部分。

---

# Java 修飾符（Modifiers）

修飾符（modifier）用於提供有關 **Class、變數、方法** 的額外信息。
修飾符分為兩大類：

1. **訪問修飾符（Access Modifiers）**：控制其他類對該元素的訪問權限
2. **非訪問修飾符（Non-Access Modifiers）**：不控制訪問權限，但提供其他功能（如 static、final、abstract 等）

---

## 1️⃣ Class 的修飾符

Class 的修飾符主要有：

| 修飾符        | 類型     | 功能                                |
| ---------- | ------ | --------------------------------- |
| `public`   | 訪問修飾符  | 任何其他 Class 都可以訪問這個 Class          |
| `abstract` | 非訪問修飾符 | 表示這是一個抽象類 **不能直接創建物件**，通常用來被其他類繼承 |
| `final`    | 非訪問修飾符 | 表示這個 Class **不能被繼承**              |

**範例：Abstract Class**

```java id="qplw3t"
abstract class Animal {
    abstract void sound();
}

class Dog extends Animal {
    void sound() {
        System.out.println("Woof");
    }
}

class Cat extends Animal {
    void sound() {
        System.out.println("Meow");
    }
}
```

* `Animal` 是抽象類，不能直接用 `new Animal()` 建立物件
* `Dog` 和 `Cat` 繼承 `Animal`，必須實作 `sound()` 方法

**範例：Final Class**

```java id="x7sghq"
final class Utility {
    static void printHello() {
        System.out.println("Hello");
    }
}

// class ExtendedUtility extends Utility {}  // ❌ 會報錯，因為 Utility 是 final
```

---


你希望我整理這個嗎？
