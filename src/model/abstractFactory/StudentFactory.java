package model.abstractFactory;

import model.ClassUnit;
import model.Student;
import model.Subject;

/**
 * Created by user on 17.06.2017.
 */
public class StudentFactory implements PersonFactory{

    @Override
    public Person getPerson() {
        return new Student();
    }

    @Override
    public Person getPerson(String firstName, String lastName, int id) {
        return new Student(firstName,lastName,id);
    }


}
