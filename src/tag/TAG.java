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


public class TAG {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InputTextArea screen;
        screen = new InputTextArea();
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
        

        
        
        TagWorld world = new TagWorld();
        
        screen.textArea.append("Testing the APPEND");
                
        world.createNewObject("NEW OBJECT");
        
        for(TagObject obj : world.objects) {
            screen.textArea.append("\n PRINT ALL OBJECTS: " + obj.getPropByName("name").getPropStrVal() + "\n");
        }
            for(int i = 0; i < testArray.length; ++i) {
            String prop = testArray[i][0];
            
            if(testArray[i][1].matches("\\d+")) {
                world.objects.get(0).properties.add(new TagProperty(prop, Integer.parseInt(testArray[i][1])));
            }
            else {
                world.objects.get(0).properties.add(new TagProperty(prop, testArray[i][1]));
            }
            
        }
         
        for(TagProperty prop : world.objects.get(0).properties) {
            String tempStr;
            tempStr = prop.getPropName(); 
            screen.textArea.append(tempStr + " ");
            
            if(prop.hasIntVal()) {
                tempStr = prop.getPropIntVal().toString() + " is Integer";
            }
            else {
                tempStr = prop.getPropStrVal() + " is String";
            }
            
            screen.textArea.append(tempStr + "\n");
                    
        }
        
    }
    
    
    
}
