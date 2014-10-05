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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.swing.*;

public class InputTextArea extends JPanel implements ActionListener {
    protected JTextField textField;
    protected JTextArea textArea;
    protected JFrame frame;
     public InputTextArea() {
        super(new GridBagLayout());
        
        
        
        textField = new JTextField(60);
        textField.addActionListener(this);

        textArea = new JTextArea(10, 60);
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
        
        String[][] strArray =  new String[][] {
            {"123","name1"},
            {"234","name2"}
        };
        
        CopyOnWriteArrayList<String[]> cowlist;
        cowlist = new CopyOnWriteArrayList<>();
        cowlist.addAll(Arrays.asList(strArray));
        
        ArrayList<String[]> list = new ArrayList<>(strArray.length);
        list.addAll(Arrays.asList(strArray));
        
        list.stream().forEach((listItem) -> {
            textArea.append(listItem[1] + "\n");
        });
        
        cowlist.stream().forEach((listItem) -> {
            textArea.append("ID: " + listItem[0] + " NAME: " + listItem[0] + "\n");
        });
        
//        javax.swing.SwingUtilities.invokeLater(new Runnable() {;;
//            public void run() {
//            createAndShowGUI();
//            
//            }
//        
//        });
        
        frame = new JFrame("Text Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(this);

        frame.pack();
        frame.setVisible(true);    
    

    }

    public void actionPerformed(ActionEvent evt) {
        String text = textField.getText();
        String regex = "(^\')|(\\s+)";
        
        text.trim();
        
        String[] split = text.split(regex);
        
        int max = split.length;
        
        if(split[0].equals("")) {
                textArea.append("You say, \"");
                
                for(int i = 1; i < max; i++) {
                   textArea.append(split[i]);
                   
                   if(i != max - 1) {
                       textArea.append(" ");
                   }
                }
                
                textArea.append("\"");
                
            }
        
        else {

            for(int i = 0; i < max; i++) {

                textArea.append((i+1) + " " + split[i] + "\n");
            }
           // textArea.append(text + "\n");
        }
        
        textField.selectAll();
        
        

        textArea.setCaretPosition(textArea.getDocument().getLength());
       
    }

    public void addText() {
        
        textArea.append("Testing addText()\n");
    }
    
}

