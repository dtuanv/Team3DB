package manager.repository;

import manager.entity.intern.Product;
import manager.entity.intern.Ingredients;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
class ProductRepositoryTest {
    @Autowired
    ProductRepository productRepository;

    @Test
    public void saveProduct(){
        Ingredients ingredients = Ingredients.builder()

                .ingredientsName("Joghurt") .amount("600g")

                .build();
        Ingredients ingredients2 = Ingredients.builder()

                .ingredientsName("Banan").amount("2")
                .build();
        Ingredients ingredients3 = Ingredients.builder()

                .ingredientsName("Milch") .amount("100ml")
                .build();
        Ingredients ingredients4 = Ingredients.builder()

                .ingredientsName("Heidelbeeren") .amount("150g")
                .build();
        Ingredients ingredients6 = Ingredients.builder()

                .ingredientsName("Himbeeren") .amount("50g")
                .build();
        Ingredients ingredients5 = Ingredients.builder()

                .ingredientsName("Chiasamen") .amount("2 EL ")
                .build();
        Set<Ingredients> ingredientsSet = new HashSet<>();
        ingredientsSet.add(ingredients);
        ingredientsSet.add(ingredients2);
        ingredientsSet.add(ingredients3);
        ingredientsSet.add(ingredients4);
        ingredientsSet.add(ingredients5);
        ingredientsSet.add(ingredients6);


        Product product = Product.builder()

                .productName("Heidelbeer-Joghurt-Shake").calorie("104 kcal")
                .ingredients(ingredientsSet)
                .build();
        productRepository.save(product);
    }

}