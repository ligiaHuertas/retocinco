/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package retocinco.crud;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import retocinco.modelo.User;

/**
 *
 * @author Maria Ligia Huertas Moreno
 */
public interface UserCrudRepository extends MongoRepository<User,Integer>{
    
    Optional<User> findByEmail(String email);
    
    Optional<User> findByEmailAndPassword(String email, String password);
    
    Optional<User> findTopByOrderByIdDesc();
    
    List<User> findByBirthtDay(Date date);
    
    List<User> findByMonthBirthtDay(String month);
    
}
