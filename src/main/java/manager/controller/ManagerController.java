package manager.controller;

import manager.entity.Customer;
import manager.repository.CustomerRepository;
import manager.repository.SearchRepository;
import manager.service.CustomerService;
import manager.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
public class ManagerController {
    @Autowired
    private ManagerService managerService;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private SearchRepository searchRepository;

    @GetMapping("/manager")
    public String showCustomer(Model model){
        List<Customer> customerList = managerService.getCustomer();
        model.addAttribute("customerList", customerList);
        return "manager.html";
    }
    @GetMapping(value={"/search"})
    public String showWithFirstName(@Param("fistName") String firstName
                                    ,@Param("lastName") String lastName
                                    ,@Param("email") String email
                                    ,@Param("gender") String gender
                                    ,@Param("city") String city
            , Model model){
        String check = null;
        System.out.println("firstName: " + firstName);
        System.out.println("lastName: "+lastName);

    /*  int  count =  searchRepository.countCustomer(firstName);
        System.out.println("Count: " + count);
        model.addAttribute("count",count);

     */

        if(!firstName.isEmpty()){
            List<Customer> customerList = managerService.getCustomerWithFilter(firstName);
            model.addAttribute("customerList",customerList);
            int  count =  searchRepository.countCustomer(firstName);
            System.out.println("Count: " + count);
            model.addAttribute("firstName",firstName);
            model.addAttribute("count",count);
            return "manager.html";
        }
        if(!lastName.isEmpty()){
            List<Customer> customerList = customerRepository.findCustomerWithLastName(lastName);
            model.addAttribute("customerList",customerList);
            int  count =  searchRepository.countCustomerWithLastName(lastName);
            System.out.println("Count: " + count);
            model.addAttribute("lastName",lastName);
            model.addAttribute("count",count);
            return "manager.html";
        }
        if(!email.isEmpty()){
            List<Customer> customerList = customerRepository.findCustomerWithEmail(email);
            model.addAttribute("customerList",customerList);
            int  count =  searchRepository.countCustomerWithEmail(email);
            System.out.println("Count: " + count);
            model.addAttribute("email",email);
            model.addAttribute("count",count);
            return "manager.html";
        }
        if(!gender.isEmpty()){
            List<Customer> customerList = customerRepository.findCustomerWithGender(gender);
            model.addAttribute("customerList",customerList);
            int  count =  searchRepository.countCustomerWithGender(gender);
            System.out.println("Count: " + count);
            model.addAttribute("gender",gender);
            model.addAttribute("count",count);
            return "manager.html";
        }
        if(!city.isEmpty()){
            List<Customer> customerList = customerRepository.findCustomerWithCity(city);
            model.addAttribute("customerList",customerList);
            int  count =  searchRepository.countCustomerWithCity(city);
            System.out.println("Count: " + count);
            model.addAttribute("city",city);
            model.addAttribute("count",count);
            return "manager.html";
        }

     //   List<Customer> customerList = managerService.getCustomerWithFilter(firstName,lastName);

      // model.addAttribute("customerList",customerList);


        return "manager.html";
    }

}
