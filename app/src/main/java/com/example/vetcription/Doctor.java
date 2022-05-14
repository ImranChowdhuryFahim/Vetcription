package com.example.vetcription;

public class Doctor {
    String name,regi,phone,email,password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegi() {
        return regi;
    }

    public void setRegi(String regi) {
        this.regi = regi;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Doctor(String name, String regi, String phone, String email, String password) {
        this.name = name;
        this.regi = regi;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }
}
