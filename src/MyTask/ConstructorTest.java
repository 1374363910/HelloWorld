package MyTask;

import java.util.Random;

public class ConstructorTest {
    public static void main(String[] args) {
        Employee[] Staff = new Employee[3];

        Staff[0] = new Employee("Harry",40000);
        Staff[1] = new Employee(60000);
        Staff[2] = new Employee();

        for (Employee aEmloyee : Staff){
            System.out.println("name="+aEmloyee.getName()+ ",id="+aEmloyee.getId()
                    +",salary="+aEmloyee.getSalary());
        }
    }
}
class Employee{
    private static int nextId;

    private int id;
    private String name = "";
    private double salary;

    static {
        Random generator = new Random();
        nextId = generator.nextInt(10000);
    }

    {
        id = nextId;
        nextId++;
    }

    public Employee(String aName,double aSalary){
        this.name = aName;
        this.salary = aSalary;
    }

    public Employee(double aSalary){
        this("Employee #"+nextId,aSalary);
    }

    public Employee(){}

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }
}