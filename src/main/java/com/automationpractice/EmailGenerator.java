package com.automationpractice;

public class EmailGenerator {

    private Character a = 97; //a
    private Character z = 122; //z
    private int delta = z - a;
    private  int emailNameLength = 8;
    private String domain= "gmail.com";

    EmailGenerator(){
        domain = "gmail.com";
        emailNameLength = 8;
    }

    EmailGenerator(String domain){
        this.domain = domain;
    }

    EmailGenerator(int emailNameLength){
        this.emailNameLength = emailNameLength;
    }

    EmailGenerator(int emailNameLength, String domain){
        this.domain = domain;
        this.emailNameLength = emailNameLength;
    }

    EmailGenerator(String domain, int emailNameLength){
        this.domain = domain;
        this.emailNameLength = emailNameLength;
    }

    private String getLetter(){
        Character letter = (char)((int)a + (int)(Math.random()*delta));
        return letter.toString();
    }

    public String getEmail(){
        String name = "";
        for (int i = 0; i < emailNameLength; i++){
            name += getLetter();
        }
        return name + "@" + domain;
    }

}
