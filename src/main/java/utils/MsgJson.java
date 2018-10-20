package utils;


import java.io.Serializable;

public class MsgJson implements Serializable{

    public boolean success ;
    public Object object;
    public String message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /*@Override
    public String toString() {
        return "{code:" + code + "," +
                "success:" + success + "," +
                "Object:" + object + "," +
                "message:" + message +
                "}";
    }*/
}
