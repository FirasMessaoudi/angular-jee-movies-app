package tn.sesame.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.sesame.model.Category;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    @Query("select c from Category c where c.products is not empty ")
    List<Category> getCategoryWithProduct();
    @Query("select c from Category c where c.name =:x ")
    public Category getCategoriesByName(@Param("x") String name);


}
