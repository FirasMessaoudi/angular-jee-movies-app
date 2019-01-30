package tn.sesame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.sesame.model.Category;
import tn.sesame.model.Product;
import tn.sesame.model.Section;
import tn.sesame.repository.CategoryRepository;
import tn.sesame.repository.ProductRepository;
import tn.sesame.repository.SectionRepository;

@RestController
@CrossOrigin(origins = "*" )
@RequestMapping("/admin")

public class AdminController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    SectionRepository sectionRepository;
    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        return productRepository.save(product);
    }
    @PostMapping()
    public Category addCategory(@RequestBody Category category){
        return categoryRepository.save(category);
    }
    @PostMapping("/addSection")
    public void addSection(@RequestBody Section section){
        sectionRepository.save(section);
    }


}
