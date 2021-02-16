package com.lambdaschool.orders.controllers;

import com.lambdaschool.orders.models.Customer;
import com.lambdaschool.orders.services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController
{
    @Autowired
    private CustomerServices customerServices;

    //http://localhost:2019/customers/orders
    @GetMapping(value = "/orders", produces = "application/json")
    public ResponseEntity<?> listAllCustomerOrders()
    {
        List<Customer> customerOrdersList = customerServices.findAllCustomerOrders();
        return new ResponseEntity<>(customerOrdersList, HttpStatus.OK);
    }


    //http://localhost:2019/customers/customer/{custcode}



    //http://localhost:2019/customers/customer/77



    //http://localhost:2019/customers/namelike/mes



    //http://localhost:2019/customers/namelike/cin



}
