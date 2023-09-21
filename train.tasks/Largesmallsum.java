package train.tasks;

import java.util.ArrayList;
import java.util.Scanner;

public class Largesmallsum {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter size of array: ");
		int size = sc.nextInt();
		sc.close();
		
		System.out.println(LargeSmallSum(size));
		
	}
	
	static int LargeSmallSum(int size) {
		int[] array = new int[size];
		
		for(int i=1;i<=size;i++) {
			array[i-1] = i;
		}
		
		if(array.length == 0) {
			return 0;
		}else if(array.length<=3) {
			return 0;
		}
		
		ArrayList<Integer> odd = new ArrayList<Integer>();
		ArrayList<Integer> even  = new ArrayList<Integer>();
		
		int Counter = 1;
		do {
			even.add(array[Counter-1]);
			odd.add(array[Counter]);
			Counter+=2;
			if(Counter==size-1) {
				even.add(array[Counter-1]);
				odd.add(array[Counter]);
				break;
			}else if(Counter>size-1) {
				even.add(array[Counter-1]);
				break;
			}
		}while(true);
		
		int min = odd.get(0);
		for(int i=0;i<odd.size();i++) {
			if(odd.get(i) < min) {
				min = odd.get(i);
			}
		}
		
		int max = even.get(0);
		for(int i=0;i<even.size();i++) {
			if(even.get(i) > max) {
				max = even.get(i);
			}
		}
		
		int SecondMin = Integer.MAX_VALUE;
		for(int i=0;i<odd.size();i++) {
			if(odd.get(i) != min && odd.get(i) < SecondMin) {
				SecondMin = odd.get(i);
			}
		}
		
		int SecondMax = Integer.MIN_VALUE;
		for(int i=0;i<even.size();i++) {
			if(even.get(i) != max && even.get(i) > SecondMax) {
				SecondMax = even.get(i);
			}
		}
		
		return SecondMin + SecondMax;
	}
	
}
