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
        int count = productRepository.countProductWith("");
        model.addAttribute("count",count);
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
            String message = null;
            message = "SELECT * FROM  product \n INNER JOIN " +
                    " product_diet_type  USING(product_id) \n INNER JOIN" +
                    "  diet_type  USING(diet_type_id)\n WHERE diet_type_name LIKE  'Calorie'";
            model.addAttribute("errorMessage",message);
            List<Product> product = productRepository.getAllProductWithCal("Calorie");
            model.addAttribute("product",product);
            int count = productRepository.countProductWith("Calorie");
            model.addAttribute("count",count);
            model.addAttribute("calorie","Low-Calorie");
            return "orders.html";
        }
        if(check==2){
            String message = null;
            message = "SELECT * FROM  product \n INNER JOIN " +
                    " product_diet_type  USING(product_id) \n INNER JOIN" +
                    "  diet_type  USING(diet_type_id)\n WHERE diet_type_name LIKE  'Vegetarisch'";
            model.addAttribute("errorMessage",message);
            //    System.out.println("checkin:::"+check);
            List<Product> product = productRepository.getAllProductWithCal("Vegetarisch");
            model.addAttribute("product",product);
            int count = productRepository.countProductWith("Vegetarisch");
            model.addAttribute("count",count);
            model.addAttribute("calorie","Vegetarisch");
            return "orders.html";
        }
        if(check==3){
            String message = null;
            message = "SELECT * FROM  product \n INNER JOIN " +
                    " product_diet_type  USING(product_id) \n INNER JOIN" +
                    "  diet_type  USING(diet_type_id)\n WHERE diet_type_name LIKE  'Fat'";
            model.addAttribute("errorMessage",message);
            //    System.out.println("checkin:::"+check);
            List<Product> product = productRepository.getAllProductWithCal("Fat");
            model.addAttribute("product",product);
            int count = productRepository.countProductWith("Fat");
            model.addAttribute("count",count);
            model.addAttribute("calorie","Low-Fat");
            return "orders.html";
        }
        if(check==4){
            //    System.out.println("checkin:::"+check);
            String message = null;
            message = "SELECT * FROM  product \n INNER JOIN " +
                    " product_diet_type  USING(product_id) \n INNER JOIN" +
                    "  diet_type  USING(diet_type_id)\n WHERE diet_type_name LIKE  'Glu'";
            model.addAttribute("errorMessage",message);
            List<Product> product = productRepository.getAllProductWithCal("Glutenfrei");
            model.addAttribute("product",product);
            int count = productRepository.countProductWith("Glutenfrei");
            model.addAttribute("count",count);
            model.addAttribute("calorie","Glutenfrei");
            return "orders.html";
        }
        if(check==5){
            //    System.out.println("checkin:::"+check);
            String message = null;
            message = "SELECT * FROM  product \n INNER JOIN " +
                    " product_diet_type  USING(product_id) \n INNER JOIN" +
                    "  diet_type  USING(diet_type_id)\n WHERE diet_type_name LIKE  'Frutarian'";
            model.addAttribute("errorMessage",message);
            List<Product> product = productRepository.getAllProductWithCal("Frutarian");
            model.addAttribute("product",product);
            int count = productRepository.countProductWith("Frutarian");
            model.addAttribute("calorie","Frutarian");
            model.addAttribute("count",count);
            return "orders.html";
        }
        if(check==6){
            //    System.out.println("checkin:::"+check);
            String message = null;
            message = "SELECT * FROM  product \n INNER JOIN " +
                    " product_diet_type  USING(product_id) \n INNER JOIN" +
                    "  diet_type  USING(diet_type_id)\n WHERE diet_type_name LIKE  'High'";
            model.addAttribute("errorMessage",message);
            List<Product> product = productRepository.getAllProductWithCal("High");
            model.addAttribute("product",product);
            int count = productRepository.countProductWith("High");
            model.addAttribute("count",count);
            model.addAttribute("calorie","High-Protein");
            return "orders.html";
        }
        if(check==7){
            //    System.out.println("checkin:::"+check);
            String message = null;
            message = "SELECT * FROM  product \n INNER JOIN " +
                    " product_diet_type  USING(product_id) \n INNER JOIN" +
                    "  diet_type  USING(diet_type_id)\n WHERE diet_type_name LIKE  'Fleisch'";
            model.addAttribute("errorMessage",message);
            List<Product> product = productRepository.getAllProductWithCal("Fleisch");
            model.addAttribute("product",product);
            int count = productRepository.countProductWith("Fleisch");
            model.addAttribute("count",count);
            model.addAttribute("calorie","Fleisch");
            return "orders.html";
        }
        if(check==8){
            //    System.out.println("checkin:::"+check);
            String message = null;
            message = "SELECT * FROM  product \n INNER JOIN " +
                    " product_diet_type  USING(product_id) \n INNER JOIN" +
                    "  diet_type  USING(diet_type_id)\n WHERE diet_type_name LIKE  'Vegan'";
            model.addAttribute("errorMessage",message);
            List<Product> product = productRepository.getAllProductWithCal("Vegan");
            model.addAttribute("product",product);
            int count = productRepository.countProductWith("Vegan");
            model.addAttribute("count",count);
            model.addAttribute("calorie","Vegan");
            return "orders.html";
        }

        if(check==99){
            String message = null;
            message = "SELECT * FROM  product  INNER JOIN" +
                    " product_diet_type  USING(product_id)  INNER JOIN  diet_type  USING(diet_type_id)";
            model.addAttribute("errorMessage",message);
            int count = productRepository.countProductWith("");
            model.addAttribute("count",count);
            List<Product> product = productRepository.getAllProduct();
            model.addAttribute("product",product);
            return "orders.html";
        }
        List<Product> product = productRepository.getAllProduct();
        model.addAttribute("product",product);
        return "orders.html";
    }



}
