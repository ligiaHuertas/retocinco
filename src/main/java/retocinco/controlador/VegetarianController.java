/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package retocinco.controlador;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import retocinco.modelo.Vegetarian;
import retocinco.servicio.VegetarianService;

/**
 *
 * @author Maria ligia huertas moreno
 */
@RestController
@RequestMapping("/api/vegetarian")
@CrossOrigin("*")
public class VegetarianController {
    @Autowired
    private VegetarianService vegetarianService;

    @GetMapping("/all")
    public List<Vegetarian> getAll() {
        return vegetarianService.getAll();
    }

    @GetMapping("/{reference}")
    public Optional<Vegetarian> getVegetarian(@PathVariable("reference") String reference) {
        return vegetarianService.getVegetarian(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Vegetarian save(@RequestBody Vegetarian vegetarian) {
        return vegetarianService.save(vegetarian);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Vegetarian update(@RequestBody Vegetarian vegetarian) {
        return vegetarianService.update(vegetarian);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference) {
        return vegetarianService.delete(reference);
    }

    @GetMapping("/price/{price}")
    public List<Vegetarian> VegetariansByPrice(@PathVariable("price") double precio) {
        return vegetarianService.vegetariansByPrice(precio);
    }

    //Reto 5
    @GetMapping("/description/{description}")
    public List<Vegetarian> findByDescriptionLike(@PathVariable("description") String description) {
        return vegetarianService.findByDescriptionLike(description);
    }
}
    

