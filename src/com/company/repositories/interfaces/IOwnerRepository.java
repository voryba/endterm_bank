package com.company.repositories.interfaces;

import com.company.entities.Transaction;

import java.util.List;

public interface IOwnerRepository {
    public boolean deleteUserByName(String username);
    public List<Transaction> transactions();
}
