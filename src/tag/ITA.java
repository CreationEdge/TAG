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

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.*;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.swing.*;

public class ITA extends JPanel implements ActionListener {
    protected JTextField textField;
    protected JTextArea textArea;
    protected JFrame frame;
    protected TagWorld world;
     public ITA() {
        super(new GridBagLayout());
        
        textField = new JTextField(128);
        textField.addActionListener(this);

        textArea = new JTextArea(32,128);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        //Add components
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        add(scrollPane, c);
        
        
        c.fill = GridBagConstraints.HORIZONTAL;
        add(textField, c);
        
        
        textField.requestFocusInWindow();
        
//        String[][] strArray =  new String[][] {
//            {"123","name1"},
//            {"234","name2"}
//        };
        
        CopyOnWriteArrayList<String[]> cowlist;
        cowlist = new CopyOnWriteArrayList<>();
        //cowlist.addAll(Arrays.asList(strArray));
        
//        ArrayList<String[]> list = new ArrayList<>(strArray.length);
//        list.addAll(Arrays.asList(strArray));
//        
//        list.stream().forEach((listItem) -> {
//            textArea.append(listItem[1] + "\n");
//        });
        
        cowlist.stream().forEach((listItem) -> {
            textArea.append("ID: " + listItem[0] + " NAME: " + listItem[0] + "\n");
        });
                
        frame = new JFrame("TAG Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(this);

        frame.pack();
        frame.setVisible(true);    
    
    }

    public void actionPerformed(ActionEvent evt) {
        String text = textField.getText();
//        String regex = "(^\')|(\\s+)";
        String regex = "(\\s+)";
        
        TAG.commander.parseCommands(text);    
        
//        if(!text.equals("")) {
//            
//            String[] splitText = text.split(regex);
//            Boolean isCommand = false;
//            String command;
//            command = splitText[0].toLowerCase(Locale.ROOT);
//            for(String com : TAG.commands) {
//                if(splitText[0].toLowerCase(Locale.ROOT).equals(com.toLowerCase(Locale.ROOT))) {
//                    //check commands
//                    isCommand = true;
//                    break;
//                }
//            }
//            
//            if(!isCommand) {
//                for(String com : TAG.commands) {
//                    if(com.startsWith(command)) {
//                        command = com;
//                        isCommand = true;
//                        break;
//                    }
//                }                    
//                if(!isCommand) {
//                    textArea.append("\nNot a command\n");
//                }
//            }
//            if(isCommand) {
//                if(command.equals("close")) {
//                    TAG.world.close();
//                }
//                if(command.equals("say")) {
//                    TAG.world.sayTo(splitText, "say");
//                    textArea.append("This should work");
//                }
//                if(command.equals("testp")) {
//                    TAG.commander.testPrintAll();
//                }
//                
//            }
//
//            int max = splitText.length;
//                if(splitText[0].charAt(0) == '\'') {
//                    TAG.world.sayTo(splitText, "'");
//                }
//            else {
//                for(int i = 0; i < max; i++) {
//                    textArea.append((i+1) + " " + splitText[i] + "\n");
//                }
//               // textArea.append(text + "\n");
//            }
//        }
        textField.selectAll();
        
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }

    public void addText() {
        textArea.append("Testing addText()\n");
    }
}

