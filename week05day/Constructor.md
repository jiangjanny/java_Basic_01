# Java Class

在學 **Java** 時，初學者最常見的 **Class 範例**通常是一些生活物件，例如：**Student、Car、Dog**。這些例子可以幫助理解 **Object-Oriented Programming** 的概念。

下面給你幾個最常見、最容易理解的範例 👇

---

# 1️⃣ Student（學生）Class 範例

這是 **Java 初學者最常見的例子之一**。

```java
class Student {
    String name;
    int age;

    void study() {
        System.out.println(name + " is studying.");
    }
}
```

建立物件：

```java
public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Tom";
        s1.age = 20;

        s1.study();
    }
}
```

輸出：

```
Tom is studying.
```

---

# 2️⃣ Car（汽車）Class 範例

```java
class Car {
    String brand;
    int speed;

    void drive() {
        System.out.println(brand + " is driving at " + speed + " km/h");
    }
}
```

使用：

```java
Car car1 = new Car();
car1.brand = "Toyota";
car1.speed = 80;

car1.drive();
```

輸出：

```
Toyota is driving at 80 km/h
```

---

# 3️⃣ Dog（狗）Class 範例

```java
class Dog {
    String name;
    int age;

    void bark() {
        System.out.println(name + " is barking!");
    }
}
```

使用：

```java
Dog dog1 = new Dog();
dog1.name = "Lucky";
dog1.age = 3;

dog1.bark();
```

輸出：

```
Lucky is barking!
```

---

# 4️⃣ 帶 Constructor 的 Class（更標準寫法）

```java
class Student {
    String name;
    int age;

    Student(String n, int a) {
        name = n;
        age = a;
    }

    void introduce() {
        System.out.println("My name is " + name + ", I am " + age + " years old.");
    }
}
```

使用：

```java
Student s1 = new Student("Amy", 18);
s1.introduce();
```

輸出：

```
My name is Amy, I am 18 years old.
```

---



# 📌 初學者記住這個結構就夠了
## Class Constructor

Java 中的Constructor 是一種用於初始化對象的特殊方法，創建類的對象調用構造函數，他可用於對象屬性的初始值，
**規則:**
1. Constructor 必須與Class 名相同
2. Constructor 用於製作新的物件
3. Constructor 沒有任何返回類型 (無論是 void、int、double、boolean 都不對)
4. 所有Class 默認都有 Constructor : 如果我們不寫Constructor，Java 會為我們創建一個。但是，您無法為object 的屬性設置初始值

一個 **Java Class** 通常長這樣：

```java
class ClassName {

    // 屬性 (variables)
    
    // 建構子 (constructor)
    
    // 方法 (methods)
}
```

---

✅ **超簡單記法**

```
Class = 屬性 + 方法
```

例如：

```
Student
├─ name
├─ age
└─ study()
```

---

