/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.beans.impl;

import edu.eci.arsw.blueprints.beans.FilterPoint;
import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import java.util.List;

/**
 *
 * @author OscarAlba
 */
public class FilterSubsampling implements FilterPoint{

    @Override
    public void removePoints(Blueprint bp) {
        
        List<Point> points = bp.getPoints();
        for (int i=1;i<points.size();i+=2) {
              points.remove(i);
           }
        
        bp.setPoints(points); 
    }
}
