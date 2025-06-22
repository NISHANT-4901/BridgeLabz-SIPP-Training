import java.util.Scanner;

public class VowelConsonantCounter {

    // Function to count vowels in a string
    public static int countVowels(String str) {
        int count = 0;
        String vowels = "aeiou";
        str = str.toLowerCase();

        for (char ch : str.toCharArray()) {
            if (vowels.indexOf(ch) != -1)
                count++;
        }
        return count;
    }

    // Function to count consonants in a string
    public static int countConsonants(String str) {
        int count = 0;
        str = str.toLowerCase();

        for (char ch : str.toCharArray()) {
            if (Character.isLetter(ch) && !"aeiou".contains(ch + "")) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        int vowels = countVowels(input);
        int consonants = countConsonants(input);

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);

        sc.close();
    }
}
