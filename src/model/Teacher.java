package model;

import model.abstractFactory.Person;

import java.io.Serializable;

/**
 * Created by user on 17.06.2017.
 */
public class Teacher implements Person,Serializable {
    private String firstName;
    private String lastName;
    private int TEACHER_ID;
    private Subject subject;

    public Teacher(){}

    public Teacher(String firstName, String lastName, int TEACHER_ID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.TEACHER_ID = TEACHER_ID;
    }

    public Teacher(String firstName, String lastName, int id, Subject subject){
        this.firstName = firstName;
        this.lastName = lastName;
        this.TEACHER_ID = id;
        this.subject = subject;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }
    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @Override
    public String getLastName() {
        return lastName;
    }
    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Override
    public int getID() {
        return TEACHER_ID;
    }

    public Subject getSubject() {
        return subject;
    }
    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String toString(){
        return new String("TeacherID:"+getID()+", "+getFirstName()
                +" "+getLastName()+", teaching subject: "+subject.getName());
    }
}
