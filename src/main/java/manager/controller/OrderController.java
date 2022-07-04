package manager.controller;

import manager.entity.intern.DietType;
import manager.entity.intern.Product;
import manager.repository.DietTypeRepository;

import manager.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private DietTypeRepository dietTypeRepository;
    @Autowired
   private ProductRepository productRepository;

    @RequestMapping("/order")
    public String displayOrder(Model model){
     /*   List<DietType> dietTypeList = dietTypeRepository.getDietName();
       List<DietType> dietTypeList = orderRepository.getDietName();
        model.addAttribute("type",dietTypeList);


      */
        List<Product> product = productRepository.getAllProduct();
        model.addAttribute("product",product);
        return "orders.html";
    }


}
