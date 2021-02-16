package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Customer;

import java.util.List;

public interface CustomerServices
{
    public Customer save(Customer customer);

    List<Customer> findAllCustomerOrders();
}
