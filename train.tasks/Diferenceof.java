package train.tasks;

import java.util.ArrayList;
import java.util.Scanner;

public class Diferenceof {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Input N: ");
		int n = sc.nextInt();
		
		System.out.println("Input M: ");
		int m = sc.nextInt();
		
		differenceofSum(n,m);
		sc.close();

	}
	
	static void differenceofSum(int n, int m){
		
		ArrayList<Integer> divisible = new ArrayList<Integer>();
		ArrayList<Integer> NotDivisible = new ArrayList<Integer>();
		
		for(int CurNum=1; CurNum<=n; CurNum++) {
			Integer result = CurNum%m;
			if(result.equals(0)) {
				divisible.add(CurNum);
			}else {
				NotDivisible.add(CurNum);
			}
		}
		
		int NotDivSum = 0;
		for(int i : NotDivisible) {
			NotDivSum = NotDivSum + i;
		}

		int DivSum = 0;
		for(int i : divisible) {
			DivSum = DivSum + i;
		}
		
		int result = NotDivSum - DivSum;
		System.out.println(result);
	}

}
