package com.lucas.soap;
/** Library Solos Rest.
 * @author Lucas Napoli
 * @author https://github.com/lucasnapolilapenda/SoapServer
 * @version 1.1
 * @since 1.0
 */

/**
 * Represents all the messages
 */

public class Response {

    private boolean status;
    private String message;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
