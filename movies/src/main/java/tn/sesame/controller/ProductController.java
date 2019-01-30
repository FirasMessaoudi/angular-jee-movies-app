package tn.sesame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.sesame.model.Category;
import tn.sesame.model.Product;
import tn.sesame.repository.CategoryRepository;
import tn.sesame.repository.ProductRepository;

import java.util.List;

@RestController
@CrossOrigin(origins = "*" )
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @GetMapping
    public List<Product>getAllProduct(){
        return productRepository.findAll();
    }
    @GetMapping(path = "/productbykeyword/{mc}")
    public List<Product>getProductByKeyWord(@PathVariable("mc") String mc){
        System.out.println(productRepository.getProductByKeyWord(mc));
        return productRepository.getProductByKeyWord(mc);
    }
    @GetMapping(path = "/{id}")
    public Product getProductById(@PathVariable("id") Long id){
        return productRepository.getOne(id);
    }
    @GetMapping(path = "/latestproduct/{idSection}")
    public List<Product>getProductOrderByReleaseDate(@PathVariable("idSection") Long idSection){
        return productRepository.getProductOrOrderByDateRelease(idSection);
    }
    @GetMapping(path="/productbyimdb")
    public List<Product> getProductOrderByImdb(){
        return productRepository.getProductOrOrderByNoteImdb();
    }
    @GetMapping(path = "/mostvisited")
    public List<Product>getMostVisited(){
        return productRepository.getProductOrOrderByNumberVisits();
    }
    @GetMapping(path = "/latestmovies")
    public List<Product>getLatestMovies(){
        return productRepository.getProductOrOrderByDateRelease(new Long(1)).subList(0,7);
    }
    @GetMapping(path = "/getproductbysection/{name}")
    public List<Product>getProductBySection(@PathVariable("name") String name){
        return productRepository.getProductBySection(name);
    }
    @GetMapping(path = "/getproductbycategoryandsection/{category}/{section}")
    public List<Product>getProductByCategoryAndSection(@PathVariable("category") String category, @PathVariable("section")String section){
        Category cat = categoryRepository.getCategoriesByName(category);

        return productRepository.getProductByCategoryAndSection(cat,section);
    }
    @GetMapping(path = "/visitproduct/{id}")
    public Product visitProduct(@PathVariable("id") Long idProduct){
        Product p=productRepository.getOne(idProduct);
        p.setNumberVisits(p.getNumberVisits()+1);
        productRepository.save(p);
        return p;
    }

    @GetMapping(path = "/getproductbycategory/{nameCategory}")
    public List<Product>getProductByCategory(@PathVariable("nameCategory") String nameCategory){
        Category category=categoryRepository.getCategoriesByName(nameCategory);
        return productRepository.getProductByCategories(category);
    }
    @GetMapping("/getproductbyyear/{year}")
    public List<Product>getProductByYear(@PathVariable("year") int year){
        return productRepository.getProductByYear(year);
    }
    @GetMapping("/upcoming")
    public List<Product> upcoming (){
        return productRepository.upcoming();
    }

}
