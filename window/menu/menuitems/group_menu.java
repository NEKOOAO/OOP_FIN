package window.menu.menuitems;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import shape.draw_obj;
import shape.additional_objs.Group_obj;
import window.canva;

public class group_menu extends JMenuItem{

    public group_menu(){
        super("group");
        addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                canva _canva = canva.get_canva();
                if(_canva. select_obj_arr.size()<2){
                    return;
                }
                Point left = new Point(_canva.select_obj_arr.get(0).pt),right = new Point(_canva.select_obj_arr.get(0).pt);
                for (draw_obj obj : _canva.select_obj_arr) {
                    left.x = Math.min(left.x, obj.pt.x);
                    left.y = Math.min(left.y, obj.pt.y);
                    right.x = Math.max(right.x, obj.right_pt.x);
                    right.y = Math.max(right.y, obj.right_pt.y);
                }
                _canva.draw_object_arr.add(new Group_obj(left,right, _canva.select_obj_arr));
                for (draw_obj obj : _canva.select_obj_arr) {
                    obj.controlable = false;
                }

            }
        });
    }
}
