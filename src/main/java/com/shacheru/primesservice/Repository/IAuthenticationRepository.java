package com.shacheru.primesservice.Repository;

import com.shacheru.primesservice.Model.Customer;

import java.io.IOException;

public interface IAuthenticationRepository {
    Customer findByUsername(String username) throws IOException;

    boolean save(Customer customer) throws IOException;
}
