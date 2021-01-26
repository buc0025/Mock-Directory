import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;

public class CreateDirectory {

    public static void main(String[] args) throws IOException {

        File directory = new File("Directory");

        // Creating directory
        if (!directory.exists()) {
            if (directory.mkdir()) {
                System.out.println("Directory is created");
            } else {
                System.out.println("Directory is not created");
            }
        }

        File parents = new File("Directory/parents");

        // Creating subdirectory for parents
        if (!parents.exists()) {
            if (parents.mkdir()) {
                System.out.println("Parents subdirectory is created");
                File parentNumbers = new File("Directory/parents/parentNumbers.txt");
                parentNumbers.createNewFile();
            } else {
                System.out.println("Parents subdirectory is not created");
            }
        }

        File teachers = new File("Directory/teachers");
        // Creating subdirectory for teachers
        if (!teachers.exists()) {
            if (teachers.mkdir()) {
                System.out.println("Teachers subdirectory is created");
                File teacherNumbers = new File("Directory/teachers/teacherNumbers.txt");
                teacherNumbers.createNewFile();
            } else {
                System.out.println("Teachers subdirectory is not created");
            }
        }

    }
}
