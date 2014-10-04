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
        
       
        
      //  InputTextArea.main(args);
        
        TagWorld world = new TagWorld();
        
        screen.textArea.append("Testing the APPEND");
        
        TagObject object;
        
        object = new TagObject(world, "NEW OBJECT");
        
        screen.textArea.append("\n" + object.objectName + "\n");
        
        
    }
    
    
    
}
