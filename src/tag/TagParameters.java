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
public class TagParameters {
    protected Integer key;
    protected String sysCommand;
    protected String[] params;

    TagParameters(Integer i, String command) {
        this(i, command, new String[] {""});
    }
    
    TagParameters(Integer i, String command, String[] _params) {
        sysCommand = command;
        params = _params;
    }
}
