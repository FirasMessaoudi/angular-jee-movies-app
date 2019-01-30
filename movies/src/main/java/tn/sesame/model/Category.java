package tn.sesame.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long idCategory;
    private String name;
    @ManyToMany(mappedBy = "categories")
    @JsonIgnore
    private List<Product>products;
    public Category (){}


}
