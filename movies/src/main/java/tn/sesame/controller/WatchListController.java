package tn.sesame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tn.sesame.model.*;
import tn.sesame.repository.WatchListRepository;
import tn.sesame.repository.ProductRepository;
import tn.sesame.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/watchlist")
@CrossOrigin(origins = "*" )
public class WatchListController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private WatchListRepository watchListRepository;
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/myWatchList/{email}")
    public List<WatchList> getWatchList(@PathVariable("email") String email){
        User user = userRepository.getOne(email);

        return watchListRepository.getWatchListsByUser(user);

    }
    @GetMapping("/existInWatchList/{email}/{idProduct}")
    public boolean existInWatchList(@PathVariable("email") String email ,@PathVariable("idProduct") long idproduct){
        List<WatchList> watchLists =getWatchList(email);
        boolean find=false;
        int i=0;
        while(i<watchLists.size() && !find){
            if (watchLists.get(i).getProductUserID().getIdProduct().compareTo(idproduct)==0)
                find=true;
            i++;
        }
        return find;
    }
    @PostMapping("/addOrDeleteFromWatchList")
    public void AddOrDeleteFromWatchList(@RequestBody ProductUserID productUserID){

        if(existInWatchList(productUserID.getEmail(), productUserID.getIdProduct())) {
            WatchList watchList = watchListRepository.getOne(productUserID);
            watchListRepository.delete(watchList);
            System.out.println(productUserID+ " delete");
        }
        else {
            WatchList watchList =new WatchList();
            watchList.setProductUserID(productUserID);
            watchList.setProduct(productRepository.getOne(productUserID.getIdProduct()));
            watchList.setUser(userRepository.getOne(productUserID.getEmail()));
            watchList.setWatched(false);
            watchListRepository.save(watchList);


        }
    }
    @PostMapping("/watchUnWatchMovie/")
    public void watchUnWatchMovie(@RequestBody ProductUserID productUserID){
        WatchList watchList =watchListRepository.getOne(productUserID);
        if (watchList.isWatched())
            watchList.setWatched(false);
        else
            watchList.setWatched(true);
        watchListRepository.save(watchList);

    }
    @GetMapping("getWatchListByProduct/{email}/{idProduct}")
    public WatchList getWatchListByProduct(@PathVariable("email") String email, @PathVariable("idProduct") Long idProduct){
        try{
            return watchListRepository.getOne(new ProductUserID(idProduct,email));


        }catch(Exception e){
            return null;
        }
    }


}
