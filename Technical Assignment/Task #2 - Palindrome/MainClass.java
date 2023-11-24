package Task2;

public class MainClass {
	public static void main(String[] args) {
        String inputString1 = "a@b!!b$a";
        String trashSymbols1 = "!@$";
        boolean result = PalindromeChecker.isPalindrome(inputString1, trashSymbols1);
        System.out.println(result);  

        String inputString2 = "?Aa#c";
        String trashSymbols2 = "#?";
        result = PalindromeChecker.isPalindrome(inputString2, trashSymbols2);
        System.out.println(result); 
    }
}
