package model.abstractFactory;

import model.ClassUnit;
import model.Subject;

/**
 * Created by user on 17.06.2017.
 */
public interface PersonFactory {
    Person getPerson();
    Person getPerson(String firstName, String lastName, int id);

}
