package tn.sesame;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tn.sesame.model.*;
import tn.sesame.repository.CategoryRepository;
import tn.sesame.repository.ProductRepository;
import tn.sesame.repository.UserRepository;
import tn.sesame.repository.WatchListRepository;
import tn.sesame.service.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@SpringBootApplication
public class MoviesApplication implements CommandLineRunner {
@Autowired
private ProductRepository productRepository;
@Autowired
private CategoryRepository categoryRepository;
    @Autowired
    private WatchListRepository watchListRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    UserService userService;
    public static void main(String[] args) {
        SpringApplication.run(MoviesApplication.class, args);
    }
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Override
    public void run(String... args) throws Exception {
     /*  User admin = new User();
        admin.setUsername("hhhhhhh");
        admin.setPassword("hhhhd");
        admin.setFirstname("kiiiii");
        admin.setLastname("messaouffffdi");
        admin.setEmail("firas_scofield@outlook.fr");
        admin.setRoles(new ArrayList<Role>(Arrays.asList(Role.ROLE_USER)));
        userService.signup(admin);*/

      /*  User user = userRepository.getOne("firas_messaoudi@outlook.fr");
        List<WatchList> watchLists = watchListRepository.getWatchListsByUser(user);

        System.out.println(watchLists.size());
        for (int i=0;i<watchLists.size();i++){
            System.out.println(watchLists.get(i).getProduct());
        }*/
      /*  boolean find =false;
        for (int i=0;i<watchLists.size();i++){
            if(watchLists.get(i).getProduct().getIdProduct().compareTo(new Long(1))==0){
                find=true;
                break;
            }
        }
        System.out.println(find);*/
        //List<Product> products = user.getProductsFav();
      //  System.out.println(user.getProductsFav().size());
    //for products

    }
}
