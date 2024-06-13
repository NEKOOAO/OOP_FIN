package window.menu;

import javax.swing.JMenuBar;

public class menu_bar  extends JMenuBar{
    edit_menu edit_menu ;
    public menu_bar(){
        edit_menu = new edit_menu();
        add(edit_menu);
    }
}
