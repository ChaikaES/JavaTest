package org.example;

public class ValueException extends Exception{
    private String msg;
    ValueException(String msg){
        this.msg = msg;
    }
    public String getMsg(){
        return msg;
    }
}
