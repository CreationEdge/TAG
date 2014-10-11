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


public class TAG {
    protected static TagWorld world;
    protected static ITA screen;
    protected static CopyOnWriteArrayList<String> commands;
    protected static CommandReader commander;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        commander = new CommandReader();
        
        commands = new CopyOnWriteArrayList<>();
        
        commander.addCommand("close");
        commander.addCommand("say");
        commander.addCommand("testp");
        String[] blank;
        blank = new String[] {""};
        commander.getCommandByName("close").addCommandParams("close", blank);
        commander.getCommandByName("say").addCommandParams("say", blank);
        commander.getCommandByName("testp").addCommandParams("testp", blank);
  
        //Create the world
        world = new TagWorld();
        
        //Create the UI
        screen = new ITA();
        
        screen.textField.setFocusable(true);
        
        screen.textField.requestFocusInWindow();
        
        //screen.textArea.append("Testing the APPEND");
                
        //Add an object to the world
        world.createNewObject("NEW OBJECT");
        
        //screen.testPrintAll(world);
        
        screen.textField.requestFocusInWindow();
    }
}
