package com.company.entities;

import java.time.LocalDate;

public class Transaction {
    private int id;
    private String username;
    private String name;
    private String surname;
    private int account_change;
    private LocalDate date;

    public Transaction(int id, String username, String name, String surname, int account_change, LocalDate date) {
        setId(id);
        setUsername(username);
        setName(name);
        setSurname(surname);
        setAccount_change(account_change);
        setDate(date);
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
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
    public int getAccount_change() {
        return account_change;
    }
    public void setAccount_change(int account_change) {
        this.account_change = account_change;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", account_change=" + account_change +
                ", date=" + date +
                '}';
    }
}
