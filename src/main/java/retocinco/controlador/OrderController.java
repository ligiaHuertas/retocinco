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
import retocinco.modelo.Order;
import retocinco.servicio.OrderService;

/**
 *
 * @author Maria Ligia Huertas Moreno
 */

@RestController
@RequestMapping("/api/order")
@CrossOrigin("*")
public class OrderController {
    
    
    @Autowired
    private OrderService orderService;
    
    @GetMapping("/all")
    public List<Order> getAll() {
        return orderService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Order> getOrder(@PathVariable("id") int id) {
        return orderService.getOrder(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order create(@RequestBody Order order) {
        return orderService.save(order);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order update(@RequestBody Order order) {
        return orderService.update(order);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return orderService.delete(id);
    }

    //Ordenes de pedido asociadas a los asesores de una zona
    @GetMapping("/zona/{zona}")

    public List<Order> findByZone(@PathVariable("zona") String zona) {
        return orderService.findByZone(zona);
    }

    //Reto 4: Ordenes de un asesor
    @GetMapping("/salesman/{id}")
    public List<Order> ordersSalesManById(@PathVariable("id") int id) {
        return orderService.ordersSalesManById(id);
    }

    //Reto 4: Ordenes de un asesor x Fecha
    @GetMapping("/date/{date}/{id}")
    public List<Order> ordersSalesManByDate(@PathVariable("date") String dateStr, @PathVariable("id") int id) {
        return orderService.ordersSalesManByDate(dateStr, id);
    }

    //Reto 4: Ordenes de un asesor x Estado
    @GetMapping("/state/{state}/{id}")
    public List<Order> ordersSalesManByState(@PathVariable("state") String date, @PathVariable("id")int id) {
        return orderService.ordersSalesManByState(date, id);
    }
    
}
