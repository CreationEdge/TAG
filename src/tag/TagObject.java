/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tag;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author Grayson
 */
public class TagObject {
    
    
    Integer objectID;       //Should be unique key
    String objectName;  //Not necessarily unique
    CopyOnWriteArrayList<TagProperty> properties;
    
    TagProperty tempProp;
    Integer tempID;
    
    private void mkDummyProps() {
        for(int i = 0; i < 50; ++i) {
            tempProp = new TagProperty(objectID, Integer.toString(i));
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
        this(world, world.getNextFree(), "Object");
      //  tagWorld.addToWorld(objectID, objectName);
    }
    
    TagObject(TagWorld world, String name) {
        this(world, world.getNextFree(), name);
        
       // this.mkDummyProps();
       // tagWorld.addToWorld(objectID, objectName);
    }  
    
    TagObject(TagWorld world, Integer id, String name) {
        properties = new CopyOnWriteArrayList<>();
        objectID = id;
        objectName = name;
        
//        properties.add(new TagProperty(objectID, "id", id));
//        properties.add(new TagProperty(objectID, "name", name));
//        
        System.out.println("Created object " + name + " with ID: " + id);
    }
    
    protected TagProperty getPropByName(String name) {
        for(TagProperty prop : properties) {
            if(prop.getPropName().equals(name)) {
                return prop;
            }
        }
        return null;
    }
    
    protected Integer getID() {
        Integer val;
        val = this.getPropByName("id").getPropIntVal();
        return val;
    }

}
