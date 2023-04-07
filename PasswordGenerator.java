import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PasswordGenerator {

    // define the possible characters for the password
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SYMBOLS = "!@#$%^&*()-_=+[]{}\\|;:'\",.<>/?";

    // combine all possible characters into one string
    private static final String ALL_CHARACTERS = LOWERCASE + UPPERCASE + NUMBERS + SYMBOLS;

    // create a SecureRandom object to generate random numbers
    private static final SecureRandom random = new SecureRandom();

    public static void main(String[] args) {
        int length = 12; // set the length of the password to be generated
        String password = generatePassword(length); // call the generatePassword method to create a new password
        System.out.println(password);
    }

    public static String generatePassword(int length) {

        // split the possible characters into separate strings
        String[] chars = { LOWERCASE, UPPERCASE, NUMBERS, SYMBOLS };

        StringBuilder password = new StringBuilder();

        // generate at least one character from each group
        for (String group : chars) {
            password.append(getRandomChar(group));
        }

        // generate the remaining characters randomly
        for (int i = chars.length; i < length; i++) {
            password.append(getRandomChar(ALL_CHARACTERS));
        }

        // shuffle the password to make it more random
        List<String> charList = Arrays.asList(password.toString().split(""));
        Collections.shuffle(charList);
        password = new StringBuilder();
        for (String character : charList) {
            password.append(character);
        }

        return password.toString();
    }

    // helper method to get a random character from a string
    private static char getRandomChar(String str) {
        int index = random.nextInt(str.length());
        return str.charAt(index);
    }

}
