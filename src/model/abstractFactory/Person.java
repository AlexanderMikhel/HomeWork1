package model.abstractFactory;

/**
 * Created by user on 17.06.2017.
 */
public interface Person {
    String getFirstName();
    String getLastName();
    void setFirstName(String firstName);
    void setLastName(String lastName);
    int getID();
}
