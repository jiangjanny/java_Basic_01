我幫你整理一份 **考試版重點筆記：Polymorphism + Dynamic Binding**，這種格式通常很適合期中期末或筆試。

---

# 一、Polymorphism（多型）

**定義**

> **Polymorphism 是指同一個方法名稱在不同物件上可以有不同的行為。**

也就是：

```
One interface, multiple implementations
```

簡單理解：

```
同一方法呼叫
不同物件
不同結果
```

---

## Polymorphism 的條件

通常需要：

1️⃣ **Inheritance（繼承）**
2️⃣ **Method Overriding（方法覆寫）**
3️⃣ **Dynamic Binding（動態繫結）**

---

## Polymorphism 範例

```java
class Animal {
    void speak() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    void speak() {
        System.out.println("Woof");
    }
}

class Cat extends Animal {
    void speak() {
        System.out.println("Meow");
    }
}
```

主程式：

```java
Animal a;

a = new Dog();
a.speak();   

a = new Cat();
a.speak();
```

輸出：

```
Woof
Meow
```

這就是 **Polymorphism**。

---

# 二、Dynamic Binding（動態繫結）

**定義**

> **Dynamic Binding 是指方法的實際執行版本在程式執行時（runtime）才決定。**

又稱：

* **Late Binding**
* **Runtime Binding**

---

## Dynamic Binding 運作

```java
Animal a = new Dog();
a.speak();
```

編譯時：

```
a 的型態 = Animal
```

執行時：

```
實際物件 = Dog
```

因此執行：

```
Dog.speak()
```

不是：

```
Animal.speak()
```

---

# 三、Static Binding vs Dynamic Binding

| Binding         | 決定時間 | 常見情況               |
| --------------- | ---- | ------------------ |
| Static Binding  | 編譯時  | Method Overloading |
| Dynamic Binding | 執行時  | Method Overriding  |

---

## Static Binding 範例（Overloading）

```java
void add(int a, int b)
void add(double a, double b)
```

編譯時就決定呼叫哪個方法。

---

## Dynamic Binding 範例（Overriding）

```java
Animal a = new Dog();
a.speak();
```

執行時才決定。

---

# 四、Polymorphism 的好處

### 1️⃣ 提高程式彈性

```java
Animal a;
```

可以指向：

```
Dog
Cat
Bird
```

---

### 2️⃣ 提高程式可擴展性

新增類別不用改主程式：

```
class Lion extends Animal
```

---

### 3️⃣ 提高程式可維護性

統一介面：

```
a.speak()
```

---

# 五、常見考試問答

### Q1：What is Polymorphism?

**Answer**

> Polymorphism allows objects of different classes to be treated as objects of a common superclass and respond to the same method in different ways.

---

### Q2：What is Dynamic Binding?

**Answer**

> Dynamic binding means the method to be executed is determined at runtime rather than compile time.

---

### Q3：Relationship between Polymorphism and Dynamic Binding

**Answer**

> Dynamic binding enables polymorphism by determining the actual method implementation during runtime.

---

# 六、超短考試版（30秒背）

**Polymorphism**

```
Same method name
Different object
Different behavior
```

**Dynamic Binding**

```
Method call resolved at runtime
```

---


我也可以做成 **一頁超好背版本**。
