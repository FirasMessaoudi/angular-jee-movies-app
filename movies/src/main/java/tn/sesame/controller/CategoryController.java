package tn.sesame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tn.sesame.model.Category;
import tn.sesame.model.Product;
import tn.sesame.repository.CategoryRepository;
import tn.sesame.repository.ProductRepository;

import java.rmi.registry.LocateRegistry;
import java.util.List;

@RestController
@CrossOrigin(origins = "*" )
@RequestMapping(path="/categories")

public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;
    @GetMapping("/findAll")
    public List<Category> findAll(){
        return categoryRepository.findAll();
    }
    @GetMapping
    public List<Category> getCategoryWithProduct(){
        return categoryRepository.getCategoryWithProduct();
    }


}
