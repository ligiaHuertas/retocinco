/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package retocinco.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retocinco.modelo.Order;
import retocinco.repositorio.OrderRepository;

/**
 *
 * @author Maria Ligia huertas moreno
 */
@Service
public class OrderService {
    
     @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAll() {
        return orderRepository.getAll();
    }

    public Optional<Order> getOrder(int id) {
        return orderRepository.getOrder(id);
    }

    public Order save(Order order) {
        Optional<Order> orderIdMaxima= orderRepository.lastUserId();
        if (order.getId() == null) {
            //valida el maximo id generado, si no hay ninguno aun el primer id sera 1
            if (orderIdMaxima.isEmpty())
                order.setId(1);
            //si retorna informacion suma 1 al maximo id existente y lo asigna como el codigo de la orden
            else
                order.setId(orderIdMaxima.get().getId() + 1);
        }
        
        Optional<Order> e = orderRepository.getOrder(order.getId());
        if (e.isEmpty()) {
            return orderRepository.save(order);            
        }else{
            return order;
        }        
        
    }

    public Order update(Order order) {

        if (order.getId() != null) {
            Optional<Order> orderDb = orderRepository.getOrder(order.getId());
            if (!orderDb.isEmpty()) {
                if (order.getStatus() != null) {
                    orderDb.get().setStatus(order.getStatus());
                }
                orderRepository.update(orderDb.get());
                return orderDb.get();
            } else {
                return order;
            }
        } else {
            return order;
        }
    }

    public boolean delete(int id) {
        Boolean aBoolean = getOrder(id).map(order -> {
            orderRepository.delete(order);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    //Ordenes de pedido asociadas a los asesores de una zona
    public List<Order> findByZone(String zona) {
        return orderRepository.findByZone(zona);
    }

    // Ordenes de un asesor
    public List<Order> ordersSalesManById(int id) {
        return orderRepository.ordersSalesManById(id);
    }
    
    // Ordenes de un asesor x Fecha
    public List<Order> ordersSalesManByDate(String dateStr, int id) {
        return orderRepository.ordersSalesManByDate(dateStr, id);
    }
    
    // Ordenes de un asesor x Estado
    public List<Order> ordersSalesManByState(String state, int id) {
        return orderRepository.ordersSalesManByState(state, id);
    }
    
}
