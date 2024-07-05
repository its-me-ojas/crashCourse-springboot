package com.ojas.crashCourse.controller;

import com.ojas.crashCourse.exception.CustomerNotFoundException;
import com.ojas.crashCourse.model.Customer;
import com.ojas.crashCourse.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {


    @Autowired
    private CustomerService customerService;

    @GetMapping("getAll")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/get/{id}")
    public Customer getCustomerById(@PathVariable Integer id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping("add")
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    @DeleteMapping("delete/{id}")
    public String deleteCustomer(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
        return "Customer Deleted";
    }

    @PutMapping("update/{id}")
    public Customer updateCustomer(
            @PathVariable Integer id,
            @RequestBody Customer customer) {
        return customerService.updateCustomer(id, customer);
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public String handleCustomerNotFoundException(CustomerNotFoundException e) {
        return e.getMessage();
    }


}
