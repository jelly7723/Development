import java.util.*;

class Dog{
	public String eat(String food){
		System.out.println("kongkong want to eat "+food);
		return food;
	}
}

class Cat{
	public void guess(int i){
		if(i==0){
			System.out.println("you enter 0");
		}
		else{
			return;
		}
		System.out.println("hh");
	}
}

public class Retu {
	public static void main(String[] args){
		Dog kongkong=new Dog();
		String fo=kongkong.eat("meat");
		System.out.println(fo);
		
		Cat mm=new Cat();
		mm.guess(1);
	}
}
