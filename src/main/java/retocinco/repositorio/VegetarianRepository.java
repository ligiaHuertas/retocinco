/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package retocinco.repositorio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import retocinco.crud.VegetarianCrudRepository;
import retocinco.modelo.Vegetarian;

/**
 *
 * @author Maria Ligia huertas moreno
 */
@Repository
public class VegetarianRepository {
    
     @Autowired
    private VegetarianCrudRepository repository;
     

    public List<Vegetarian> getAll() {
        return repository.findAll();
    }

    public Optional<Vegetarian> getVegetarian(String reference) {
        return repository.findById(reference);
    }
    
    public Vegetarian save(Vegetarian vegetarian) {
        
        return repository.save(vegetarian);
    }

    public void update(Vegetarian vegetarian) {
        repository.save(vegetarian);
    }
    
    public void delete(Vegetarian vegetarian) {
        repository.delete(vegetarian);
    } 
    
    public List<Vegetarian> vegetariansByPrice(double precio){
        return repository.findByPriceLessThanEqual(precio);
    }
    
    public List<Vegetarian> findByDescriptionLike(String description){
        return repository.findByDescriptionLike(description);
    }
    
}
