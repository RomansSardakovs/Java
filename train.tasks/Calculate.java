package train.tasks;

import java.util.ArrayList;
import java.util.Scanner;

public class Calculate {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		sc.close();
		
		ArrayList<Integer> div = new ArrayList<Integer>();
		
		for(int i = num1;i<=num2;i++) {
			if((i%3)==0 && (i%5)==0) {
				div.add(i);
			}
					
		}
		
		int summ=0;
		for(int i : div) {
			summ = summ + i;
		}
		
		System.out.println(summ);
		
	}
	
}
