package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Journal implements Serializable {
    private List<Mark> marks;

    public Journal(){
        marks = new ArrayList<>();
    }
    public List<Mark> getMarks() {
        return marks;
    }
    public void setMarks(List<Mark> marks) {
        this.marks = marks;
    }

    public String toString(){
        String str = new String();
        for(Mark mark: marks){
            str+=mark.toString()+"\n";
        }
        return str;
    }

}
