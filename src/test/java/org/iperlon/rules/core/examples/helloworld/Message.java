package org.iperlon.rules.core.examples.helloworld;

/**
 * Created by rodriguc on 11.11.2015.
 */
public class Message {

    public final static int HELLO = 0;
    public final static int GOODBYE = 1;


    private String message;

    private Integer status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
