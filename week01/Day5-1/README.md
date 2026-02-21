`@Override` 是 Java（以及其他一些基於 Java 的語言）中的一個 **註解（annotation）**，它的作用其實很簡單但很重要：用來 **標示你正在覆寫（override）父類別的方法**。

具體作用可以分成幾點：

---

### 1️⃣ 提高程式安全性

當你在子類別中寫了一個和父類別方法名稱一樣的方法，但方法簽名（參數、回傳型別）寫錯了，如果沒有 `@Override`，Java 會把它當成一個新的方法，程式不會報錯，可能導致邏輯錯誤。
有了 `@Override`，編譯器就會檢查，如果你的方法根本沒有覆寫到父類別的方法，就會 **編譯錯誤**。

範例：

```java
class Parent {
    void hello() {
        System.out.println("Hello from Parent");
    }
}

class Child extends Parent {
    @Override
    void hello() {  // 正確覆寫
        System.out.println("Hello from Child");
    }

    @Override
    void helloo() {  // 拼錯，會編譯錯誤
        System.out.println("Typo method");
    }
}
```

在上例中，如果沒加 `@Override`，`helloo()` 會被當成新方法，不會報錯，但加了 `@Override` 就會立刻提醒你拼錯了。

---

### 2️⃣ 可讀性

看到 `@Override`，其他開發者立刻知道這個方法是 **從父類別或介面繼承而來的**，程式可讀性更好。

---

### 3️⃣ 也可以覆寫接口（Interface）的方法

在 Java 5 以前，`@Override` 只能用在覆寫父類別的方法上；
從 Java 6 開始，你也可以用 `@Override` 標記覆寫接口的方法，讓編譯器幫你檢查。

```java
interface A {
    void doSomething();
}

class B implements A {
    @Override
    public void doSomething() { // 正確覆寫接口方法
        System.out.println("Doing something");
    }
}
```

---

💡 **總結一句話**：
`@Override` 主要是 **幫助編譯器檢查覆寫是否正確**，同時也 **提醒程式讀者這個方法是從父類別或接口來的**。

---