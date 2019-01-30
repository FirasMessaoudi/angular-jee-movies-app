package tn.sesame.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.sesame.model.Category;
import tn.sesame.model.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query("select p from Product p where p.section.name=:x and p.dateRelease <= CURRENT_DATE ")
    List<Product>getProductBySection(@Param("x") String name );

    @Query("select p from Product p where p.title like %:mc% or p.country like %:mc% or p.director like %:mc% " +
            "or p.studio like %:mc% ")
    List<Product>getProductByKeyWord(@Param("mc") String mc);

    @Query("select distinct p from Product p where :category member of p.categories and p.dateRelease <= CURRENT_DATE")
    List<Product> getProductByCategories(@Param("category") Category category);

    @Query("select p from Product p where :category member of p.categories and p.section.name =:x")
    List<Product>getProductByCategoryAndSection(@Param("category") Category category, @Param("x") String section);

    @Query("select p from Product p where p.section.idSection=:x and p.dateRelease <= CURRENT_DATE ORDER BY p.dateRelease desc ")
    List<Product>getProductOrOrderByDateRelease(@Param("x") Long idSection);


    @Query("select p from Product p where  p.dateRelease <= CURRENT_DATE order by p.noteImdb desc ")
    List<Product>getProductOrOrderByNoteImdb();


    @Query("select p from Product p where p.dateRelease <= CURRENT_DATE  order by p.numberVisits desc ")
    List<Product>getProductOrOrderByNumberVisits();

    @Query("select distinct p from Product p where p.section.idSection=:x and  :category member of p.categories and p.dateRelease <= CURRENT_DATE")
    List<Product>getProductByCategoriesAndSection(@Param("x") Long idSection, @Param("category") Category category);

    @Query("select p from Product p where :category member of p.categories and p.dateRelease <= CURRENT_DATE group by p.section.idSection")
    List<Product> getProductByCategory(@Param("category") Category category);

    @Query ("select p from Product p where Year (p.dateRelease) =:x and p.dateRelease <= CURRENT_DATE order by p.noteImdb")
    List<Product>getProductByYear(@Param("x") int year);

    @Query(" select p from Product p where p.dateRelease > CURRENT_DATE")
    List<Product>upcoming();


}
