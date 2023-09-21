package train.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Matrix {

	public static void main(String[] args) {
		
		int[] matrix = new int[5];
		
		Random rd = new Random();
		int random;
		
		for(int i=0;i<matrix.length;i++) {
			random = rd.nextInt(8) + 1;
			matrix[i] = random;
		}
		
		Arrays.sort(matrix);
		
		 int[] rearrangedMatrix = new int[matrix.length];
		 ArrayList<Integer> odd = new ArrayList<Integer>();
		 ArrayList<Integer> even = new ArrayList<Integer>();
	        
	        int evenIndex = 0;  
	        int oddIndex = 1;   
	        
	        for (int num : matrix) {
	        	
	        	if(evenIndex >= matrix.length-1 && (num % 2) != 0) {
	        		evenIndex = matrix.length-1;
	        	} else {
	        		rearrangedMatrix[matrix.length-1] = 0;
	        	}
	        	
	        	if(oddIndex >= matrix.length-1 && (num % 2) == 0) {
	        		oddIndex = matrix.length-1;
	        	} else {
	        		rearrangedMatrix[matrix.length-1] = 0;
	        	}
	        	
	            if (num % 2 == 0) {
	                rearrangedMatrix[oddIndex] = num;
	                oddIndex += 2;  
	            } else {
	                rearrangedMatrix[evenIndex] = num;
	                evenIndex += 2;   
	            }
	        }

	        for(int num : rearrangedMatrix) {
	        	if(num == 0) {
	        		continue;
	        	}
	        	if(num % 2 == 0) {
	        		odd.add(num);
	        	} else {
	        		even.add(num);
	        	}
	        }
	        
	        int evenMax = even.get(0);
			for(int i=0;i<even.size();i++) {
				if(even.get(i) > evenMax) {
					evenMax = even.get(i);
				}
			}
			
			int oddMax = odd.get(0);
			for(int i=0;i<odd.size();i++) {
				if(odd.get(i) > oddMax) {
					oddMax = odd.get(i);
				}
			}
	        
			int SecondEvenMax = Integer.MIN_VALUE;
			for(int i=0;i<even.size();i++) {
				if(even.get(i) != evenMax && even.get(i) > SecondEvenMax) {
					SecondEvenMax = even.get(i);
				}
			}
			
			int SecondOddMax = Integer.MIN_VALUE;
			for(int i=0;i<odd.size();i++) {
				if(odd.get(i) != oddMax && odd.get(i) > SecondOddMax) {
					SecondOddMax = odd.get(i);
				}
			}
	        
			System.out.println("New Matrix: ");
			for(int num : rearrangedMatrix) {
				System.out.print(num + " ");
			}
			
			int summ = SecondEvenMax + SecondOddMax;
			System.out.println();
			
			System.out.println("Sum of the second largest elements are: " + summ);
			
			
	    }
}

