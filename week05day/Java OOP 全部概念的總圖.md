# Java OOP 概念

下面是一份 **Java OOP 概念「備註式筆記」**，整理成像課堂重點筆記的形式，適合複習 **Object-Oriented Programming** 時快速看懂。

---

# Java OOP 備註式總整理

## 1️⃣ Class（類別）

**定義：**

* Class 是 **Object 的藍圖 (template)**

**結構：**

```text
Class
 ├─ Fields (屬性)
 ├─ Constructor (建構子)
 └─ Methods (方法)
```

**例子**

```java
class Car {
    String brand;
    int speed;

    void drive() {
        System.out.println("Driving");
    }
}
```

備註：

* `brand`、`speed` → fields
* `drive()` → method

---

# 2️⃣ Object（物件）

**定義：**

* Object 是 **Class 的 instance**

**建立物件**

```java
Car car1 = new Car();
```

備註：

```
Class → template
Object → real object
```

例子

```
Class : Car
Objects : car1, car2
```

---

# 3️⃣ Encapsulation（封裝）

**目的：**

* 保護資料
* 控制存取

**原則**

```
Fields → private
Methods → public
```

**例子**

```java
class Student {

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
```

備註：

* `getter` → 讀取資料
* `setter` → 修改資料

---

# 4️⃣ Inheritance（繼承）

**定義**

* 子類別繼承父類別

**關鍵字**

```
extends
```

**例子**

```java
class Animal {
    void eat() {
        System.out.println("Animal eats");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog barks");
    }
}
```

備註：

```
Dog → child class
Animal → parent class
```

Dog 可以使用：

```
eat()
bark()
```

---

# 5️⃣ Polymorphism（多型）

**定義**

* 同一方法，不同表現

兩種類型：

### Method Overloading（多載）

同方法名
不同參數

```java
void add(int a, int b)

void add(int a, int b, int c)
```

---

### Method Overriding（覆寫）

子類重新定義父類方法

```java
class Animal {
    void sound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    void sound() {
        System.out.println("Dog bark");
    }
}
```

---

# 6️⃣ Abstraction（抽象）

**定義**

* 隱藏實作
* 只顯示功能

兩種方式

### abstract class

```java
abstract class Animal {
    abstract void sound();
}
```

---

### interface

```java
interface Animal {
    void sound();
}
```

備註：

```
interface → 只定義方法
```

---

# 7️⃣ this keyword

**用途**

```
this = current object
```

**例子**

```java
class Student {

    int age;

    Student(int age) {
        this.age = age;
    }
}
```

備註：

```
this.age → field
age → parameter
```

---

# 8️⃣ static

**定義**

```
static → 屬於 class
不是 object
```

**例子**

```java
class Counter {

    static int count = 0;

}
```

備註：

```
所有 object 共用
```

---

# ⭐ Java OOP 四大核心

```
Encapsulation
Inheritance
Polymorphism
Abstraction
```

---

# ⭐ Java OOP 概念快速圖

```
OOP
 │
 ├─ Class
 │    └─ Object
 │
 ├─ Encapsulation
 │    └─ getter / setter
 │
 ├─ Inheritance
 │    └─ extends
 │
 ├─ Polymorphism
 │    ├─ overloading
 │    └─ overriding
 │
 └─ Abstraction
      ├─ abstract class
      └─ interface
```

---
