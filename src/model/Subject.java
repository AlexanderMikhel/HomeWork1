package model;


import java.io.Serializable;

public class Subject implements Serializable {
    private String name;
    private int SUBJECT_ID;
    public Subject(){}
    public Subject(String name,int id) {
        this.name = name;
        SUBJECT_ID = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getSUBJECT_ID() {
        return SUBJECT_ID;
    }

    public String toString(){
        return new String("SubjectID:"+getSUBJECT_ID()+", name: "+getName());
    }

}
