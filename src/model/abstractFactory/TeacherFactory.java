package model.abstractFactory;

import model.Teacher;

/**
 * Created by user on 17.06.2017.
 */
public class TeacherFactory implements PersonFactory {
    @Override
    public Person getPerson() {
        return new Teacher();
    }

    @Override
    public Person getPerson(String firstName, String lastName, int id) {
        return new Teacher(firstName,lastName,id);
    }
}
