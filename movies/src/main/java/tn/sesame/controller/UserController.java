package tn.sesame.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tn.sesame.model.MovieNote;
import tn.sesame.model.Product;
import tn.sesame.model.ProductUserID;
import tn.sesame.model.User;
import tn.sesame.repository.MovieNoteRepository;
import tn.sesame.repository.UserRepository;

import java.util.List;

@RestController
@CrossOrigin(origins = "*" )
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MovieNoteRepository movieNoteRepository;
    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username){
        return userRepository.findByUsername(username);
    }
    @PostMapping("/rateMove")
    public void rateMovie(@RequestBody ObjectNode json){
        try{
            System.out.println("na9ra fiha");
            ProductUserID productUserID =new ProductUserID();
            Product product =new Product();
            User user = new User();
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            productUserID=objectMapper.treeToValue(json.get("productUserID"),ProductUserID.class);
            product=objectMapper.treeToValue(json.get("product"),Product.class);
            user=objectMapper.treeToValue(json.get("user"),User.class);
            int note=objectMapper.treeToValue(json.get("note"),Integer.class);
            MovieNote movieNote = new MovieNote();
            movieNote.setNote(note);
            movieNote.setProductUserID(productUserID);
            movieNote.setProductNote(product);
            movieNote.setUserNote(user);
           // System.out.println(movieNote);
            movieNoteRepository.save(movieNote);
        }catch(JsonProcessingException e){
            e.printStackTrace();

        }


    }
    @GetMapping("/getMovieNote/{idProduct}/{email}")
    public int getMovieNotes(@PathVariable("idProduct") Long idProduct, @PathVariable("email") String email){
        try {
            return movieNoteRepository.getOne(new ProductUserID(idProduct, email)).getNote();
        }catch(Exception e){
            return 0;
        }

    }
}
