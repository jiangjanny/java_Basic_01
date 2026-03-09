## Static Context

```java

public class Main {
    public static int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        System.out.println(add(1, 2));
    }
}
```

## Reference Data Type

```java

public class Main {
    public static void changeA(int a) {
        a = 10;
    }

    public static void main(String[] args) {
        int a = 5;
        changeA(a);
        System.out.println(a);
    }
}
```

## Exchange elements

```java

public class Main {
    public static void main(String[] args) {
        int a = 5;
        int b = 10;
        int temp = a;
        a = b;
        b = temp;
        System.out.println(a);
        System.out.println(b);
    }
}
```

```java

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int temp = arr[0];
        arr[0] = arr[5];
        arr[5] = temp;
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
    }
}
```

## String split and subtring method

```java

public class Main {
    public static void main(String[] args) {
        String s = "Hello, how are you doing today?";
        String[] words = s.split(" ");
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);   
        };
    }
}
```

## Exchange elements

```java

public class Main {
    public static void main(String[] args) {
        String s = "Hello,";
        s = s.substring(0,4);
        System.out.println(s);
    
    }
}
```

## Math Class

```java

public class Main {
    public static void main(String[] args) {

        int x = 28;
        int y = 4;
        double z = 3.14;

        // Math.max(a, b)
        // 回傳兩個數字中「較大的值」
        System.out.println(Math.max(x, y)); // 28

        // Math.min(a, b)
        // 回傳兩個數字中「較小的值」
        System.out.println(Math.min(x, y)); // 4

        // Math.sqrt(a)
        // 計算平方根 (square root)
        // 回傳型別為 double
        System.out.println(Math.sqrt(x)); // √28 ≈ 5.2915

        // Math.pow(a, b)
        // 計算次方 a^b
        // 回傳型別為 double
        System.out.println(Math.pow(x, y)); // 28^4 = 614656

        // Math.round(a)
        // 四捨五入到最接近的整數
        // 回傳 long 或 int
        System.out.println(Math.round(z)); // 3

        // Math.ceil(a)
        // 無條件進位 (向上取整數)
        System.out.println(Math.ceil(z)); // 4.0

        // Math.floor(a)
        // 無條件捨去 (向下取整數)
        System.out.println(Math.floor(z)); // 3.0
    }
}
```
### Java Math 常用方法整理

| 方法              | 用途   | 範例                |
| --------------- | ---- | ----------------- |
| `Math.max(a,b)` | 取最大值 | `Math.max(5,10)`  |
| `Math.min(a,b)` | 取最小值 | `Math.min(5,10)`  |
| `Math.sqrt(x)`  | 平方根  | `Math.sqrt(25)`   |
| `Math.pow(a,b)` | 次方   | `Math.pow(2,3)`   |
| `Math.round(x)` | 四捨五入 | `Math.round(3.6)` |
| `Math.ceil(x)`  | 向上取整 | `Math.ceil(3.1)`  |
| `Math.floor(x)` | 向下取整 | `Math.floor(3.9)` |



## Recursion and Overflow

```java

public class Main {

    public static void main(String[] args) {
        printHi(3); // 從 3 開始呼叫
    }

    // 遞迴方法
    public static void printHi(int i) {

        // 終止條件 (Base Case)
        // 如果 i 等於 0 就停止
        if (i == 0) {
            return;
        }

        // 遞迴前執行
        System.out.println("output : " + i);

        // 呼叫自己 (遞迴)
        printHi(i - 1);

        // 遞迴結束回來後執行
        System.out.println("output_09 : " + i);
    }
}
```

## Binary and Decimal

```java

public class Main {
    public static void printHi(String[] args) {
        int a = 154;
        if(a % 2 == 0) {
            System.out.println("0");
        } else {
            System.out.println("1");
        }
    }
}
```