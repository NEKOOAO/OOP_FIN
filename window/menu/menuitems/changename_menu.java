package window.menu.menuitems;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import window.canva;

public class changename_menu extends JMenuItem {
    public changename_menu() {
        super("change object name");
        addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (canva.get_canva().select_obj_arr.size() == 1) {
                    JOptionPane optionPane = new JOptionPane();
                    String new_name = optionPane.showInputDialog("change name", "input name");
                    if (new_name != null) {
                        (canva.get_canva().select_obj_arr.get(0)).change_name(new_name);
                       canva.get_canva(). repaint();
                    }
                }
            }
        });
    }

}
