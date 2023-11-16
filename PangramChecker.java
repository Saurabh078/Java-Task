import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PangramChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();
        scanner.close();

        boolean isPangram = checkIfPangram(input);

        if (isPangram) {
            System.out.println("The input is a pangram.");
        } else {
            System.out.println("The input is not a pangram.");
        }
    }

    public static boolean checkIfPangram(String input) {
        Set<Character> alphabetSet = new HashSet<>();

        // Iterate through each character in the input
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                // Convert to lowercase to handle both uppercase and lowercase letters
                alphabetSet.add(Character.toLowerCase(c));
            }
        }

        // Check if the set contains all letters from a to z
        return alphabetSet.size() == 26;
    }
}
