package train.tasks;

import java.util.Scanner;

public class Sort {
	
	public static void FirstMethod(Scanner sc) {
		try {
			
		System.out.print("count: ");
	    int count = sc.nextInt();  
	    int[] a = new int[count];

	    System.out.println("items: ");
	    for (int i = 0; i < a.length; i++) {
	        a[i] = sc.nextInt();
	    }
	    sc.close();
		
		int[] b = new int[a.length];
		int[] c = new int[a.length];
		int[] tmp;
		int len = 1;
		
		for (int i = 0; i < a.length; i++){
			b[i] = a[i];
		} 
		
		while (len < a.length) {
			int n = 0;
			for (int k = 0; k < b.length; k += 2*len) {
				n = k;
				int i = k;
				int j = k + len;
				int ri = a.length;
				int rj = a.length;
				
				if (k + len < a.length) ri = k + len;			
				if (k + 2 * len < a.length) rj = k + 2 * len;
							
				while (i < ri & j < rj) {
					if (b[i] < b[j]) {
						c[n] = b[i];
						i++;
					} else {
						c[n] = b[j];						
						j++;
					}	
					n++;
				}
				
				while (i < ri) {
					c[n] = b[i];
					i++;
					n++;
					
				}
				
				while (j < rj) {
					c[n] = b[j];
					j++;
					n++;
				}			
			}
			
			len *= 2;
			
			tmp = b;
			b = c;
			c = tmp;
		}
		
		for (int i = 0; i < a.length; i++){
			a[i] = b[i];
		}
		
		System.out.println("result: ");
		for(int i: a) {
			System.out.print(i + " ");
		} 
			
		}catch(Exception e) {
			System.out.println("input-output error");
	}
}
	
	public static void SecondMethod(Scanner sc) {
 	
	try {	
		
     System.out.print("count: ");
     int count = sc.nextInt();  
     int[] array = new int[count];

     System.out.println("items: ");
     for (int i = 0; i < array.length; i++) {
         array[i] = sc.nextInt();
     }
     sc.close();
     

     int left = 0;
     int right = array.length - 1;
     
     do {
     	
     	for(int i = left; i < right; i++) {
     		if(array[i] > array[i + 1]) {
     			int temp = array[i];
     			array[i] = array[i + 1];
     			array[i + 1] = temp;
     		}
     	}
     	
     	right--;
     	
     	for(int i = right; i > left; i--) {
     		if(array[i] < array[i - 1]) {
     			int temp = array[i];
     			array[i] = array[i - 1];
     			array[i - 1] = temp;
     		}
     	}
     	
     	 left++;
     	
     } while (left < right);
    
     System.out.println("result: ");
		for(int i: array) {
			System.out.print(i + " ");
		}
		
	}catch (Exception e) {
		System.out.println("input-output error");
 	}
}
 
 		public static void ThirdMethod(Scanner sc) {

 			try {
 			
 			System.out.print("count: ");
 			int count = sc.nextInt();
 			
 			int[] array = new int [count];
 			int[] equal = new int [count];
 			int[] less = new int [count];
 			int[] sorted_array = new int [count];
 			
 			System.out.println("items: ");
 			for(int i=0; i<array.length; i++) {
 				array[i]=sc.nextInt();
 			}
 			sc.close();
 			
 			for (int i=0; i<array.length;i++) {
 				for (int j=0; j<array.length; j++) {
 					if(array[i]==array[j]) {
 						equal[i]++;
 					}
 					if(array[i]>array[j]) {
 						less[i]++;
 					}
 				}
 			}
 			
 			int temp;
 			for(int i=0; i<array.length;i++) {
 				temp=less[i];
 				for(int j=0; j<equal[i];j++) {
 					sorted_array[temp+j]=array[i];
 				}
 			}
 			for(int i=0; i<array.length;i++) {
 				array[i]=sorted_array[i];
 			}
 			System.out.println("result: ");
 			for(int i: array) {
 				System.out.print(i + " ");
 			}
 		} catch (Exception e) {
 			System.out.println("input-output error");
 		}
 	}
 
	public static void main (String []args) {
		Scanner sc = new Scanner(System.in);
		
		int method;
		System.out.print("method: ");
		if (sc.hasNextInt()) {			
			method = sc.nextInt();
			if (method < 1 || method > 3) {
				System.out.println("input-output error");
				sc.close();
				return;
			}
		}
		else {
			System.out.println("input-output error");
			sc.close();
			return;
		}

		switch(method) {
		case 1: FirstMethod(sc); break;
		case 2: SecondMethod(sc); break;
		case 3: ThirdMethod(sc); break;
		}
	}
}