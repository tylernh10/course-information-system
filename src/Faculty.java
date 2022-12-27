import java.util.Objects;

public class Faculty extends Employee { //Faculty class derives from Employee class
    private String title; //title of faculty stored as a String
    public Faculty(String initName, double initSalary, int initHireDate, String initID, String t) {
        super(initName, initSalary, initHireDate, initID);
        title = t;
    }
    public void setTitle(String t) {
        title = t;
    } //mutator method for title of faculty
    public String getTitle() {
        return title;
    } //accessor method for title of faculty
    public void writeOutput() { //method to print the values of all the instance variables for a given faculty.
        super.writeOutput(); //inherit writeOutput() from parent class
        System.out.println("Title: " + title);
    }
    public boolean equals(Faculty f) { //method to check to see if two faculties are the same
        return super.equals(f) &&
                Objects.equals(title, f.getTitle());
    }
}
