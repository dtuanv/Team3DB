package manager.controller;

import manager.entity.intern.DietType;
import manager.entity.intern.Product;
import manager.repository.DietTypeRepository;

import manager.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private DietTypeRepository dietTypeRepository;
    @Autowired
   private ProductRepository productRepository;


    @RequestMapping("/order")
        public String display(Model model){

        List<Product> product = productRepository.getAllProduct();
        model.addAttribute("product",product);
        return "orders.html";

        }


    @RequestMapping("/is")
    public String displayOrder(Model model, @RequestParam(name="check",required = false)int check){
     /*   List<DietType> dietTypeList = dietTypeRepository.getDietName();
       List<DietType> dietTypeList = orderRepository.getDietName();
        model.addAttribute("type",dietTypeList);


      */
        System.out.println("check:::"+check);
        if(check==1){
        //    System.out.println("checkin:::"+check);
            List<Product> product = productRepository.getAllProductWithCal("Calorie");
            model.addAttribute("product",product);
            return "orders.html";
        }
        if(check==2){
            //    System.out.println("checkin:::"+check);
            List<Product> product = productRepository.getAllProductWithCal("Vegetarisch");
            model.addAttribute("product",product);
            return "orders.html";
        }
        if(check==3){
            //    System.out.println("checkin:::"+check);
            List<Product> product = productRepository.getAllProductWithCal("Fat");
            model.addAttribute("product",product);
            return "orders.html";
        }
        if(check==4){
            //    System.out.println("checkin:::"+check);
            List<Product> product = productRepository.getAllProductWithCal("Glutenfrei");
            model.addAttribute("product",product);
            return "orders.html";
        }
        if(check==5){
            //    System.out.println("checkin:::"+check);
            List<Product> product = productRepository.getAllProductWithCal("Flutarian");
            model.addAttribute("product",product);
            return "orders.html";
        }
        if(check==6){
            //    System.out.println("checkin:::"+check);
            List<Product> product = productRepository.getAllProductWithCal("Hight");
            model.addAttribute("product",product);
            return "orders.html";
        }
        if(check==7){
            //    System.out.println("checkin:::"+check);
            List<Product> product = productRepository.getAllProductWithCal("Fleisch");
            model.addAttribute("product",product);
            return "orders.html";
        }
        String message = null;
        if(check==99){
            message = "SELECT * FROM product Inner JOin" +
                    " product_diet_type USING (product_id) INNER JOIN diet_type USING(diet_type_id)";
            model.addAttribute("errorMessage",message);
            return "redirect:/order?check=99";
        }
        List<Product> product = productRepository.getAllProduct();
        model.addAttribute("product",product);
        return "orders.html";
    }



}
