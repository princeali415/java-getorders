package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Customer;
import com.lambdaschool.orders.repositories.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "customerServices")
public class CustomerServiceImpl implements CustomerServices
{
    @Autowired
    private CustomersRepository customersRepository;

    @Transactional
    @Override
    public Customer save(Customer customer)
    {
        return customersRepository.save(customer);
    }

    @Override
    public List<Customer> findAllCustomerOrders()
    {
        List<Customer> customerOrdersList = new ArrayList<>();
        customersRepository.findAll().iterator().forEachRemaining(customerOrdersList::add);

        return customerOrdersList;
    }

    @Override
    public Customer findCustomerById(long id)
    {
        Customer customer = customersRepository.findById(id)
            .orElseThrow(()-> new EntityNotFoundException("Customer "+ id +" Not Found"));  //handles if id doesnt exist
        return customer;
    }

    @Override
    public Customer findCustomerByCustname(String name)
    {
        Customer customer = customersRepository.findCustomerByCustname(name);
        if(customer == null) {
            throw new EntityNotFoundException("Customer "+ name +" Not Found");
        }
        return customer;
    }
}
