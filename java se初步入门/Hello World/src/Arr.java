import java.util.*;

public class Arr {
	public static void main(String[] args){
		int arr[]=new int[5];
		Scanner in=new Scanner(System.in);
		for(int i=0;i<5;i++){
			System.out.println("please enter no."+(i+1)+" student's score:");
			arr[i]=in.nextInt();
		}
		Arrays.sort(arr);
		for(int i=0;i<5;i++){
			System.out.println(arr[i]);
		}
	}
}
