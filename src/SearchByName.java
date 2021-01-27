import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SearchByName {

    public static void main(String[] args) {
        // Class asks user if they want to search for phone number and returns phone number if it's valid
        // Data is cached and reused if user asks for same phone number again
        Scanner input = new Scanner(System.in);

        String path = "C:/Users/yangPC/IdeaProjects/DirectoryDemo/src/MOCK_DATA.csv";
        String line = "";

        Record record = new Record("", "", "", "");
        Map<String, String> mapLastNamePhoneNumber = new HashMap<>();

        while (true) {
            System.out.println("Do you want to search for phone number by last name?");
            String answer = input.next();
            if (answer.equals("no")) {
                break;
            }
            System.out.println("What is the last name?");
            String name = input.next();
            // Checks for input in map before going through csv file
            if (mapLastNamePhoneNumber.containsKey(name)) {
                System.out.println(mapLastNamePhoneNumber.get(name));
            } else {
                try {
                    BufferedReader br = new BufferedReader(new FileReader(path));
                    br.readLine();

                    int numberOfLastNames = 0;
                    int numberOfNoMatches = 0;

                    while ((line = br.readLine()) != null) {
                        String[] values = line.split(",");
                        String id = values[0];
                        String firstName = values[1];
                        String lastName = values[2];
                        String phoneNumber = values[4];

                        // Data is cached if input matches last name in csv file
                        if (name.equals(lastName)) {
                            record = new Record(id, firstName, lastName, phoneNumber);
                            mapLastNamePhoneNumber.put(lastName, record.getPhoneNumber());
                            System.out.println(record.getPhoneNumber());
                        }
                        if (!name.equals(lastName)) {
                            numberOfNoMatches++;
                        }
                        numberOfLastNames++;
                    }
                    if (numberOfLastNames == numberOfNoMatches) {
                        System.out.println("Name not found in file");
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("End of search");
    }
}
