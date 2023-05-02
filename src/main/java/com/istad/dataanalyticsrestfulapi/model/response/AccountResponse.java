package com.istad.dataanalyticsrestfulapi.model.response;

import com.istad.dataanalyticsrestfulapi.model.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponse {
    private int id ;
    private String accountName;
    private String accountNumber;
    private String profile;
    private String phoneNumber;
    private int transferLimit;
    private AccountType accountType;
}
