package 异常处理;

public class 捕获异常 {
}

/*
Java中，凡是可能抛出异常的语句，都可以用try...catch捕获

1.多catch语句
一个try语句可以对应多个catch语句，多个catch语句的catch块的参数类型可以相同，也可以不同，只有一个catch语句会被执行
注意：存在多个catch的时候，顺序很重要，一定要把子类放到前面：
public static void main(String[] args) {
    try {
        process1();
        process2();
        process3();
    } catch (IOException e) {
        System.out.println("IO error");
    } catch (UnsupportedEncodingException e) { // 永远捕获不到
        System.out.println("Bad encoding");
    }
}
上述代码中，第二个catch语句永远不会执行，因为UnsupportedEncodingException继承自IOException，所以它被第一个catch语句捕获了

2.finally语句
finally语句是可选项，无论有没有执行catch语句，finally语句都会被执行

3.同时捕获多种异常
如果对不同异常都有相同的处理逻辑，那么可以在一个catch语句中捕获多个异常,用'|'连结，压缩代码
public static void main(String[] args) {
    try {
        process1();
        process2();
        process3();
    } catch (IOException e | NumberFormatException e) {
        System.out.println("Bad Input");
    }.
}
*/
