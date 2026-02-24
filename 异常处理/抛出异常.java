package 异常处理;

public class 抛出异常 {
    public static void main(String[] args) {
        try {
            process1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static void process1() {
        try{
            process2(null);
        } catch (NullPointerException e){
            throw new RuntimeException(e); //注意！如果此处不把e传入，那么异常栈就会丢失
        }
    }
    static void process2(String s) {
        if (s==null) {
            throw new NullPointerException();
        }
    }
}

/*
通过printStackTrace()可以打印出方法的调用栈，对于找到异常的传播栈非常有用

抛出异常的方法：
void process2(String s) {
    if (s==null) {
        throw new NullPointerException();
    }
}

方法在定义时，可以抛出任意异常，在这个方法被调用时，要么用try-catch处理，要么用throws声明抛出
什么时候用 throws 什么时候用 try-catch ？
适合用 throws：
main 方法
测试代码
演示代码
当前层不想处理，只想往上交

适合用 try-catch：
程序要继续运行
可以给出补救方案
要给用户友好提示

注意：
1.假如抛出的异常没有处理，那么程序就会崩溃
2.抛出的异常可以转换为其他异常，但是要传入原始的Exception实例，否则异常栈就会丢失，见上
*/
