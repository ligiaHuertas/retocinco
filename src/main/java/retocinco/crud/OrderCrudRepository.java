/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package retocinco.crud;

import java.util.List;
import java.util.Date;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import retocinco.modelo.Order;

/**
 *
 * @author Maria Ligia huertas moreno
 */
public interface OrderCrudRepository extends MongoRepository<Order,Integer>{
    
    
    @Query("{'salesMan.zone': ?=}")
    List<Order> findByZone(final String zone);
    //Retorna las ordenes x status
    @Query("{Status: ?0}")
    List<Order> findByStatus(final String status);
    
     //Para seleccionar la orden con el id maximo
    Optional<Order> findTopByOrderByIdDesc();
    
}
