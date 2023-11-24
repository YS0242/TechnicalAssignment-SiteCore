package Task2;

public class PalindromeChecker {
	public static boolean isPalindrome(String inputString, String trashSymbols) {
        int left = 0;
        int right = inputString.length() - 1;

        while (left <= right) {
            // Move left pointer if current char is a trash symbol
            while (left < inputString.length() && isTrashSymbol(inputString.charAt(left), trashSymbols)) {
                left++;
            }

            // Move right pointer if current char is a trash symbol
            while (right >= 0 && isTrashSymbol(inputString.charAt(right), trashSymbols)) {
                right--;
            }

            // If pointers have not crossed, compare the characters
            if (left <= right) {
                if (Character.toLowerCase(inputString.charAt(left)) != Character.toLowerCase(inputString.charAt(right))) {
                    return false;
                }
                left++;
                right--;
            }
        }

        return true;
    }

    private static boolean isTrashSymbol(char c, String trashSymbols) {
        return trashSymbols.indexOf(c) >= 0;
    }
}
