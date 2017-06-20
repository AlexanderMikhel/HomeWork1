package model;

import model.abstractFactory.Person;

import java.io.Serializable;

/**
 * Created by user on 17.06.2017.
 */
public class Student implements Person,Serializable{
    private String firstName;
    private String lastName;
    private int STUDENT_ID;
    private ClassUnit classUnit;
    public Student(){}

    public Student(String firstName, String lastName, int STUDENT_ID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.STUDENT_ID = STUDENT_ID;
    }

    public Student(String firstName, String lastName, int STUDENT_ID, ClassUnit classUnit) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.STUDENT_ID = STUDENT_ID;
        this.classUnit = classUnit;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }
    @Override
    public String getLastName() {
        return lastName;
    }
    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Override
    public int getID() {
        return STUDENT_ID;
    }

    public ClassUnit getClassUnit() {
        return classUnit;
    }
    public void setClassUnit(ClassUnit classUnit) {
        this.classUnit = classUnit;
    }

    @Override
    public String toString(){
        return new String("StudentID:"+getID()+", "+getFirstName()
                +" "+getLastName()+", class: "+getClassUnit().getCLASS_UNIT_ID())+"\n";
    }
}
