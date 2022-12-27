public class Student extends Person //Student class is derived from Person class
{
    private int studentNumber; //instance variable to store studentNumber
    public Student(String initialName, int initialStudentNumber) //Constructor that includes initial values for all variables
    {
        super(initialName); //Inherit instance variable initialName from parent class
        studentNumber = initialStudentNumber;
    }
    public void reset(String newName, int newStudentNumber) //method used to change the name of the student, since the name variable is private, we cannot directly access it
    {
        setName(newName); //set new name for student
        studentNumber = newStudentNumber; //set new student number
    }
    public int getStudentNumber()
    {
        return studentNumber;
    } //accessor method for studentNumber
    public void setStudentNumber(int newStudentNumber) //mutator method for studentNumber
    {
        studentNumber = newStudentNumber;
    }
    public void writeOutput() //overrides the writeOutput() method from the Person class, and prints both the instance variables
    {
        System.out.println("Name: " + getName( ));
        System.out.println("Student Number: " + studentNumber);
    }
    public boolean equals(Student otherStudent) //method to compare if two students are the same. Not overridden from parent class because it has the same return type
    {
        return this.hasSameName(otherStudent) &&
                (this.studentNumber == otherStudent.studentNumber);
    }
}
