package manager.controller;

import manager.entity.Customer;
import manager.entity.Delivery;
import manager.repository.CustomerRepository;
import manager.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller

public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerRepository customerRepository;
    @RequestMapping(value={"/customer"})
    public String displayDatabase(Customer customer, Model model
            , @RequestParam(name="check", required = false) String check){
        model.addAttribute("customer",new Customer());
        model.addAttribute("delivery", new Delivery());

        String message = null;
        if(check != null){
            message = "Thank you!!!";

        }
        model.addAttribute("errorMessage",message);

        return "customer.html";
    }
    @RequestMapping("/successful")
    public String displaySuccessful(){
        return "successful.html";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(Model model,
                               @Valid @ModelAttribute("delivery") Delivery delivery,
                               Errors errors
                               ,@Valid @ModelAttribute("customer") Customer customer
                               ,Errors error
            ) {
        if(error.hasErrors() || errors.hasErrors()){
            return "customer.html";
        }

        customerService.isSavedCustomer(customer,delivery);
        return "redirect:/successful";
     //   return "redirect:/customer?check=1";
    }




}
