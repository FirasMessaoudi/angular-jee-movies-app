package tn.sesame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tn.sesame.model.ProductUserID;
import tn.sesame.model.User;
import tn.sesame.repository.ProductRepository;
import tn.sesame.repository.UserRepository;

@RestController
@CrossOrigin(origins = "*" )
@RequestMapping("/favoris")
public class FavorisConroller {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;
    public boolean existInFavorits(String email, Long idProduct){
        if(userRepository.getOne(email).getProductsFav().contains(productRepository.getOne(idProduct)))
            return true;
        else
            return false;
    }
    @PostMapping("/addOrDeleteFromFavoris/")
    public void addOrDeleteFromFavoris(@RequestBody ProductUserID productUserID){
        User user = userRepository.getOne(productUserID.getEmail());
        try {
            if (existInFavorits(productUserID.getEmail(), productUserID.getIdProduct())) {
              //  System.out.println("bech nfasakh");
                user.getProductsFav().remove(productRepository.getOne(productUserID.getIdProduct()));
                userRepository.save(user);
              //  System.out.println(user.getProductsFav().size());


            } else {
              //  System.out.println("bech nzid");
                user.getProductsFav().add(productRepository.getOne(productUserID.getIdProduct()));
                userRepository.save(user);
              //  System.out.println(user.getProductsFav().size());
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
