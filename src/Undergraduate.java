enum Grade { //enum Grade that represents constant values FRESHMAN, SOPHOMORE, JUNIOR and SENIOR
    FRESHMAN,
    SOPHOMORE,
    JUNIOR,
    SENIOR
}
public class Undergraduate extends Student { //Undergraduate derives from Student class
    private Grade level; //instance variable that stores value FRESHMAN, SOPHOMORE, JUNIOR or SENIOR
    public Undergraduate(String initialName, int initialStudentNumber, Grade l) { //constructor that includes values inputs for all instance variables
        super(initialName, initialStudentNumber); //inherits all instance variables of parent classes
        level = l;
    }
    public Grade getLevel() {
        return level;
    } //accessor method for level
    public void setLevel(Grade l) {
        level = l;
    } //mutator method for level
    public void writeOutput() { //method to print the values of all the instance variables for a given undergraduate.
        super.writeOutput(); //inherit writeOutput() from parent class Student
        System.out.println("Grade Level: " + getLevel());
    }
    public boolean equals(Undergraduate otherUndergrad) { //method to compare if two undergraduates are the same
        return super.equals(otherUndergrad) && (this.level == otherUndergrad.getLevel());
    }


}