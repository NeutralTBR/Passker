// A Java program that takes a user input password candidate, encodes it in Base64, randomizes the characters, and then swaps the case.
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.Base64;
import java.util.Random;
import java.awt.Toolkit;
import java.awt.datatransfer.*;

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

    public static void printAll(String candidate, String swapped) {
        print(  "Candidate:\t\t"+candidate+
                "\nYour password:\t"+swapped);
    }

    public static void copyToClipboard(String str) {
        StringSelection selection = new StringSelection(str);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, null);
    }

    public static String swapCase(String str) {
        StringBuilder swap = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isUpperCase(c)) {
                swap.append(Character.toLowerCase(c));
            } else if (Character.isLowerCase(c)) {
                swap.append(Character.toUpperCase(c));
            } else {
                swap.append(c);
            }
        }
        return swap.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        print("Enter password candidate: ");
        String candidate = sc.nextLine();

        String encoded = encode(candidate);
        String randomized = shuffleString(encoded);
        String swapped = swapCase(randomized);

        encoded = encode(swapped);
        randomized = shuffleString(encoded);
        swapped = swapCase(randomized);

        printAll(candidate, swapped);

        copyToClipboard(randomized);

        print("\nYour password has been copied to your clipboard, enjoy!");
    }
}