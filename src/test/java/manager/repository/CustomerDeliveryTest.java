package manager.repository;

import manager.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
class CustomerDeliveryTest {
    @Autowired
    private CustomerRepository customerRepository;
    @Test
    @Transactional
    public void getCustomerDelivery(){
        List<Customer> customerList = customerRepository.findCustomerWithAddress();
        System.out.println(customerList);
    }
    @Test
    @Transactional
    public void getCustomerDeliveryWithFilter(){
        String search ="Van";
        List<Customer> customerList = customerRepository.findCustomerWithFilter(search);
        System.out.println(customerList);
    }


}
