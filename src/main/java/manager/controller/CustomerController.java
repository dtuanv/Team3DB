package manager.controller;

import manager.entity.Customer;
import manager.entity.Delivery;
import manager.repository.CustomerRepository;
import manager.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
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
    public String saveCustomer(Model model,
                               @Valid @ModelAttribute("delivery") Delivery delivery,
                                 Errors errors,
                                 @Valid @ModelAttribute("customer") Customer customer
                               ,Errors error
            ) {


        if(error.hasErrors() || errors.hasErrors()){
            return "customer.html";
        }
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
