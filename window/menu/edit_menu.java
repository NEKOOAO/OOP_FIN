package window.menu;

import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import window.menu.menuitems.changename_menu;
import window.menu.menuitems.group_menu;
import window.menu.menuitems.ungroup_menu;

public class edit_menu extends JMenu{
    ArrayList<JMenuItem> opt_list ; 
    
    public edit_menu(){
        super("edit");
        create_item();
        for (JMenuItem item : opt_list) {
            add(item);
        }
    }
    private void create_item(){
        opt_list = new ArrayList<>();
        opt_list.add(new group_menu());
        opt_list.add(new ungroup_menu());
        opt_list.add(new changename_menu());
    }
}
