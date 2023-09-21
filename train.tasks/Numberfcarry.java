package train.tasks;

import java.util.Scanner;

public class Numberfcarry {

	static void Numberofcarry(Integer num1, Integer num2){
		
		String num1Str = num1.toString();
		String num2Str = num2.toString();
		
		if(num1Str.length() < num2Str.length()) {
			int dif = num2Str.length() - num1Str.length();
			for(int i=1;i<=dif;i++) {
				num1Str = num1Str + "0";
			}
		}else if(num2Str.length() < num1Str.length()) {
			int dif = num1Str.length() - num2Str.length();
			for(int i=1;i<=dif;i++) {
				num2Str = num2Str + "0";
			}
		}
		
		int carryDigit = 0;
		int DigitSumm = 0;
		for(int i=num1Str.length()-1;i>=0;i--) {
			char tempNum1 = num1Str.charAt(i);
			char tempNum2 = num2Str.charAt(i);
			int IntNum1 = tempNum1 - '0';
			int IntNum2 = tempNum2 - '0';
			Integer summ = IntNum1+IntNum2;
			summ = summ + carryDigit;
			if(summ >=10) {
				carryDigit++;
				DigitSumm++;
			}else {
				carryDigit = 0;
			}
			if(carryDigit > 1) {
				carryDigit = 1;
			}
			
		}
		
		System.out.println(DigitSumm);
	
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Integer num1 = sc.nextInt();
		Integer num2 = sc.nextInt();
		sc.close();
		Numberofcarry(num1, num2);
	}

}
