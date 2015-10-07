import java.util.Random;
import java.util.Scanner;

public class Guess{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        System.out.println("-----猜拳游戏开始----");
        System.out.println("--1.剪刀--2.石头--3.布--");
        System.out.println("----请选择你要出什么：");
        int type=in.nextInt();


        if(type==1){
            System.out.println("您出的是剪刀");
        }
        else if(type==2){
            System.out.println("您出的是石头");
        }
        else if(type==3){
            System.out.println("您出的是布");
        }
        else{
            System.out.println("请输入123而不是其他值！");
        }


        int computer=(int)(Math.random()*3)+1;
        if(computer==1){
            System.out.println("电脑出的是剪刀");
        }
        else if(computer==2){
            System.out.println("电脑出的是石头");
        }
        else{
            System.out.println("电脑出的是布");
        }

        if(computer==type){
            System.out.println("平局啦！！！");
        }
        else if(computer-type==1||(computer==1&&type==3)){
            System.out.println("你输了");
        }
        else{
            System.out.println("你赢了");
        }


    }
}