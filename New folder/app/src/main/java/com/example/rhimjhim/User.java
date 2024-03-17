package com.example.rhimjhim;

public class User {
    public String userName;
    public String userPassword;
    public String phoneNo;
    public String email;

    public User(){

    }
    public User(String userName,String userPassword,String phoneNo,String email){
        this.userName=userName;
        this.email=email;
        this.phoneNo=phoneNo;
        this.userPassword=userPassword;
    }
}
