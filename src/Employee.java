public class Employee extends Person {
    private double salary;      // store salary as double
    private int hireDate;       // store hireDate as double
    private String ID;          // store ID as String

    public Employee(String initName, double initSalary, int initHireDate, String initID) {
        super(initName);            // call constructor of parent (Person) with name n
        salary = initSalary;        // initialize salary
        hireDate = initHireDate;    // initialize hireDate
        ID = initID;                // initialize ID
    }

    // getter and setter for salary
    public double getSalary() { return salary; }
    public void setSalary(double newSalary) { salary = newSalary; }

    // getter and setter for hireDate
    public int getHireDate() { return hireDate; }
    public void setHireDate(int newHireDate) { hireDate = newHireDate; }

    // getter and setter for ID
    public String getID() { return ID; }
    public void setID(String newID) { ID = newID; }

    public void writeOutput() {
        // output all info about an Employee
        System.out.printf("Name: %s\n", getName());
        System.out.printf("Employee ID: %s\n", ID);
        System.out.printf("Salary:  %.1f\n", salary);
        System.out.printf("Year of Hire: %d\n", hireDate);
    }

    public boolean equals(Employee e) {
        // returns true if all attributes of the current Employee object are identical to that of the passed in Employee object e
        return hasSameName(e) &&
                salary == e.getSalary() &&
                hireDate == e.getHireDate() &&
                ID.equalsIgnoreCase(e.getID());
    }
}
