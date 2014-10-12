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
public class TagProperty {
    /*
    {"id": val, "prop": val)
    Val can be String or Integer
    */
    
    protected String name;
    protected String strVal = null;
    protected Integer intVal = null;
    protected Integer parentID;
    
    TagProperty(Integer id, String prop, String _val) {
        parentID = id;
        name = prop;
        strVal = _val;
        intVal = null;
        System.out.println("Added property " + name + " with strVal: " + strVal +
                " to Object#: " + parentID);
    }
    
    TagProperty(Integer id, String prop, Integer _val) {
        parentID = id;
        name = prop;
        strVal = null;
        intVal = _val;
        System.out.println("Added property " + name + " with intVal: " + intVal +
                " to Object#: " + parentID);
    }
    
    TagProperty(Integer id, String prop) {
        parentID = id;
        name = prop;
        strVal = null;
        intVal = null;
        System.out.println("Added property " + name + " with no values to Object#: " +
                parentID);
    }
    
    protected Boolean hasStrVal() {
        Boolean bool = false;
        if(this.strVal != null && !this.strVal.isEmpty()) {
            bool = true;
        }
        return bool;
    }
    
    protected Boolean hasIntVal() {
        Boolean bool = false;
        if(this.intVal != null) {
            bool = true;
        }
        return bool;
    }
        
    protected String getPropStrVal() {
         return this.strVal;
    }
    
    protected Integer getPropIntVal() {
        return this.intVal;
    }
    
    protected void setPropStrVal(String _val) {
        this.strVal = _val;
        this.intVal = null;
    }
    
    protected void setPropIntVal(Integer _val) {
        this.intVal = _val;
        this.strVal = null;
    }
    
    protected String getPropName() {
        return this.name;
    }
    
    
}
