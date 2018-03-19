package fr.mowitnow.mower2.model;

public class BusinessException extends Exception {
    public BusinessException(){
        super();
    }

    public BusinessException(String message){
        super(message);
    }
}
