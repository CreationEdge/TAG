/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tag;

import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author Grayson
 */
public class CommandReader {
    protected static CopyOnWriteArrayList<TagCommandList> commands;
    
    CommandReader() {
        commands = new CopyOnWriteArrayList<>();

        //Read list of valid commands from DB, create array
    }
    
    protected void testPrintAll() {
       //Test printing all the objects
        
        String testArray[][] =  {
            {"Prop1","1"},
            {"Prop2","alpha"},
            {"Prop3","1"},
            {"Prop4","alpha"},
            {"Prop5","$"},
            {"Prop6","#"},
            {"Prop7","`"},
            {"Prop8","0"},
        
        };
               
        for(TagObject obj : TAG.world.objects) {
            TAG.screen.textArea.append("\n PRINT ALL OBJECTS: " + obj.getPropByName("name").getPropStrVal() + "\n");
        }
            for(int i = 0; i < testArray.length; ++i) {
            String prop = testArray[i][0];
            
            if(testArray[i][1].matches("\\d+")) {
                TAG.world.objects.get(0).properties.add(new TagProperty(prop, Integer.parseInt(testArray[i][1])));
            }
            else {
               TAG.world.objects.get(0).properties.add(new TagProperty(prop, testArray[i][1]));
            }
            
        }
            
        for(TagProperty prop : TAG.world.objects.get(0).properties) {
            String tempStr;
            tempStr = prop.getPropName(); 
            TAG.screen.textArea.append(tempStr + " ");
            
            if(prop.hasIntVal()) {
                tempStr = prop.getPropIntVal().toString() + " is Integer";
            }
            else {
                tempStr = prop.getPropStrVal() + " is String";
            }
            
            TAG.screen.textArea.append(tempStr + "\n");
        }    
    }
    
    protected void parseCommands(String string) {
        String regex = "(^\')|(^@)|(\\s+)";
        String[] input = null;
        string = string.trim();
        Boolean isCommand = false;
        String command = null;
        TagCommandList list;
        
        
       
        
        if(!string.equals("")) {
            if(string.charAt(0) == '\'') {
                command = "say";
                isCommand = true;
            }
            
            input = string.split(regex);
            
            if(!isCommand) {
                for(TagCommandList coms : commands) {
                    if(input[0].toLowerCase(Locale.ROOT).equals(coms.name)) {
                        command = coms.name;
                        isCommand = true;
                        break;
                    }
                }
            }
            
            if(!isCommand) {
                for(TagCommandList coms : commands) {
                    if(coms.name.startsWith(input[0].toLowerCase(Locale.ROOT))) {
                        command = coms.name;
                        isCommand = true;
                        break;
                    }
                }
            }
        }
        
        if(!isCommand) {
            TAG.screen.textArea.append("Not a command\n");
        }
        
        if(isCommand) {
            list = TAG.commander.getCommandByName(command);
            //get sysCommand, execute with params
            for(TagParameters params : list.parameters) {
                executeSysCommand(params.sysCommand, params.params, input);
            }
            
        }
        
    }
    
    protected TagCommandList getCommandByName(String string) {
        TagCommandList list = null;
        
        for(TagCommandList coms : commands) {
            if(coms.name.equals(string)) {
                list = coms;
            }
        }
        return list;
    }
    
    protected void addCommand(String name) {
        Boolean isFree = true;
        
        for(TagCommandList coms : commands) {
            if(coms.name.equals(name)) {
                isFree = false;
                break;
            }
        }
        
        if(isFree) {
            commands.add(new TagCommandList(getNextParentKey(), name));
        }
    }
    
    protected void removeCommand(String name) {
        for(TagCommandList coms : commands) {
            if(coms.name.equals(name)) {
                commands.remove(coms);
            }
        }
    }
    
    protected void sayTo(String command, String text) {
        if(!text.equals("")) {
            this.addText("You " + command + ", \"" + text + "\"\n");
        }
        else {
            this.addText("Say what?\n");
        }
    }
    
    protected void addText(String text) {
        TAG.screen.textArea.append(text);
    }
    
    protected Integer getCommandKey(TagCommandList list) {
        return list.key;
    }
    
    protected Integer getNextParentKey() {
        Integer value = 1;
        if(commands != null) {
            Integer length = commands.size();
            Integer currKeys[] = new Integer[length];
            
            for(int i = 0; i < length; i++) {
                currKeys[i] = commands.get(i).key;
            }
            
            Arrays.sort(currKeys);      
            
            for(int i = 0; i < currKeys.length; i++) {
                int next = i + 1;
                if(next < currKeys.length) {//Next is in the array
                    if(currKeys[i]+1 != currKeys[next]) {
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
}
