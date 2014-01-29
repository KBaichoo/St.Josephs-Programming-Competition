import java.util.Scanner;

public class Big_Bucks{
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		double withdrawlsMade = 0;
		double withdrawlsToMake = Double.parseDouble(input.nextLine());
		
		while(withdrawlsMade < withdrawlsToMake){
			outputAmountToWidthdraw(input.nextLine());
			withdrawlsMade++;
		}
		
		input.close();
	}
	
	public static void outputAmountToWidthdraw(String email){
		char[] emailCharacters = email.toCharArray();
		String amountToWithdraw = "";
		
		//not a valid email since the last character in email is a number
		if(emailCharacters[emailCharacters.length - 1] >= '0' &&  emailCharacters[emailCharacters.length - 1] <= '9')
			return;
		
		//adds all numbers to the amount to withdraw
		for(char character : emailCharacters){
			if(character <= '9' && character >= '0')
				amountToWithdraw += character;
		}
		
		System.out.println(formatNumberToDollars(amountToWithdraw));
		
	}
	
	public static String formatNumberToDollars(String number){
		String formattedAmount = "";
		char[] digits = number.toCharArray();
		
		for(int i = 1; i <= digits.length; i++){
			//get a digit from the right and goes toward the left
			formattedAmount = digits[digits.length - i] + formattedAmount;
			
			//if it is a 3rd digit and it isn't the final digit then we add a comma
			if(i % 3 == 0 && i != digits.length)
				formattedAmount = "," + formattedAmount;
			
		}
		
		formattedAmount = "$" + formattedAmount + ".00";
		
		return formattedAmount;
	}
}