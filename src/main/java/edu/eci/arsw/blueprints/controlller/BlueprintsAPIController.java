/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.controlller;
import edu.eci.arsw.blueprints.services.BlueprintsServices;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author 2106991
 */
@RestController
@RequestMapping(value = "/blueprints")
public class BlueprintsAPIController {
    
    @Autowired
    BlueprintsServices blueprint;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getOrders() {
        
     
        return new ResponseEntity<>("*/", HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<?> getOrderByTable(@PathVariable("id") int id) {

        

        return new ResponseEntity<>("*/", HttpStatus.OK);
    }

//    @RequestMapping(method = RequestMethod.POST)
//    public ResponseEntity<?> postOrder(@RequestBody Map<Integer, > order) {
//        try {
//            Set<Integer> tables = order.keySet();
//
//            for (Integer s : tables) {
//
//                restaurant.addNewOrderToTable(order.get(s));
//            }
//            return new ResponseEntity<>(HttpStatus.OK);
//        } catch (OrderServicesException ex) {
//            Logger.getLogger(OrdersAPIController.class.getName()).log(Level.SEVERE, null, ex);
//            return new ResponseEntity<>(ex.toString(), HttpStatus.METHOD_NOT_ALLOWED);
//        }
//    }

//    @RequestMapping(method = RequestMethod.GET, path = "/{idTable}/total")
//    public ResponseEntity<?> getTotalTableBill(@PathVariable int idTable) {
//        try {
//            return new ResponseEntity<>(restaurant.calculateTableBill(idTable), HttpStatus.OK);
//        } catch (OrderServicesException ex) {
//            Logger.getLogger(OrdersAPIController.class.getName()).log(Level.SEVERE, null, ex);
//            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
//        }
//    }
    
//    @RequestMapping(method = RequestMethod.PUT,path="/{idTable}")
//    public ResponseEntity<?> updateOrder(@PathVariable int idTable,@RequestBody Map<String, Integer> dish) {
//        
//         Set<String> tables = dish.keySet();
//         
//         for (String s : tables) {
//             restaurant.getTableOrder(idTable).addDish(s,dish.get(s));
//            
//         }
//        return new ResponseEntity<>(HttpStatus.OK);
//
//    }
    
//    @RequestMapping(method = RequestMethod.DELETE, path = "{idTable}")
//    public ResponseEntity<?> deleteOrder(@PathVariable int idTable){
//        try {
//            restaurant.releaseTable(idTable);
//            return new ResponseEntity<>(HttpStatus.OK);
//        } catch (OrderServicesException ex) {
//            Logger.getLogger(OrdersAPIController.class.getName()).log(Level.SEVERE, null, ex);
//            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
//            
//        }
//    }
    
}
