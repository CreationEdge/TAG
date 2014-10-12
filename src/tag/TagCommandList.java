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
public class TagCommandList {
    protected String name;
    protected Integer key;
    protected CopyOnWriteArrayList<TagParameters> parameters;
    
    TagCommandList(Integer _key, String _name) {
        key = _key;
        name = _name;
        parameters = new CopyOnWriteArrayList<>();
        
    }

    protected void addCommandParams(String sysCommand, String[] _params) {
        TagParameters params;
        Integer childKey;
        childKey = getNextChildKey();
        params = new TagParameters(childKey, this.key, sysCommand, _params);
        parameters.add(params);
    }
    
    protected Integer getNextChildKey() {
        Integer value = 1;
        if(parameters != null) {
            Integer length = parameters.size();
            Integer currKeys[] = new Integer[length];
            
            for(int i = 0; i < length; i++) {
                currKeys[i] = parameters.get(i).key;
            }
            
            Arrays.sort(currKeys);      
            
            for(int i = 0; i < currKeys.length; i++) {
                int next = i + 1;
                if(next < currKeys.length) { //Next is in the array
                    if(currKeys[i]+1 != currKeys[next]) {
                        //Then next value is has free gap of at least 1
                        //Return the free gap
                        value = currKeys[i] + 1;
                        break;
                    }
                    
                }
                else { //Next value is not in the array, add to end
                        value = currKeys[i] + 1;
                        break;
                }
            }
        }
        System.out.println("Gave child key: " + key + ":" + value);
        return value;
    }
    
    protected String getCommandName() {
        return this.name;
    }
    
    protected Integer getParamKey(int i) {
        return this.parameters.get(i).key;
    }
    
    protected Integer getIndexByKey(Integer key) {
        Integer val = null;
        int length = parameters.size();
        
        for(int i = 0; i < length; i++) {
            if(this.parameters.get(i).key.equals(key)) {
                val = i;
                break;
            }
        }
        
        return val;
    }
    
    protected Integer getParamCount() {
        return this.parameters.size();
    }
    
    protected TagParameters getParams(int index) {
        return this.parameters.get(index);
    }
    
    protected void updateCommandName(String _name) {
        name = _name;
    }
    
    protected void updateParamByKey(Integer key, String[] coms) {
        int index = this.getIndexByKey(key);
        parameters.get(index).params = coms;
    }
}
