/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.controlller;
import edu.eci.arsw.blueprints.BlueprintAPIController;
import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.services.BlueprintsServices;
import java.util.Collection;
import java.util.HashMap;
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
    public ResponseEntity<?> getAllBluePrints() {
        try {
            return new ResponseEntity<>(blueprint.getAllBlueprints(), HttpStatus.OK);
        } catch (BlueprintNotFoundException ex) {
            Logger.getLogger(BlueprintAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("There are no blueprints",HttpStatus.NOT_FOUND);
        }
        
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{author}")
    public ResponseEntity<?> getBluePrintsbyAuthor(@PathVariable("author") String author)  {
        
        try {
            return new ResponseEntity<>(blueprint.getBlueprintsByAuthor(author), HttpStatus.OK);
        } catch (BlueprintNotFoundException ex) {
            Logger.getLogger(BlueprintAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("There are no blueprints",HttpStatus.NOT_FOUND);
        }
        
    }
    
    
    
    
    @RequestMapping(method = RequestMethod.GET, path = "/{author}/{name}")
    public ResponseEntity<?> getBluePrint(@PathVariable("author") String author,@PathVariable("name") String name) {
        
        
        try {
            return new ResponseEntity<>(blueprint.getBlueprint(author,name), HttpStatus.OK);
        } catch (BlueprintNotFoundException ex) {
            Logger.getLogger(BlueprintAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("There are no blueprints",HttpStatus.NOT_FOUND);
        }
        
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> postBlueprint(@RequestBody Map<String,String> bp){
            
            Blueprint bp0 = new Blueprint();
             try {
                 if(bp.get("points") == null && bp.get("author")!= null && bp.get("name")!=null){
                bp0 = new Blueprint(bp.get("author"), bp.get("name"));
            }else if(bp.get("points") != null){
                System.out.println(bp.get("points"));
                bp0 = new Blueprint(bp.get("author"), bp.get("name"),new Point[]{new Point(40, 40),new Point(15, 15)});
            }
            blueprint.addNewBlueprint(bp0);
            return new ResponseEntity<>(HttpStatus.OK); 
        } catch (BlueprintPersistenceException ex) {
            Logger.getLogger(BlueprintAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error modifying the "+bp.get("name")+" blueprint of the author "+bp.get("author"), HttpStatus.FORBIDDEN);
        }
            
    }
    
    
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
