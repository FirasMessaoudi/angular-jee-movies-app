package tn.sesame.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity

//@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idProduct")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;
    @Lob
    @Type(type="org.hibernate.type.TextType")
    private String description;
    private String title,country,director,image,studio,cover,trailer;
    private double noteImdb;
    private long idtmdb;
    private String idimdb;
    private Date dateRelease;
    @Column(nullable = true)
    private int numberVisits,numberVotes,runtime,nbSeasons;
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    private Section section;
    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "idProduct"),inverseJoinColumns = @JoinColumn(name = "idCategory"))
    private List<Category>categories;
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<WatchList> users;
    @ManyToMany(mappedBy = "productsFav")
    @JsonIgnore
    private List<User> usersFav;
    @OneToMany(mappedBy = "productNote",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<MovieNote> userNote;

    public Product(){}


}
