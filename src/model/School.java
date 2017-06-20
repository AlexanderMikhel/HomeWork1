package model;

import model.abstractFactory.Person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 17.06.2017.
 */
public class School implements Serializable {
    private int STUDENT_ID;
    private int TEACHER_ID;
    private int SUBJECT_ID;
    private int CLASS_UNIT_ID;
    private int MARK_ID;
    private List<Person> students;
    private List<Person> teachers;
    private List<Subject> subjects;
    private List<ClassUnit> classUnits;

    public School(){
        STUDENT_ID = 1;
        TEACHER_ID = 1;
        SUBJECT_ID = 1;
        CLASS_UNIT_ID = 1;
        MARK_ID = 1;
        students = new ArrayList<>();
        teachers = new ArrayList<>();
        subjects = new ArrayList<>();
        classUnits = new ArrayList<>();
    }

    public void MarkAutoIncr(){MARK_ID++;}
    public void SubjectAutoIncr(){
        SUBJECT_ID++;
    }
    public void StudentAutoIncr(){
        STUDENT_ID++;
    }
    public void TeacherAutoIncr(){
        TEACHER_ID++;
    }
    public void ClassUnitIncr(){
        CLASS_UNIT_ID++;
    }

    public int getSTUDENT_ID() {
        return STUDENT_ID;
    }
    public int getMARK_ID(){
        return MARK_ID;
    }
    public int getTEACHER_ID() {
        return TEACHER_ID;
    }

    public int getSUBJECT_ID() {
        return SUBJECT_ID;
    }

    public int getCLASS_UNIT_ID() {
        return CLASS_UNIT_ID;
    }

    public List<Person> getStudents() {
        return students;
    }

    public void setStudents(List<Person> students) {
        this.students = students;
    }

    public List<Person> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Person> teachers) {
        this.teachers = teachers;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public List<ClassUnit> getClassUnits() {
        return classUnits;
    }

    public void setClassUnits(List<ClassUnit> classUnits) {
        this.classUnits = classUnits;
    }
}
