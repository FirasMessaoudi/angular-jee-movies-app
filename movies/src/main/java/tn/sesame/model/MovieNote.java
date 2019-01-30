package tn.sesame.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class MovieNote {
    @EmbeddedId
    private ProductUserID productUserID;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idProduct")
    private Product productNote;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("email")
    private User userNote;
    private int note;
}
