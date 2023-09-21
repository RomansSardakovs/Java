package train.tasks;

import java.util.Scanner;

public class Anagrams {

	public static void main(String[] args) {
		
		String first;
		String second;
		Scanner sc = new Scanner(System.in);
		
		first = sc.nextLine();
		second = sc.nextLine();
		first = first.toLowerCase();
		second = second.toLowerCase();
		sc.close();
		
		
		
		if (first.length() != second.length()) {
			 System.out.println("NO");
			 return;
		    }
		
		for(int i=0;i<first.length();i++) {
			Character temp = first.charAt(i);
			for(int j=0;j<second.length();j++) {
				if(temp.equals(second.charAt(j))) {
					second = second.replace(temp, '0');
					break;
				}
			}
		}
		
		boolean check=false;
		int count = 0;
		for(int i=0;i<second.length();i++) {
			Character temp = second.charAt(i);
			if(temp.equals('0')) {
				count++;
				if(count==second.length()) {
					check = true;
				}
			}
		}
		
		if(check) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
		
	}
}
