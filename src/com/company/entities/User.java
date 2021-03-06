package com.company.entities;

public class User {
    private String name;
    private String surname;
    private String username;
    private String password;
    private int account;
    private int age;
    private String contact_number;
    private String address;

    public User(String name, String surname, String username, String password, int account, int age, String contact_number, String address) {
        setName(name);
        setSurname(surname);
        setUsername(username);
        setPassword(password);
        setAccount(account);
        setAge(age);
        setContact_number(contact_number);
        setAddress(address);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getAccount() {
        return account;
    }
    public void setAccount(int account) {
        this.account = account;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getContact_number() {
        return contact_number;
    }
    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "name = '" + name + '\'' +
                ", surname = '" + surname + '\'' +
                ", username = '" + username + '\'' +
                ", password = '" + password + '\'' +
                ", account = " + account +
                ", age = " + age +
                ", contact_number = '" + contact_number + '\'' +
                ", address = '" + address + '\'' +
                '}';
    }
}
