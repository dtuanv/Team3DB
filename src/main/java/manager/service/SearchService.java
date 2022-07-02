package manager.service;

import manager.entity.Customer;
import manager.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findCustomerWithSearch(String firstName){

        List<Customer> customerList = customerRepository.findCustomerWithFilter(firstName);
        return customerList;
    }
}
