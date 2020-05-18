package com.qa.data;

public class User {
    String name;
    String Job;
    String id;
    String CreatedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        CreatedAt = createdAt;
    }

    public User(){

    }

    public User(String name, String Job){
        this.name= name;
        this.Job=Job;

    }

    //Getter and Setter


    public String getName() {
        return name;
    }

    public String getJob() {
        return Job;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJob(String job) {
        Job = job;
    }
}
