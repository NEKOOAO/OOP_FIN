package window.menu.menuitems;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import window.canva;

public class ungroup_menu extends JMenuItem{

    public ungroup_menu(){
        super("ungroup");
        addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                canva _canva = canva.get_canva();
                if(_canva.select_obj_arr.size()>=2)return;
                _canva.select_obj_arr.get(0).remove_group();

            }
        });
    }
}