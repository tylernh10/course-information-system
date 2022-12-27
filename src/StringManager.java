// holds references to important strings needed
// CourseReport queries this class to get strings instead of having them all written in directly
public class StringManager {
    public StringManager() {}
    public String getFilePromptString() { //prompts the user for the name of the input file that contains course details
        return "Please enter the name of the file that stores course information: ";
    }
    public String getOptionsPrompt() { //prompt user for which option they would like to use
        return "What would you like to know?";
    }
    public String getOptionsStrings(int option) { //menu of command-line options:
        if (option == 1) return "1. Name of the course.";
        else if (option == 2) return "2. Number of the course.";
        else if (option == 3) return "3. How many employees?";
        else if (option == 4) return "4. Who are the instructors?";
        else if (option == 5) return "5. Who are the teaching assistants?";
        else if (option == 6) return "6. How many instructors are teaching?";
        else if (option == 7) return "7. How many teaching assistants?";
        else if (option == 8) return "8. How many students?";
        else if (option == 9) return "9. How many graduate students?";
        else if (option == 10) return "10. How many undergraduate students?";
        else if (option == 11) return "11. How many freshman/sophomore/juniors/seniors?";
        else if (option == 12) return "12. How many masters/doctoral students?";
        else return "13. Find a specific student, either based on the student's\n" +
                    "name or student number.";
    }//prompt user until they choose to exit
    public String getExitString() { //exit program
        return "exit";
    }
}
