package com.company.entities;

public class Owner {
    private String name;
    private String surname;
    private String username;
    private String password;
    private String address;
    private int salary;
    private int age;

    public Owner(String name, String surname, String username, String password, String address, int salary, int age) {
        setName(name);
        setSurname(surname);
        setUsername(username);
        setPassword(password);
        setAddress(address);
        setSalary(salary);
        setAge(age);
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
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "name = '" + name + '\'' +
                ", surname = '" + surname + '\'' +
                ", username = '" + username + '\'' +
                ", password = '" + password + '\'' +
                ", address = '" + address + '\'' +
                ", salary = " + salary +
                ", age = " + age +
                '}';
    }
}
