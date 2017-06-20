package model;


import model.abstractFactory.Person;

import java.io.Serializable;
import java.util.List;

public class ClassUnit implements Serializable{
    private List<Person> students;
    private Journal journal;
    private Person teacher;
    private int CLASS_UNIT_ID;

    public ClassUnit(){
        journal = new Journal();
    }
    public ClassUnit(int id,Person teacher){
        CLASS_UNIT_ID = id;
        this.teacher = teacher;
        journal = new Journal();
    }
    public ClassUnit(int id,List<Person> studentList,Person teacher){
        CLASS_UNIT_ID = id;
        this.teacher = teacher;
        students = studentList;
        journal = new Journal();
    }
    public int getCLASS_UNIT_ID(){
        return CLASS_UNIT_ID;
    }


    public Person getTeacher() {
        return teacher;
    }

    public void setTeacher(Person teacher) {
        this.teacher = teacher;
    }

    public List<Person> getStudents() {
        return students;
    }

    public void setStudents(List<Person> students) {
        this.students = students;
    }

    public Journal getJournal() {
        return journal;
    }

    public void setJournal(Journal journal) {
        this.journal = journal;
    }

    public String toString(){
        return new String("Number:"+getCLASS_UNIT_ID()+", class master: "+getTeacher().getFirstName()+" "+getTeacher().getLastName())+"\n";
    }

}
