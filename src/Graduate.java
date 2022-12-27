enum GraduateProgram { //enum GraduateProgram that represents constant values MASTERS and DOCTORAL
    MASTERS,
    DOCTORAL
}

public class Graduate extends Student { //Graduate derives from Student class
    private GraduateProgram program; //instance variable that stores value MASTERS or DOCTORAL
    public Graduate(String initialName, int initialStudentNumber, GraduateProgram p) { //constructor that includes values inputs for all instance variables
        super(initialName, initialStudentNumber); //inherits all instance variables of parent classes
        program = p;
    }
    public GraduateProgram getProgram() {
        return program;
    } //accessor method for program value
    public void setProgram(GraduateProgram p) {
        program = p;
    } //mutator method for program value
    public void writeOutput() { //method to print the values of all the instance variables for a given graduate student.
        super.writeOutput(); //inherit writeOutput() from parent class Student
        System.out.println("Graduate Program: " + program);
    }
    public boolean equals(Graduate otherGraduate) { //method to compare if two Graduate students are the same
        return super.equals(otherGraduate) &&
                (program == otherGraduate.getProgram());
    }
}
