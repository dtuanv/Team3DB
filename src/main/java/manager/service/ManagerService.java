package manager.service;

import manager.entity.Customer;
import manager.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ManagerService {
    @Autowired
    public CustomerRepository customerRepository;
    public List<Customer> getCustomer(){
       List<Customer> customerList = customerRepository.findCustomerWithAddress();
       return  customerList;
    }
    public List<Customer> getCustomerWithFilter(String firstName){
     /*   if(firstName != null || lastName != null){
            List<Customer> customerList = customerRepository.findCustomerWithFilter(firstName,lastName);
            return customerList;
        }


        if(check != null ){
            return customerRepository.findCustomerWithLastNameFilter(lastName);
        }
        if(firstName != null ){
            return customerRepository.findCustomerWithLastNameFilter(firstName);
        }  */

        System.out.println(firstName);

        return customerRepository.findCustomerWithFilter(firstName);
    }
}
