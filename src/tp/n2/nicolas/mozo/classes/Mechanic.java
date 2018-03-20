/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.n2.nicolas.mozo.classes;

import tp.n2.nicolas.mozo.interfaces.IGarageObserver;

/**
 *
 * @author Yo
 */
public class Mechanic implements IGarageObserver{

    @Override
    public void update(Object o) {
        System.out.println(o.toString());
    }
    
}
