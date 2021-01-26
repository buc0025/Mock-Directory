import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SearchNumbers {

    public static void main(String[] args) throws IOException {
        File parentNumbers = new File("C:\\Users\\yangPC\\IdeaProjects\\DirectoryDemo/Directory/parents/parentNumbers.txt");
        Scanner scanner = new Scanner(parentNumbers);

        // Scanning through parentNumbers in parents subdirectory for valid phone numbers
        while (scanner.hasNext()) {
            String num = scanner.next();

            if (num.length() == 10 && num.matches("[0-9]+")) {
                System.out.println(num);
            } else if (isValidNumber(num)) {
                System.out.println(num);
              }
        }
    }

    public static boolean isValidNumber(String num) {
        for (int i = 0; i < num.length(); i++) {
            if (i == 3 || i == 7) {
                if (num.charAt(i) != '-') {
                    return false;
                }
            } else if (!num.substring(i, i + 1).matches("[0-9]+")) {
                return false;
            }
        }
        return true;
    }
}
