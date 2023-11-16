import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RomanToInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a Roman numeral: ");
        String romanNumeral = scanner.nextLine().toUpperCase(); // Convert to uppercase for case insensitivity
        scanner.close();

        int result = romanToInt(romanNumeral);

        if (result != -1) {
            System.out.println("The integer value of " + romanNumeral + " is: " + result);
        } else {
            System.out.println("Invalid Roman numeral entered.");
        }
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            if (!romanMap.containsKey(s.charAt(i))) {
                // Invalid Roman numeral character
                return -1;
            }

            int currentNumeral = romanMap.get(s.charAt(i));

            if (i < s.length() - 1) {
                int nextNumeral = romanMap.get(s.charAt(i + 1));
                if (currentNumeral < nextNumeral) {
                    result += (nextNumeral - currentNumeral);
                    i++; // Skip the next numeral since it has been considered
                } else {
                    result += currentNumeral;
                }
            } else {
                result += currentNumeral;
            }
        }

        return result;
    }
}
