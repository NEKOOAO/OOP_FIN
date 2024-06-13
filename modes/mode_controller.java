package modes;

import java.awt.Point;
import java.util.HashMap;

import modes.factory.line_factorys.*;
import modes.factory.obj_factorys.*;


import window.canva;

public class mode_controller {
    HashMap<mode_list,Basemode> mode_arr;
    mode_list now_mode;
    canva canva;
    private static mode_controller main_mode_con;
    private mode_controller(){
        mode_arr = new HashMap<>();
        create_mode();
        change_mode(mode_list.select_mode);
    }
    public static mode_controller get_mode_con(){
        if(main_mode_con==null){
            main_mode_con = new mode_controller();
        }
        return main_mode_con;
    } 
    public void init(canva canva){
       
    }
    private void create_mode(){
        mode_arr.put(mode_list.create_mode_class, new create_mode(new class_obj_factory()));
        mode_arr.put(mode_list.create_mode_usecase, new create_mode(new use_case_factory()));
        mode_arr.put(mode_list.select_mode, new select_mode());
        mode_arr.put(mode_list.line_mode_assoc, new line_mode(new association_line_factory()));
        mode_arr.put(mode_list.line_mode_comp, new line_mode(new composition_line_factory()));
        mode_arr.put(mode_list.line_mode_gen, new line_mode(new generalization_line_factory()));

    }
    public void change_mode(mode_list to_mode){
        if(now_mode!=null)mode_arr.get(now_mode).deactivate();
        now_mode = to_mode;
    }
    public void click(Point now){
        mode_arr.get(now_mode).click(now);
    }
    public void drag(Point start, Point end){
        mode_arr.get(now_mode).drag(start, end);
    }
    public void release(Point end) {
        mode_arr.get(now_mode).release(end);
   }
}
