package basic.day16.java2;

/*
    如何自定义异常类？
    1.继承与现有的异常结构（RuntimeException或Exception）
    2.提供全局常量：serialVersionUID
    3.根据需要，提供重载的构造器
 */

public class MyException extends Exception {
    static final long serialVersionUID = -33876993124229948L;

    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyException(Throwable cause) {
        super(cause);
    }

    public MyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
