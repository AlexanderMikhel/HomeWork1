package model;

import model.abstractFactory.Person;

import javax.naming.directory.SearchResult;
import java.io.Serializable;
import java.util.Calendar;

/**
 * Created by user on 17.06.2017.
 */
public class Mark implements Serializable{
    private int MARK_ID;
    private int value;
    private Calendar date;
    private Subject subject;
    private Person teacher;
    private Person student;

    public Mark(){}

    public Mark(int MARK_ID, int value, Calendar date, Subject subject, Person teacher, Person student) {
        this.MARK_ID = MARK_ID;
        this.value = value;
        this.date = date;
        this.subject = subject;
        this.teacher = teacher;
        this.student = student;
    }

    public int getMARK_ID() {
        return MARK_ID;
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public Calendar getDate() {
        return date;
    }
    public void setDate(Calendar date) {
        this.date = date;
    }
    public Subject getSubject() {
        return subject;
    }
    public void setSubject(Subject subject) {
        this.subject = subject;
    }
    public Person getTeacher() {
        return teacher;
    }
    public void setTeacher(Person teacher) {
        this.teacher = teacher;
    }
    public Person getStudent() {
        return student;
    }
    public void setStudent(Person student) {
        this.student = student;
    }

    public String toString(){
        return new String("MarkID:"+getMARK_ID()+", date: "+date.get(Calendar.YEAR)+"."
                +date.get(Calendar.MONTH)+"."+date.get(Calendar.DATE)+", value: "+getValue()+" by subject: "
                +getSubject().getName()+"\nto student: "+getStudent().toString())+"from teacher: "+getTeacher().getFirstName()+" "+getTeacher().getLastName();
    }

}
