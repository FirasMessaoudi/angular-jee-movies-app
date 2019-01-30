package tn.sesame.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.sesame.model.Section;

import java.util.List;

public interface SectionRepository extends JpaRepository<Section,Long> {
    @Query("select distinct s from Section s where s.productList is not empty ")
    List<Section> getSectionWithProducts();
}
