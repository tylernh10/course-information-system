import java.util.ArrayList;

public class Course {
    // instance variables for class Course
    private String courseNumber;
    private String courseName;
    private int numInstructors;
    private int numTeachingAssistants;
    private int numUnderGrad;
    private int numGrad;
    //construct new ArrayLists for instructors, teachingAssistants, and students
    private ArrayList<Faculty> instructors = new ArrayList<>(); //construct new ArrayLists
    private ArrayList<Staff> teachingAssistants = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();

    // constructor
    Course() {
        numInstructors = 0;
        numTeachingAssistants = 0;
        numUnderGrad = 0;
        numGrad = 0;
    }
    //accessor methods
    public String getCourseNumber() {
        return courseNumber;
    }
    public String getCourseName() {
        return courseName;
    }
    public int getNumEmployees() { return numInstructors + numTeachingAssistants; }
    public int getNumInstructors() { return numInstructors; }
    public int getNumTeachingAssistants() { return numTeachingAssistants; }
    public int getNumStudents() { return numUnderGrad + numGrad; }
    public int getNumUnderGrad() { return numUnderGrad; }
    public int getNumGrad() { return numGrad; }

    // get ArrayLists of data managers
    public ArrayList<Faculty> getInstructors() {
        return instructors;
    }
    public ArrayList<Staff> getTeachingAssistants() {
        return teachingAssistants;
    }
    public ArrayList<Student> getStudents() {
        return students;
    }

    // setters
    public void setCourseNumber(String number) {
        courseNumber = number;
    }
    public void setCourseName(String name) {
        courseName = name;
    }

    // setters for adding data managers
    public void addCourseInstructor(Faculty f) { //add the given faculty F to instructors
        // only add new Faculty member if the instructor size is less than 2 and the instructor is not already listed
        if (instructors.size() < 2) {
            for (Faculty fac: instructors) { // check to make sure the added faculty is not a duplicate
                if (fac.equals(f)) return;
            }
            instructors.add(f); // add to instructors ArrayList
            numInstructors++; // increment number of instructors
        }
    }
    public void addTeachingAssistant(Staff s) { //add given staff member to TeachingAssistants
        // only add new Staff member if the teachingAssistants size is less than 5 and the staff is not already listed
        if (teachingAssistants.size() < 5) { // A course can have at the most five teaching assistants
            for (Staff ta: teachingAssistants) { // check to make sure added staff is not a duplicate
                if (ta.equals(s)) return;
            }
            teachingAssistants.add(s); // add to teachingAssistants ArrayList
            numTeachingAssistants++; // increment number of teaching assistants
        }
    }
    public void addUndergrad(Undergraduate u) { //add given undergrad u as an Undergraduate
        for (Student s: students) {
            if (u.getClass().equals(s.getClass())) { // check to make sure the added student is not a duplicate
                if (s.equals(u)) return;
            }
        }
        students.add(u);// add to students ArrayList
        numUnderGrad++; // increment number of undergrad
    }

    public void addGrad(Graduate g) { //method to add a new graduate member, g, as a student
        for (Student s: students) {
            if (g.getClass().equals(s.getClass())) { // check to make sure that the added student is not a duplicate
                if (s.equals(g)) return;
            }
        }
        students.add(g); // add to students ArrayList
        numGrad++; // increment number of grads
    }
}
