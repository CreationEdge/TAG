/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tag;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Grayson
 */
public class TagWorld {
    //private static Integer[] allObjectIDs;
    private ArrayList<Integer> allIDs;
    protected ArrayList<TagObject> objects = null;
    
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
                currIDs[i] = objects.get(i).getID();
            }

            Arrays.sort(currIDs);

            for(int i = 0; i < currIDs.length; ++i) {
                int next = i + 1;
                if(next < currIDs.length) { //Next is in the array
                    if(currIDs[i]+1 != currIDs[next]) {
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
        }
        return value;
    }
    
    protected void createNewObject(String name) {
        if(objects == null) {
            objects = new ArrayList<>();
        }
        objects.add(new TagObject(this, name));
    }
    
    protected void sayTo(String[] text, String command) {
        Integer max = text.length;    
        String[] firstWord;
        Boolean isShortcut = false;
        String regex = "^\'";
        
        if(command.equals("'")) {
            command = "say";
            isShortcut = true;
        }

        if(isShortcut) {
            firstWord = text[0].split(regex);  
            if(firstWord.length > 1) {
                TAG.screen.textArea.append("You " + command + ", \"" + firstWord[1]);
                for(int i = 1; i < max; i++) {
                    TAG.screen.textArea.append(" ");

                    TAG.screen.textArea.append(text[i]);
                  }
                TAG.screen.textArea.append("\"\n");
            }  
          
        }
        
        else {
            TAG.screen.textArea.append("You " + command + ", \"");
            for(int i = 1; i < max; i++) {
                TAG.screen.textArea.append(text[i]);
                if(i + 1 < max) {
                    TAG.screen.textArea.append(" ");
                }
              }
            TAG.screen.textArea.append("\"\n");
        }   
    }
}