/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tag;

import java.util.ArrayList;

/**
 *
 * @author Grayson
 */
public class TagObject {
    
    
    int objectID;       //Should be unique key
    String objectName;  //Not necessarily unique
    ArrayList<TagProperty> properties;
    
    TagProperty tempProp;
    Integer tempID;
    
    private void mkDummyProps() {
        for(int i = 0; i < 50; ++i) {
            tempProp = new TagProperty(Integer.toString(i));
            if(i%2 == 0) {
                tempProp.setPropIntVal(i);
            }
            else {
                tempProp.setPropStrVal("Val"+Integer.toString(i));
            }
            properties.add(tempProp);
        }

    }

    //World has list of object #'s
       
    TagObject(TagWorld world){
        this(world, "Object");
      //  tagWorld.addToWorld(objectID, objectName);
    }
    
    TagObject(TagWorld world, String name) {
        objectID = world.getNextFree();
        objectName = name;
        
        properties = new ArrayList<>();
        
        properties.add(new TagProperty("id", objectID));
        properties.add(new TagProperty("name", objectName));
        
       // this.mkDummyProps();
       // tagWorld.addToWorld(objectID, objectName);
    }  
}
