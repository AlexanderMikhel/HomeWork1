package controller;


import model.*;
import model.Exceptions.NotFoundObjectExceptions;
import model.Exceptions.NotValidateParametrException;
import model.abstractFactory.Person;
import model.abstractFactory.PersonFactory;
import model.abstractFactory.StudentFactory;
import model.abstractFactory.TeacherFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class SchoolController {
    private final String FILE_NAME = "data.dat";
    private School school;
    private PersonFactory studentFactory;
    private PersonFactory teacherFactory;

    public SchoolController(){
        school = new School();
        studentFactory = new StudentFactory();
        teacherFactory = new TeacherFactory();
    }

    /**this method use for adding school object
     * @throws NotFoundObjectExceptions
     * @throws NotValidateParametrException
     */

    public void addSubject(String name){
        school.getSubjects().add(new Subject(name,school.getSUBJECT_ID()));
        school.SubjectAutoIncr();
    }
    public void addClassUnit(int teacherID) throws NotFoundObjectExceptions {
        school.getClassUnits().add(new ClassUnit(school.getCLASS_UNIT_ID(),getTeacherbyID(teacherID)));
        school.ClassUnitIncr();
    }
    public void addTeacher(String firstName, String lastName,int SubjectID) throws NotFoundObjectExceptions {
        Teacher teacher = (Teacher) teacherFactory.getPerson(firstName,lastName,school.getTEACHER_ID());
        teacher.setSubject(getSubjectbyID(SubjectID));
        school.getTeachers().add(teacher);
        school.TeacherAutoIncr();

    }
    public void addStudent(String firstName, String lastName,int ClassID) throws NotFoundObjectExceptions {
        Student student = (Student) studentFactory.getPerson(firstName,lastName,school.getSTUDENT_ID());
        student.setClassUnit(getClassbyID(ClassID));
        school.getStudents().add(student);
        school.StudentAutoIncr();
    }
    public void addMark(int value, int day, int month, int TeacherID,int StudentID,int SubjectID,int ClassID) throws NotFoundObjectExceptions, NotValidateParametrException {
        if(value<0 || value >5)
            throw new NotValidateParametrException("value mast be between 1 and 5");
        if(day < 0 || day >31 || month < 0 || month >12)
            throw new NotValidateParametrException("day mast be between 1 and 31, month between 1 and 12");
        ClassUnit classUnit = getClassbyID(ClassID);
        int markID = school.getMARK_ID();
        Teacher teacher = (Teacher) getTeacherbyID(TeacherID);
        Student student = (Student) getStudentbyID(StudentID);
        Subject subject = getSubjectbyID(SubjectID);
        Calendar calendar = new GregorianCalendar(2017,month,day);
        classUnit.getJournal().getMarks().add(new Mark(markID,value,calendar,subject,teacher,student));
        school.MarkAutoIncr();

    }

    /**this method use for get some school object by ID number
     * @throws NotFoundObjectExceptions
     */

    public Person getTeacherbyID(int teacherID) throws NotFoundObjectExceptions {
        for(Person person: school.getTeachers())
            if(person.getID() == teacherID)
                return person;
        throw new NotFoundObjectExceptions("Could not find a teacher with this ID");
    }
    public Person getStudentbyID(int studentID) throws NotFoundObjectExceptions {
        for(Person person: school.getStudents())
            if(person.getID() == studentID)
                return person;
        throw new NotFoundObjectExceptions("Could not find a student with this ID");
    }
    public Subject getSubjectbyID(int subjectID) throws NotFoundObjectExceptions {
        for(Subject subject: school.getSubjects())
            if(subject.getSUBJECT_ID() == subjectID)
                return subject;
        throw new NotFoundObjectExceptions("Could not find a subject with this ID");
    }
    public ClassUnit getClassbyID(int classID) throws NotFoundObjectExceptions {
        for(ClassUnit classUnit: school.getClassUnits())
            if(classUnit.getCLASS_UNIT_ID() == classID)
                return classUnit;
        throw new NotFoundObjectExceptions("Could not find a class with this ID");
    }
    public Mark getMarkbyID(int markID,int classID) throws NotFoundObjectExceptions {
        for(Mark mark:getClassbyID(classID).getJournal().getMarks())
            if(mark.getMARK_ID() == markID)
                return mark;
        throw new NotFoundObjectExceptions("Could not find a mark with this ID");

    }

    /**
     * @param markID
     * @throws NotFoundObjectExceptions
     */
    public void deleteMark(int markID) throws NotFoundObjectExceptions {

        for (ClassUnit classUnit:school.getClassUnits()){
                if(classUnit.getJournal().getMarks().contains(getMarkbyID(markID,classUnit.getCLASS_UNIT_ID())));
                        classUnit.getJournal().getMarks().remove(getMarkbyID(markID,classUnit.getCLASS_UNIT_ID()));
                        break;
        }
    }

    /**
     * @param markID
     * @param value
     * @throws NotFoundObjectExceptions
     * @throws NotValidateParametrException
     */
    public void changeMark(int markID, int value) throws NotFoundObjectExceptions, NotValidateParametrException {
        if(value<0 || value >5)
            throw new NotValidateParametrException("value mast be between 1 and 5");
        for (ClassUnit classUnit:school.getClassUnits()){
            if(classUnit.getJournal().getMarks().contains(getMarkbyID(markID,classUnit.getCLASS_UNIT_ID()))){
                Mark mark = getMarkbyID(markID,classUnit.getCLASS_UNIT_ID());
                mark.setValue(value);
                break;
            }
        }
    }


    /**
     * this method use for serialization and deserialization
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void saveData() throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
        out.writeObject(school);
    }
    public void readData() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(FILE_NAME);
        ObjectInputStream in = new ObjectInputStream(fis);
        school = (School) in.readObject();
    }

    /**
     * this method use for get String about some object
     */
    public String getAllClassestoString(){
        String str = new String();
        for (ClassUnit classUnit: school.getClassUnits()){
            str += classUnit.toString();

       }
       return str;
    }
    public String getAllTeacherstoString(){
        String str = new String();
        for (Person teacher: school.getTeachers()){
            str += teacher.toString()+"\n";
        }
        return str;
    }
    public String getAllStudentstoString(){
        String str = new String();
        for (Person student: school.getStudents()){
            str +=student.toString();
        }
        return str;
    }
    public String getAllSubjectstoString(){
        String str = new String();
        for (Subject subject: school.getSubjects()){
            str +=subject.toString()+"\n";
        }
        return str;
    }
    public String getAllMarkstoString() throws NotFoundObjectExceptions {
        String str = new String();
        int count = 1;
        while (count < school.getCLASS_UNIT_ID()) {
            for (Mark mark : getClassbyID(count).getJournal().getMarks()) {
                str += mark.toString()+"\n";
            }
            count++;
        }
        if(str.isEmpty())
            str = "have no one mark, please add them";
        return str;
    }
    public String getMarksInClasstoString(int classID) throws NotFoundObjectExceptions {
        String str = new String();
        for (Mark mark:getClassbyID(classID).getJournal().getMarks()){
            str += mark.toString();
        }
        if(str.isEmpty())
            str = "have no one mark in this class, please add them";
        return str;
    }


}
