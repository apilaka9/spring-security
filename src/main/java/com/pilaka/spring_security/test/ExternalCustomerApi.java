package com.pilaka.spring_security.test;

import com.pilaka.spring_security.model.Customer;

public interface ExternalCustomerApi {
    Customer fetchCustomer(String customerId) throws InterruptedException;
}
