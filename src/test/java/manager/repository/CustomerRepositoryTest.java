package manager.repository;

import manager.entity.Customer;
import manager.entity.Delivery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository customerRepository;
    @Test
    public void saveCustomer(){
        Delivery delivery = Delivery.builder()
                .street("Konstaner Straße")
                .city("Damstadt")
                .houseNum("17f")
                .postcode("22556")
                .build();

        Customer customer = Customer.builder()
                .firstName("Ronaldo")
                .lastName("CR7")
                .gender("male")
                .email("test8@gmail.com")
                .delivery(delivery)
                .build();
        customerRepository.save(customer);
    }

    @Test
    public void getCustomer(){
        List<Customer>  customerList = customerRepository.findAll();
        System.out.println("Customer: "+customerList );
    }

}