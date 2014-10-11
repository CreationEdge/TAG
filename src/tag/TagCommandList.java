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
    protected CopyOnWriteArrayList<TagParameters> parameters;
    
    TagCommandList(String _name) {
        name = _name;
        parameters = new CopyOnWriteArrayList<>();
        
    }

    protected void addCommandParams(String sysCommand, String[] _params) {
        TagParameters params;
        Integer i;
        i = getNextIndex();
        params = new TagParameters(i, sysCommand, _params);
        parameters.add(params);
    }
    
    protected Integer getNextIndex() {
        Integer value = 1;
        if(parameters != null) {
            Integer length = parameters.size();
            Integer currIDs[] = new Integer[length];
            
            for(int i = 0; i < length; i++) {
                currIDs[i] = parameters.get(i).key;
            }
            Arrays.sort(currIDs);      
            
            for(int i = 0; i < currIDs.length; i++) {
                int next = i + 1;
                if(next < currIDs.length) { //Next is in the array
                    if(currIDs[i]+1 != currIDs[next]) {
                        //Then next value is has free gap of at least 1
                        //Return the free gap
                        value = i + 1;
                        break;
                    }
                    else { //Next value is not in the array, add to end
                        value = i + 1;
                        break;
                    }
                }
            }
        }
        
        return value;
    }
    
    protected String getCommandName(String _name) {
        return this.name;
    }
    
    protected Integer getCommandKey(int i) {
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
    
    protected Integer getCommandCount() {
        return this.parameters.size();
    }
    
    protected TagParameters getCommands(int index) {
        return this.parameters.get(index);
    }
    
    protected void updateCommandName(String _name) {
        name = _name;
    }
    
    protected void updateCommandsByKey(Integer key, String[] coms) {
        int index = this.getIndexByKey(key);
        parameters.get(index).params = coms;
    }
}
