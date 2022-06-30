package manager.service;

import manager.entity.Customer;
import manager.entity.Delivery;
import manager.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public boolean isSavedCustomer(Customer customer, Delivery delivery){
        boolean isSaved = false;
        customer.setDelivery(delivery);
        Customer customerList = customerRepository.save(customer);
        if (customerList != null){
            isSaved = true;
        }

        System.out.println("isSaved!!!");
        return isSaved;
    }
}
