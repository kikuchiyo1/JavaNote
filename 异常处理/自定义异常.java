package 异常处理;

public class 自定义异常 {
    public static void main(String[] args) {

    }
}
/*
需要抛出异常时，尽可能使用Java标准库定义的异常类
Java标准库定义的常用异常：
    Exception
    ├─ RuntimeException
    │  ├─ NullPointerException
    │  ├─ IndexOutOfBoundsException
    │  ├─ SecurityException
    │  └─ IllegalArgumentException
    │     └─ NumberFormatException
    ├─ IOException
    │  ├─ UnsupportedCharsetException
    │  ├─ FileNotFoundException
    │  └─ SocketException
    ├─ ParseException
    ├─ GeneralSecurityException
    ├─ SQLException
    └─ TimeoutException

例如，参数检查不合法，应该抛出IllegalArgumentException：
static void process1(int age) {
    if (age <= 0) {
        throw new IllegalArgumentException();
    }
}

自定义异常体系时，推荐从RuntimeException派生“根异常”，再派生出业务异常；

自定义异常时，应该提供多种构造方法。
 */
