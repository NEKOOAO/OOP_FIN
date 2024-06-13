package window;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JPanel;

import shape.baseline;
import shape.canva_object;
import shape.draw_obj;

public class canva extends JPanel{
    public ArrayList<draw_obj> draw_object_arr,select_obj_arr;
    public ArrayList<baseline>  line_arr;
    public ArrayList<canva_object> canva_obj_arr;
    private static canva main_canva ;
    private canva(){
        draw_object_arr = new ArrayList<>();
        select_obj_arr = new ArrayList<>();
        line_arr = new ArrayList<>();
        canva_obj_arr = new ArrayList<>();
    }
    public static canva get_canva(){
        if(main_canva == null){
            main_canva = new canva();
        }
        return main_canva;
    }
    @Override
    public void paint(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        for (int i =  draw_object_arr.size()-1; i >=0; i--) {
            if(draw_object_arr.get(i).controlable)draw_object_arr.get(i).draw(g);   
        }
        for (int i =  canva_obj_arr.size()-1; i >=0; i--) {
            canva_obj_arr.get(i).draw(g);   
        }
        for (baseline line : line_arr) {
            line.draw(g);
        }
    }
    public draw_obj find_object(Point pt){
        for (draw_obj now_object : draw_object_arr) {
            if(now_object.try_select(pt)){
                return now_object;
            }
        }
        return null;
    }
}
