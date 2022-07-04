package manager.repository;

import manager.entity.intern.DietType;
import manager.entity.intern.Ingredients;
import manager.entity.intern.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
class DietTypeRepositoryTest {
    @Autowired
    private DietTypeRepository dietTypeRepository;
    @Test
    public void saveAll(){
        Ingredients ingredients = Ingredients.builder()
                .ingredientsName("Schweineschnitzel") .amount("600 g")

                .build();
        Ingredients ingredients2 = Ingredients.builder()

                .ingredientsName("Pimentkörner").amount("4")
                .build();
        Ingredients ingredients3 = Ingredients.builder()

                .ingredientsName("Knoblauchzehe") .amount("1")
                .build();
        Ingredients ingredients4 = Ingredients.builder()

                .ingredientsName("schwarzer Pfeffer") .amount("1 TL")
                .build();
        Ingredients ingredients5 = Ingredients.builder()

                .ingredientsName("Koriander") .amount("1/4 TL")
                .build();
        Ingredients ingredients6 = Ingredients.builder()

                .ingredientsName("Sonnenblumenöl") .amount("4 EL")
                .build();
        Ingredients ingredients7 = Ingredients.builder()

                .ingredientsName("Lange rote Chilis") .amount("4")
                .build();
        Ingredients ingredients8 = Ingredients.builder()

                .ingredientsName("Zucchini") .amount("1")
                .build();
        Ingredients d = Ingredients.builder()

                .ingredientsName("Rote Chilis") .amount("2")
                .build();
        Ingredients ingredients9 = Ingredients.builder()

                .ingredientsName("Geschälte Erdnüsse") .amount("100 g")
                .build();
        Ingredients ingredients10 = Ingredients.builder()

                .ingredientsName("Zucker") .amount("2 TL")
                .build();
        Ingredients ingredients11 = Ingredients.builder()

                .ingredientsName("Erdnussmus (glutenfrei)") .amount("2 EL")
                .build();
        Ingredients ingredients12 = Ingredients.builder()

                .ingredientsName("Kokosmilch") .amount("200 ml")
                .build();
        Ingredients ingredients13 = Ingredients.builder()

                .ingredientsName("Limettensaft") .amount("2 EL")
                .build();
        Ingredients ingredients14 = Ingredients.builder()

                .ingredientsName("Butter") .amount("4 EL")
                .build();
        Ingredients ingredients15 = Ingredients.builder()

                .ingredientsName("Gehackte Petersilie") .amount("2 EL")
                .build();
        Set<Ingredients> ingredientsSet = new HashSet<>();
        ingredientsSet.add(ingredients);
        ingredientsSet.add(ingredients2);
        ingredientsSet.add(ingredients3);
     ingredientsSet.add(ingredients4);
      ingredientsSet.add(ingredients5);
      ingredientsSet.add(ingredients6);

        ingredientsSet.add(ingredients7);
        ingredientsSet.add(ingredients8);
         ingredientsSet.add(ingredients9);
        ingredientsSet.add(ingredients10);
        ingredientsSet.add(ingredients11);
        ingredientsSet.add(ingredients12);
        ingredientsSet.add(ingredients13);
        ingredientsSet.add(ingredients14);
        ingredientsSet.add(ingredients15);
        ingredientsSet.add(d);


       Product product = Product.builder()

               .productName("Würzige Schweinefleisch").calorie("ca. 720 kcal pro Portion")
                .ingredients(ingredientsSet)
                .build();
        DietType dietType = DietType.builder()
                .dietTypeName("Fleisch")
                .productList(List.of(product))
        .build();

        dietTypeRepository.save(dietType);
    }
    @Test
    @Transactional
     public void getProductWith(){
        List<DietType> dietTypeList = dietTypeRepository.getAllDietName();
        System.out.println(dietTypeList);
    }

}