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
    protected Integer parent;

    TagParameters(Integer _key, Integer _parent, String command) {
        this(_key, _parent, command, new String[] {""});
    }
    
    TagParameters(Integer _key, Integer _parent, String command, String[] _params) {
        sysCommand = command;
        params = _params;
        key = _key;
        parent = _parent;
    }
}
