package tn.sesame.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data

public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSection;
    private  String name;
    @OneToMany(mappedBy = "section",fetch = FetchType.EAGER)
    //@JsonIgnore
    @JsonManagedReference
    private List<Product> productList;
    public Section(){

    }


}
