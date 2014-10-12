/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tag;

import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author Grayson
 */
public class TagWorld {
    //private static Integer[] allObjectIDs;

    protected CopyOnWriteArrayList<TagObject> objects;
    
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
        
        //allObjectIDs = new Integer[]{1,2,3,4,5};
        objects = new CopyOnWriteArrayList<>();
    }
    
    /**
     *
     * @return
     */
    public Integer getNextFree() {
        Integer value = 1;
        if(objects != null) {
            Integer length = objects.size();
    
            Integer currIDs[] = new Integer[length];

            for(int i=0; i < length; i++) {
                currIDs[i] = objects.get(i).objectID;
            }

            Arrays.sort(currIDs);

            for(int i = 0; i < currIDs.length; ++i) {
                int next = i + 1;
                if(next < currIDs.length) { //Next is in the array
                    if(currIDs[i]+1 != currIDs[next]) {
                        //Then the next value is 1 or more greater than current
                        //Return current(i) + 1, since it will be free
                        value = currIDs[i] + 1;
                        break;
                    }
                    
                }
                else { //Next is not in the array. Return i + 1
                        value = currIDs[i] + 1;
                        break;
                }
                
            }
        }
        System.out.println("Gave object ID: " + value);
        return value;
    }
    
    protected void createNewObject(String name) {
       objects.add(new TagObject(this, name));
    }
    

}