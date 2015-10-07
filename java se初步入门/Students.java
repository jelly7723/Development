import java.util.*;

public class Students {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		System.out.println("请输入学生的人数：");
		int stuNum=in.nextInt();//stuNum存储学生人数
		System.out.println("请输入科目的总数：");
		int courNum=in.nextInt();//courNum存储科目总数
		String courName[]=new String[courNum];//存储科目名称
		String stuName[]=new String[stuNum]; //存储学生姓名1
		int score[][]=new int[stuNum][courNum];//存储特定学生的特定成绩
		int sum[]=new int[stuNum];//存储学生的总分
		int avg[]=new int[stuNum];
		String str[]=new String[stuNum];//关键所在。把整行的内容合并在一起，然后通过sum排序直接把整行内容交换，十分厉害。
		
		for(int i=0;i<courNum;i++){
			System.out.println("请输入第"+(i+1)+"门科目的名称：");
			courName[i]=in.next();
		}
		
		for(int i=0;i<stuNum;i++){
			System.out.println("请输入第"+(i+1)+"个学生的姓名：");
			stuName[i]=in.next();
			str[i]=stuName[i]+"\t";
			
			for(int j=0;j<courNum;j++){
				System.out.println("请输入"+stuName[i]+"的"+courName[j]+"成绩：");
				score[i][j]=in.nextInt();
				str[i]+=score[i][j]+"\t";
				sum[i]+=score[i][j];
			}
			avg[i]=sum[i]/courNum;	
			str[i]+=sum[i]+"\t"+avg[i];
		}
		
		for(int i=0;i<stuNum-1;i++){
			for(int j=i+1;j<stuNum;j++){
				if(sum[i]<sum[j]){
					String t=str[j];
					str[j]=str[i];
					str[i]=t;
				}
			}
		}//排序，把成绩按总分大到小排列。
		
		System.out.print("学生\t");
		for(int i=0;i<courNum;i++){
			System.out.print(courName[i]+"\t");
		}
		System.out.print("总分\t平均分\t排行榜");
		System.out.println();
		
		for(int i=0;i<stuNum;i++){
			System.out.println(str[i]+"\t"+(i+1));
		}
		

		
	}
}
