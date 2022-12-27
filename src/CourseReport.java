import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CourseReport {
    private static Parser parser = new Parser();
    private static Course course = new Course();
    private static StringManager stringManager = new StringManager();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // initialize new scanner
        System.out.print(stringManager.getFilePromptString()); // prompt user to enter filename to read course info from
        String inputFileName = sc.nextLine(); // get user input

        ArrayList<String[]> parsedCourseData = readData(inputFileName); // calls function to get array of lines from input file

        // for each string, use parser to find what type it is, and then use getter to find the updated information that has been parsed and updated in the parser
        for (String[] s: parsedCourseData) {
            LineType l = parser.parseLine(s);
            if (l == LineType.NUMBER) {
                course.setCourseNumber(parser.getNumber());
            }
            if (l == LineType.NAME) {
                course.setCourseName(parser.getName());
            }
            if (l == LineType.INSTRUCTOR) {
                course.addCourseInstructor(parser.getInstructor());
            }
            if (l == LineType.STAFF) {
                course.addTeachingAssistant(parser.getTeachingAssistant());
            }
            if (l == LineType.UNDERGRADUATE) {
                course.addUndergrad(parser.getUndergraduate());
            }
            if (l == LineType.GRADUATE) {
                course.addGrad(parser.getGraduate());
            }
        }

        input(sc);
        sc.close(); // close scanner
    }

    // reads data from file and returns list of unparsed strings representing employees
    private static ArrayList<String[]> readData(String inputFileName) {
        ArrayList<String[]> unparsedCourseData = new ArrayList<>(); // array to store unparsed course data
        Scanner fileInputScanner = null; // initialize
        // try/catch to make sure input file is valid
        try {
            fileInputScanner = new Scanner(new File(inputFileName));
        } catch(FileNotFoundException e) {
            System.out.println("Error opening the input file " + inputFileName); // display error message and exit if file is not found
            System.exit(0);
        }
        // read all lines from file and append each to array
        while (fileInputScanner.hasNextLine()) {
            unparsedCourseData.add(fileInputScanner.nextLine().split(";", 0));
        }
        return unparsedCourseData; // return list of unparsed course data lines
    }
    private static void input(Scanner sc) {
        initialOutput();
        while (sc.hasNextLine()) { // in a while loop, displays user output, displaying info based on their request until they press exit
            String x = sc.nextLine();
            if (stringManager.getExitString().equals(x)) {
                break;
            } else {
                int choice = Integer.parseInt(x);
                makeChoice(choice, sc); // call to function that displays information based on the option the user selects
            }
            initialOutput();
        }
    }
    private static void initialOutput() { // prints menu of options to user by querying strings from stringManager
        System.out.println(stringManager.getOptionsPrompt());
        for (int i = 0; i < 13; i++) {
            System.out.println(stringManager.getOptionsStrings(i+1));
        }
    }
    private static void makeChoice(int c, Scanner sc) { // based on the choice the user selects, display the appropriate output
        if (c == 1) {
            displayCourseName();
        } else if (c == 2) {
            displayCourseNumber();
        } else if (c == 3) {
            displayNumEmployees();
        } else if (c == 4) {
            displayInstructors();
        } else if (c == 5) {
            displayTeachingAssistants();
        } else if (c == 6) {
            displayNumInstructors();
        } else if (c == 7) {
            displayNumTeachingAssistants();
        } else if (c == 8) {
            displayNumStudents();
        } else if (c == 9) {
            displayNumGradStudents();
        } else if (c == 10) {
            displayNumUndergradStudents();
        } else if (c == 11) {
            displayNumberGrades();
        } else if (c == 12) {
            displayNumberUpperLevels();
        } else if (c == 13) {
            getStudentByNameOrNumber(sc);
        }
        if (c != 4 && c != 5 && c != 13) {
            System.out.println();
        }
    }
    // functions below use the course data container to display the correct info based on the option selected by user
    private static void displayCourseName() {
        System.out.println(course.getCourseName());
    } // output course name
    private static void displayCourseNumber() {
        System.out.println(course.getCourseNumber());
    } // output course number
    private static void displayNumEmployees() { // output number of employees
        System.out.printf("Number of employees: %d\n", course.getNumEmployees());
    }
    private static void displayInstructors() { // display all instructors in ArrayList of instructors
        for (Employee e: course.getInstructors()) {
            e.writeOutput();
            System.out.println();
        }
    }
    private static void displayTeachingAssistants() { // display all teaching assistants in ArrayList of teaching assistants
        for (Employee e: course.getTeachingAssistants()) {
            e.writeOutput();
            System.out.println();
        }
    }
    private static void displayNumInstructors() { // output number of instructors
        System.out.printf("Number of instructors: %d\n", course.getNumInstructors());
    }
    private static void displayNumTeachingAssistants() { // output number of teaching assistants
        System.out.printf("Number of teaching assistants: %d\n", course.getNumTeachingAssistants());
    }
    private static void displayNumStudents() {
        System.out.printf("Number of students: %d\n", course.getNumStudents()); // output number of students
    }
    private static void displayNumGradStudents() { // output number of grad students
        System.out.printf("Number of grad students: %d\n", course.getNumGrad());
    }
    private static void displayNumUndergradStudents() { // output number of undergrad students
        System.out.printf("Number of undergrad students: %d\n", course.getNumUnderGrad());
    }
    private static void displayNumberGrades() { // count the number of people at each undergrad level and display counts
        int fresh = 0;
        int soph = 0;
        int jun = 0;
        int sen = 0;
        for (Student e: course.getStudents()) {
            if (e.getClass().equals(Undergraduate.class)) {
                Undergraduate u = (Undergraduate) e;
                if (u.getLevel() == Grade.FRESHMAN) {
                    fresh++;
                } else if (u.getLevel() == Grade.SOPHOMORE) {
                    soph++;
                } else if (u.getLevel() == Grade.JUNIOR) {
                    jun++;
                } else {
                    sen++;
                }
            }
        }
        System.out.printf("Number of freshman: %d\n", fresh);
        System.out.printf("Number of sophomores: %d\n", soph);
        System.out.printf("Number of juniors: %d\n", jun);
        System.out.printf("Number of seniors: %d\n", sen);
    }
    private static void displayNumberUpperLevels() { // find number of people at each grad level and display counts
        int masters = 0;
        int doctorate = 0;
        for (Student e: course.getStudents()) {
            if (e.getClass().equals(Graduate.class)) {
                Graduate g = (Graduate) e;
                if (g.getProgram() == GraduateProgram.MASTERS) {
                    masters++;
                } else {
                    doctorate++;
                }
            }
        }
        System.out.printf("Number of masters students: %d\n", masters);
        System.out.printf("Number of doctoral students: %d\n", doctorate);
    }
    private static void getStudentByNameOrNumber(Scanner sc) { // take input of a student's name or number, output the student's info if there is a match
        System.out.print("Enter a student's name or number: ");
        String nameOrNum = sc.nextLine();
        boolean printed = false;
        for (Student s: course.getStudents()) {
            if (nameOrNum.equals(s.getName())) {
                s.writeOutput();
                System.out.println();
                printed = true;
            }
        }
        int num;
        try {
            num = Integer.parseInt(nameOrNum);
        } catch (Exception e) {
            System.out.println("Student not found\n");
            return;
        }
        for (Student s: course.getStudents()) {
            if (s.getStudentNumber() == num) {
                s.writeOutput();
                System.out.println();
                printed = true;
            }
        }
        if (!printed) {
            System.out.println("Student not found\n");
        }
    }
}
