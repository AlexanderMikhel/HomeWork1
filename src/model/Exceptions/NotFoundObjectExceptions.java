package model.Exceptions;

/**
 * Created by user on 18.06.2017.
 */
public class NotFoundObjectExceptions extends Exception {
    public NotFoundObjectExceptions(){

    }
    public NotFoundObjectExceptions(String str){
        super(str);
    }
}
