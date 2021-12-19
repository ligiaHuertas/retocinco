/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package retocinco.repositorio;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import retocinco.crud.UserCrudRepository;
import retocinco.modelo.User;

/**
 *
 * @author Maria Ligia huertas moreno
 */
@Repository
public class UserRepositoty {
   
    
    
    @Autowired
    private UserCrudRepository userCrudRepository;
    
     @Autowired
    private MongoTemplate mongoTemplate;

    public List<User> getAll() {
        return (List<User>) userCrudRepository.findAll();
    }

    public Optional<User> getUser(int id) {
        return userCrudRepository.findById(id);
    }

    public User save(User user) {
        return userCrudRepository.save(user);
    }
    
    public void update(User user) {
        userCrudRepository.save(user);
    }
    
    public void delete(User user) {
        userCrudRepository.delete(user);
    }

    public boolean emailExist(String email) {
        Optional<User> usuario = userCrudRepository.findByEmail(email);
        
        return !usuario.isEmpty();
    }
    
    public Optional<User> authenticateUser(String email, String password) {
        return userCrudRepository.findByEmailAndPassword(email, password);
    }
     public Optional<User> lastUserId(){
        return userCrudRepository.findTopByOrderByIdDesc();
    }
    
    
    public List<User> birthtDayMonthList(String month) {
        return userCrudRepository.findByMonthBirthtDay(month);
    }
    
    
}
