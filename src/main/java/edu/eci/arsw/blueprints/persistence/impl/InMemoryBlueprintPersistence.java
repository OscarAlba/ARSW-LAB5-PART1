/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.persistence.impl;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.persistence.BlueprintsPersistence;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Service;

/**
 *
 * @author hcadavid
 */
@Service
public class InMemoryBlueprintPersistence implements BlueprintsPersistence{

    private final Map<Tuple<String,String>,Blueprint> blueprints=new ConcurrentHashMap<>();
    
    public InMemoryBlueprintPersistence() {
        
        //load stub data
        Point[] pts1=new Point[]{new Point(10, 14),new Point(11, 11)};
        Blueprint bp1=new Blueprint("_authorname_", "_bpname_",pts1);
        blueprints.put(new Tuple<>(bp1.getAuthor(),bp1.getName()), bp1);
        
        Point[] pts2 = new Point[] {new Point(202,35), new Point(15,2), new Point(1,20)};
        Blueprint bp2 = new Blueprint("Manuel","Home",pts2);
        blueprints.put(new Tuple<>(bp2.getAuthor(),bp2.getName()), bp2);
        
        Point[] pts3 = new Point[] {new Point(5,170), new Point(30,78)};
        Blueprint bp3 = new Blueprint("Dario", "Petronila", pts3);
        blueprints.put(new Tuple<>(bp3.getAuthor(),bp3.getName()), bp3);
        
        Point[] pts4 = new Point[] {new Point(48,22), new Point(29,52), new Point(85,22)};
        Blueprint bp4 = new Blueprint("Luciana", "Frozen", pts4);
        blueprints.put(new Tuple<>(bp4.getAuthor(),bp4.getName()), bp4);
        
        Point[] pts5 = new Point[] {new Point(408,22), new Point(99,52), new Point(85,220)};
        Blueprint bp5 = new Blueprint("Ricaro", "Petardinho", pts5);
        blueprints.put(new Tuple<>(bp5.getAuthor(),bp5.getName()), bp5);
    }    

    @Override
    public void saveBlueprint(Blueprint bp) throws BlueprintPersistenceException {
        if (blueprints.containsKey(new Tuple<>(bp.getAuthor(),bp.getName()))){
            throw new BlueprintPersistenceException("The given blueprint already exists: "+bp);
        }
        else{
            blueprints.putIfAbsent(new Tuple<>(bp.getAuthor(),bp.getName()), bp);
//            blueprints.put(new Tuple<>(bp.getAuthor(),bp.getName()), bp);
        }        
    }
   
    @Override
    public Blueprint getBlueprint(String author, String bprintname) throws BlueprintNotFoundException {
        return blueprints.get(new Tuple<>(author, bprintname));
    }
    
    @Override
    public Set<Blueprint> getBlueprintsbyAuthor(String author) throws BlueprintNotFoundException {
         Collection<Blueprint> values = blueprints.values();
         Set<Blueprint> authorBlueprints = new HashSet<>();
          for (Blueprint i: values) {
                if(i.getAuthor().equals(author)){
                    authorBlueprints.add(i);
                }
           }
          
        return authorBlueprints;
    }
    
    @Override
    public Set<Blueprint> getAllBlueprints() throws BlueprintNotFoundException {
        Collection<Blueprint> allValues = blueprints.values();
         Set<Blueprint> allBlueprints = new HashSet<>();
         allValues.forEach((i) -> {
             allBlueprints.add(i);
        });
        return allBlueprints;
    }

    

}
