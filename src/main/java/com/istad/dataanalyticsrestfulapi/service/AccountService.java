package com.istad.dataanalyticsrestfulapi.service;

import com.istad.dataanalyticsrestfulapi.model.Account;

import java.util.List;

public interface AccountService {

    List<Account> getAllAccounts();
    int createAccount(Account account);
    int updateAccount(Account account , int id);
    Account findAccountByID(int id);
}
