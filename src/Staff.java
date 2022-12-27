public class Staff extends Employee { //Staff derives from Employee class
    private int payGrade; //int to store Staff members payGrade
    public Staff(String initName, double initSalary, int initHireDate, String initID, int pay) { //Constructor that creates an instance of a Staff member
        super(initName, initSalary,initHireDate, initID ); //inherit these values from parent class(es)
        payGrade = pay;
    }
    public int getPay() {
        return payGrade;
    }  //accessor method to access payGrade value
    public void setPayGrade(int newPay) { //mutator method to set payGrade value. Ensures that the given pay value is within the specified range 1-20
        if ((newPay<1) || (newPay>20)) {
            throw new IllegalArgumentException("Please enter a new value in the range 1-20"); //throw an exception is value falls outside specified range
        }
        this.payGrade = newPay; //if pay value is valid, set pay to this new value
    }
    public void writeOutput() { // output all info about a Staff member
        super.writeOutput(); //inherit writeOutput() from parent class Employee
        System.out.println("Pay Grade: " + getPay());
    }
    public boolean equal(Staff otherStaff) { //method to check to see if two Staff members are the same. Returns true if all attributes of the current Staff object are identical to that of the passed Staff member, otherStaff
        return super.equals(otherStaff) && (this.payGrade == otherStaff.payGrade);
    }
}