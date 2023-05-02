package com.istad.dataanalyticsrestfulapi.controller;


import com.istad.dataanalyticsrestfulapi.mapper.AutoAccountMapper;
import com.istad.dataanalyticsrestfulapi.model.Account;
import com.istad.dataanalyticsrestfulapi.model.response.AccountResponse;
import com.istad.dataanalyticsrestfulapi.service.AccountService;
import com.istad.dataanalyticsrestfulapi.utils.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    // inject account service
    final private AccountService accountService;
    final private AutoAccountMapper autoAccountMapper;

    AccountController(AccountService accountService, AutoAccountMapper autoAccountMapper) {
        this.accountService = accountService;
        this.autoAccountMapper = autoAccountMapper;
    }

    @GetMapping("/all-accounts")
    public Response<List<AccountResponse>> getAllAccounts() {
        try {
            List<Account> allAccount = accountService.getAllAccounts();
            List<AccountResponse> accountResponses = autoAccountMapper.mapToAccountResponse(allAccount);
            return Response.<List<AccountResponse>>ok().setPayload(accountResponses).setMessage("successfully retrieved all account information ");

        } catch (Exception ex) {
            System.out.println("Something wrong : " + ex.getMessage());
            return Response.<List<AccountResponse>>exception().setMessage("Exception occurs! Failed to retrieved account information");
        }

    }


}
