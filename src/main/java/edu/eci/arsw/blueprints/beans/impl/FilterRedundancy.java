/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.beans.impl;

import org.springframework.stereotype.Service;
import edu.eci.arsw.blueprints.beans.FilterPoint;
import edu.eci.arsw.blueprints.model.Blueprint;

/**
 *
 * @author OscarAlba
 */


@Service
public class FilterRedundancy implements FilterPoint{

    @Override
    public void removePoints(Blueprint bp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
