package co03_01.clonetest;

import java.util.*;

/**
 * This program demonstrates cloning.
 *
 * @version 1.10 2002-07-01
 * @author Cay Horstmann
 */
public class CloneTest {

    public static void main(String[] args) {
        try {
            Employee original = new Employee("John Q. Public", 50000);
            original.setHireDay(2000, 1, 1);
            Employee copy = original.clone();
            copy.raiseSalary(10);
            copy.setHireDay(2002, 12, 31);
            System.out.println("original=" + original);
            System.out.println("copy=" + copy);
            original.walkTheDog();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}

interface DogLover {
    void walkTheDog();
    
    int a = 1; // w interfejsie pola domyślnie public static final, "dopisywane" z automatu 
}

class Employee implements Cloneable, DogLover {

    @Override
    public void walkTheDog() {
        System.out.println("I have no dog!!!");        
    }

    public Employee(String n, double s) {
        name = n;
        salary = s;
        hireDay = new Date();
    }

    public Employee clone() throws CloneNotSupportedException { //dziedziczona po object, nie musi być implementowana; interfejs znacznikwy/taggin interface
        // call Object.clone() ; string jest niezmienialny (not mutable), nie musi być "specjalnie klonowany"
        Employee cloned = (Employee) super.clone();

        // clone mutable fields
        cloned.hireDay = (Date) hireDay.clone();

        return cloned;
    }

    /**
     * Set the hire day to a given date.
     *
     * @param year the year of the hire day
     * @param month the month of the hire day
     * @param day the day of the hire day
     */
    public void setHireDay(int year, int month, int day) {
        Date newHireDay = new GregorianCalendar(year, month - 1, day).getTime();

        // Example of instance field mutation
        hireDay.setTime(newHireDay.getTime());
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    public String toString() {
        return "Employee[name=" + name + ",salary=" + salary + ",hireDay=" + hireDay + "]";
    }
    private String name;
    private double salary;
    private Date hireDay;
}