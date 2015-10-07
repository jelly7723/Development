import java.util.Scanner;
//第一步：先引包，引入Scanner包；
public class Scan{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        //第二步：声明Scanner，并且进行赋值；
        System.out.println("please write down your name");
        //第三步：接收键盘输入的参数。其中，next()是用来接收字符串型，nexeInt()接收整型值，nextDouble()接收双精度值。
        String name=in.next();
        System.out.println("please write down your age");
        int age=in.nextInt();
        System.out.println("your name:"+name);
        System.out.println("your age:"+age);
    }
}