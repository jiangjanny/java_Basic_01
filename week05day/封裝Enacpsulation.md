# 封裝（Encapsulation）

**封裝（Encapsulation）** 是將 **數據（屬性）和操作數據的代碼（方法）綁定在一起** 的機制。
它同時也是一個 **保護屏障（Protective Barrier）**，用來防止 **外部代碼隨意訪問或修改數據**。

---

## 封裝的特點

1. **將屬性設為私有（private）**

   * 防止外部直接訪問
   * 保護數據完整性

2. **提供公有方法訪問（Getter）和修改（Setter）**

   * 控制對屬性的訪問與修改
   * 可加入檢查邏輯，保證數據有效性

---

## 範例

```java id="d4qv3n"
class Person {

    // 屬性設為 private
    private String name;
    private int age;

    // Getter：讀取屬性
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Setter：修改屬性
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age > 0) {          // 可以加入檢查邏輯
            this.age = age;
        }
    }
}
```

使用：

```java id="q6k2bf"
Person p = new Person();
p.setName("Alice");   // 通過 setter 設定
p.setAge(25);         // 通過 setter 設定
System.out.println(p.getName());  // 通過 getter 讀取
```

---

## 封裝的好處

1. **控制數據存取權限**：外部不能隨意修改
2. **提高代碼可維護性**：可以在 getter/setter 中加入檢查邏輯
3. **降低耦合性**：外部不直接依賴內部數據結構
4. **增加靈活性**：可以隨時改變內部實現，而不影響外部使用

---

💡 小技巧記憶：

* **「私有 + 公有方法」 = 封裝**
* **private 屬性 + getter/setter 方法** = 標準做法

---
