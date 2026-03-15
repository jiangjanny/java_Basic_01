在 **Java** 中，**抽象類（Abstract Class）** 是一種不能直接建立物件（不能 `new`）的類別，用來當作其他類別的「模板」。它通常包含 **抽象方法（沒有實作）** 和 **普通方法（有實作）**。

---

## 1️⃣ 抽象類的基本概念

抽象類使用關鍵字 **`abstract`** 宣告。

特點：

* 不能直接建立物件
* 可以包含 **抽象方法** 和 **普通方法**
* 可以有 **屬性（變數）**
* 子類別必須實作抽象方法（除非子類也是抽象類）

---

## 2️⃣ 抽象類語法範例

```java
abstract class Animal {

    // 抽象方法（沒有方法體）
    abstract void makeSound();

    // 普通方法
    void sleep() {
        System.out.println("Animal is sleeping");
    }
}
```

說明：

* `makeSound()` 是抽象方法
* `sleep()` 是普通方法

---

## 3️⃣ 子類別實作抽象類

```java
class Dog extends Animal {

    @Override
    void makeSound() {
        System.out.println("Dog barks");
    }
}
```

使用：

```java
public class Main {
    public static void main(String[] args) {

        Dog dog = new Dog();
        dog.makeSound();
        dog.sleep();
    }
}
```

輸出：

```
Dog barks
Animal is sleeping
```

---

## 4️⃣ 抽象類 vs 介面（Interface）

| 特性  | 抽象類              | 介面                    |
| --- | ---------------- | --------------------- |
| 關鍵字 | `abstract class` | `interface`           |
| 方法  | 可有實作             | Java 8 前全部抽象          |
| 繼承  | 只能單繼承            | 可多實作                  |
| 變數  | 普通變數             | `public static final` |

---

✅ **簡單理解：**

* **抽象類**：提供「部分實作」的父類
* **子類**：負責完成剩下的功能

像是：

```
Animal (抽象)
   │
   ├── Dog
   ├── Cat
   └── Bird
```

---
