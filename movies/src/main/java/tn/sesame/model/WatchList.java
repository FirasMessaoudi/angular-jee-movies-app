package tn.sesame.model;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.*;

@Entity
@Data
public class WatchList {
    @EmbeddedId
    private ProductUserID productUserID;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idProduct")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("email")
    private User user;

    private boolean watched;



}
