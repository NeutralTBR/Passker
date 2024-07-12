// A Java program that takes a user input password candidate, encodes it in Base64, and then randomizes the characters.
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.Base64;
import java.util.Random;

public class Main {
    public static void print(String obj) {
        System.out.print(obj);
    }

    public static String encode(String input) {
        byte[] message = input.getBytes(StandardCharsets.UTF_8);
        return Base64.getEncoder().encodeToString(message);
    }

    public static String shuffleString(String input) {
        char[] characters = input.toCharArray();

        Random random = new Random();

        for (int i = characters.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            char temp = characters[i];
            characters[i] = characters[j];
            characters[j] = temp;
        }

        return new String(characters);
    }

    public static void printAll(String candidate, String encoded, String randomized) {
        print(  "Candidate:\t\t"+candidate+
                "\nEncoded:\t\t"+encoded+
                "\nYour password:\t"+randomized);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        print("Enter password candidate: ");
        String candidate = sc.nextLine();

        String encoded = encode(candidate);

        String randomized = shuffleString(encoded);

        printAll(candidate, encoded, randomized);
    }
}