/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package retocinco.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retocinco.modelo.Vegetarian;
import retocinco.repositorio.VegetarianRepository;

/**
 *
 * @author Maria Ligia Huertas Moreno
 */
@Service
public class VegetarianService {
    
    @Autowired
    private VegetarianRepository repository;

    public List<Vegetarian> getAll() {
        return repository.getAll();
    }

    public Optional<Vegetarian> getVegetarian(String reference) {
        return repository.getVegetarian(reference);
    }

    public Vegetarian save(Vegetarian vegetarian) {
        if (vegetarian.getReference() == null) {
            return vegetarian;
        } else {
            return repository.save(vegetarian);
        }
    }

    public Vegetarian update(Vegetarian vegetarian) {

        if (vegetarian.getReference() != null) {
            Optional<Vegetarian> vegetarianDb = repository.getVegetarian(vegetarian.getReference());
            if (!vegetarianDb.isEmpty()) {

                if (vegetarian.getBrand() != null) {
                    vegetarianDb.get().setBrand(vegetarian.getBrand());
                }

                if (vegetarian.getCategory() != null) {
                    vegetarianDb.get().setCategory(vegetarian.getCategory());
                }

                if (vegetarian.getDescription() != null) {
                    vegetarianDb.get().setDescription(vegetarian.getDescription());
                }
                if (vegetarian.getPrice() != 0.0) {
                    vegetarianDb.get().setPrice(vegetarian.getPrice());
                }
                if (vegetarian.getQuantity() != 0) {
                    vegetarianDb.get().setQuantity(vegetarian.getQuantity());
                }
                if (vegetarian.getPhotography() != null) {
                    vegetarianDb.get().setPhotography(vegetarian.getPhotography());
                }
                vegetarianDb.get().setAvailability(vegetarian.isAvailability());
                repository.update(vegetarianDb.get());
                return vegetarianDb.get();
            } else {
                return vegetarian;
            }
        } else {
            return vegetarian;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getVegetarian(reference).map(vegetarian -> {
            repository.delete(vegetarian);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    public List<Vegetarian> vegetariansByPrice(double price) {
        return repository.vegetariansByPrice(price);
    }

    
    public List<Vegetarian> findByDescriptionLike(String description) {
        return repository.findByDescriptionLike(description);
    }
    
    
}
