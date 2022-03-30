package demo.springframework.model;

import java.time.LocalDateTime;

public class Message {
    public String author;
    public LocalDateTime timestamp;
    public String message;

    public Message(String author, String message){
        this.timestamp = LocalDateTime.now();
        this.author = author;
        this.message = message;
    }

    public Message(){
        this.timestamp = LocalDateTime.now();
    }

    public String getAuthor(){
        return this.author;
    }

    public LocalDateTime getTimeStamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
