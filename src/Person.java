public class Person
{
    private String name; //instance variable that stores name
    public Person(String initialName)
    {
        name = initialName;
    } //constructor that accepts instance variable name as input
    public void setName(String newName)
    {
        name = newName;
    } //mutator method to set new name
    public String getName()
    {
        return name;
    } //accessor method to access name
    public void writeOutput() // print the name of the person.
    {
        System.out.println("Name: " + name);
    }
    public boolean hasSameName(Person otherPerson)
    {
        return this.name.equalsIgnoreCase(otherPerson.name);
    } //returns true if the two persons being compared have the same name
}
