package tn.sesame.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
@AllArgsConstructor
public class ProductUserID implements Serializable {
    private Long idProduct;
    private String email;
    public ProductUserID(){}


}
