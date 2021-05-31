package basic.day16.exer;

/*
    编写应用程序EcmDef.java，接受命令行的两个参数，要求不能输入负数，计算两数相除
        对数据类型不一致（NumberFormatException）
          缺少命令行参数（ArrayIndexOutOfBoundsException）
          除0（ArithmeticException）
          输入负数（EcDef 自定义的异常）进行异常处理
 */

class EcDef extends Exception {
    static final long serialVersionUID = -3387516993124229949L;

    public EcDef() {

    }

    public EcDef(String message) {
        super(message);
    }

    public EcDef(String message, Throwable cause) {
        super(message, cause);
    }

    public EcDef(Throwable cause) {
        super(cause);
    }

    public EcDef(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

public class EcmDef {
    public static void main(String[] args) {
        try {
            int i = Integer.parseInt(args[0]);
            int j = Integer.parseInt(args[1]);
            System.out.println(ecm(i, j));
        } catch (NumberFormatException e) {
            System.out.println("数据类型不一致");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("缺少命令行参数");
        } catch (ArithmeticException e) {
            System.out.println("除0");
        } catch (EcDef e) {
            System.out.println(e.getMessage());
        }
    }

    private static int ecm(int i, int j) throws EcDef {
        if (i < 0 || j < 0) {
            throw new EcDef("分子或分母为负数！");
        }
        return i / j;
    }
}
