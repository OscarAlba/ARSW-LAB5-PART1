/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.beans.impl;

import org.springframework.stereotype.Service;
import edu.eci.arsw.blueprints.beans.FilterPoint;
import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import java.util.List;

/**
 *
 * @author OscarAlba
 */


@Service
public class FilterRedundancy implements FilterPoint{

    @Override
    public void removePoints(Blueprint bp) {
            
        List<Point> points = bp.getPoints();
        for (int i=0;i<points.size();i++) {
               if(points.get(i).getX()== points.get(i+1).getX() &&
                     points.get(i).getY()== points.get(i+1).getY()  
                       ){
                   points.remove(points.get(i));
               }
           }
        bp.setPoints(points);
    }
    
}
