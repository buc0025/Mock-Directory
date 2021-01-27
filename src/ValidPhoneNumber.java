import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ValidPhoneNumber {

    public static void main(String[] args) throws IOException {

        // Class is strictly used to go through every number in phone number column to check if it's a valid phone number
        String path = "C:/Users/yangPC/IdeaProjects/DirectoryDemo/src/MOCK_DATA.csv";
        String line = "";

        BufferedReader br = new BufferedReader(new FileReader(path));
        br.readLine();

        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            String number = values[4];
            if (isValidPhoneNumber(number)) {
                System.out.println("Phone Number: " + number + " is a valid phone number");
            } else {
                System.out.println("Phone Number: " + number + " is not a valid phone number");
            }
        }
    }

    public static boolean isValidPhoneNumber(String number) {
        number = number.replaceAll("[^0-9]", "");
        if (number.length() == 10 || number.length() == 11) {
            return true;
        } else {
            return false;
        }
    }
}
