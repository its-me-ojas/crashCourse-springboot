package com.ojas.crashCourse.service;

import com.ojas.crashCourse.exception.CustomerNotFoundException;
import com.ojas.crashCourse.model.Customer;
import com.ojas.crashCourse.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;


    public List<Customer> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers;
    }

    public Customer addCustomer(Customer customer) {
        Customer customer1 = customerRepository.save(customer);
        return customer1;
    }

    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }


    public Customer updateCustomer(Integer id, Customer updatedCustomer) {
        Optional<Customer> oldCustomerOptional = customerRepository.findById(id);
        if (oldCustomerOptional.isPresent()) {
            Customer oldCustomer = oldCustomerOptional.get();
            oldCustomer.setCustName(updatedCustomer.getCustName());
            oldCustomer.setCustEmail(updatedCustomer.getCustEmail());
            oldCustomer.setCustPassword(updatedCustomer.getCustPassword());
            return customerRepository.save(oldCustomer);
        } else {
            throw new CustomerNotFoundException("Customer not found with id: " + id);
        }
    }

    public Customer getCustomerById(Integer id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if (customerOptional.isPresent()) {
            return customerOptional.get();
        } else {
            throw new CustomerNotFoundException("Customer not found with id: " + id);
        }
    }
}
