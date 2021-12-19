/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package retocinco.crud;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import retocinco.modelo.Vegetarian;

/**
 *
 * @author Maria Ligia huertas moreno
 */
public interface VegetarianCrudRepository extends MongoRepository<Vegetarian, String> {
    
    public List<Vegetarian> findByPriceLessThanEqual(double precio);
    
    
    @Query("{'description':{'$regex':'?0','$options':'i'}}")
    public List<Vegetarian> findByDescriptionLike(String description);
    
}
