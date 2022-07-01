package manager.controller;

import manager.entity.Customer;
import manager.entity.Delivery;
import manager.repository.CustomerRepository;
import manager.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller

public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerRepository customerRepository;
    @RequestMapping(value={"/customer"})
    public String displayDatabase(Customer customer, Model model){
        model.addAttribute("customer",new Customer());
        model.addAttribute("delivery", new Delivery());

        return "customer.html";
    }


    @PostMapping("/saveCustomer")
    public String saveCustomer(Customer customer, Delivery delivery){
        customerService.isSavedCustomer(customer,delivery);
        return "redirect:/customer";
    }
    @GetMapping("/manager")
    public String showCustomer(Model model){
        List<Customer> customerList = customerRepository.findCustomerWithAddress();
        model.addAttribute("customerList", customerList);
        return "manager.html";

    }



}
