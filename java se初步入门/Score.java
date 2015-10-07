import java.util.Scanner;

public class Score{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        System.out.println("please enter your js score:");
        int js=in.nextInt();
        System.out.println("please enter your java score:");
        int javase=in.nextInt();
        if(js>90&&javase>90){
            System.out.println("bang");
        }
        else{
            System.out.println("you nead study harder");
        }
    }
}