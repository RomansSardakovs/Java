package train.tasks;

import java.util.Scanner;

public class Replacechar {

	static void Replacecharacter(String str1, char ch1, char ch2){
		
		char[] array = str1.toCharArray();
		
		for(int i=0;i<array.length;i++) {
			if(array[i] == ch1) {
				array[i] = ch2;
				continue;
			}
			if(array[i] == ch2) {
				array[i] = ch1;
				continue;
			}
		}
		
		for(char i : array) {
			System.out.print(i);
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		char ch1 = sc.next().charAt(0);
		char ch2 = sc.next().charAt(0);
		sc.close();
		
		Replacecharacter(str1,ch1,ch2);
		
		
	}

}
