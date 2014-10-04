/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tag;

/**
 *
 * @author Grayson
 */
public class TagObject {
    int objectID;       //Should be unique key
    String objectName;  //Not necessarily unique
    
    //World has list of object #'s
    
    
    TagObject(TagWorld world){
        objectID = world.getNextFree();
        objectName = "Object";
        
      //  tagWorld.addToWorld(objectID, objectName);
    }
    
    TagObject(TagWorld world, String name) {
        objectID = world.getNextFree();
        objectName = name;
        
       // tagWorld.addToWorld(objectID, objectName);
    }
}
