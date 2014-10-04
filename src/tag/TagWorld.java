/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tag;

import java.util.Arrays;

/**
 *
 * @author Grayson
 */
public class TagWorld {
    private static Integer[] allObjects;
    
    TagWorld() {
        /*
            Query DB for:
                List of all objects
                List of all verbs
                List of all shortcut commands
                List of all object types
        
        
            Build world:
                Go through each object and create it without a location
                Go through each object again and update its location
            
                
        */
        allObjects = new Integer[]{1,2,3,4,5};
        
    }
    
    /**
     *
     * @return
     */
    public Integer getNextFree() {
        Arrays.sort(allObjects);
        Integer value = 0;

        for(int i = 0; i < allObjects.length; ++i) {
            int next = i + 1;
            if(next < allObjects.length) { //Next is in the array
                if(allObjects[i]+1 != allObjects[next]) {
                    //Then the next value is 1 or more greater than current
                    //Return current(i) + 1, since it will be free
                    value = i + 1;
                    break;
                }
                else { //Next is not in the array. Return i + 1
                    value = i + 1;
                    break;
                }
            }
        }

        return value;
    }
}
