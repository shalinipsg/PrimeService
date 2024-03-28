package com.shacheru.primesservice.Service;

import com.shacheru.primesservice.Model.Customer;

import java.io.IOException;

public interface IAuthenticationService {
    boolean register (Customer customer) throws IOException;
    boolean login (String username, String password) throws IOException;
}