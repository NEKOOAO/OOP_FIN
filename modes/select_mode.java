package modes;

import java.awt.Point;

import shape.draw_obj;
import shape.additional_objs.select_square;

public class select_mode extends Basemode {

    private void de_select_obj(){
        for (draw_obj now_object :_canva.draw_object_arr) {
            now_object.select_obj(false);
        }
        _canva.select_obj_arr.clear();
       _canva.repaint();
    }

    @Override
    public void click(Point now) {
        de_select_obj();
        draw_obj now_obj =_canva.find_object(now);
        if(now_obj!=null){
            now_obj.select_obj(true);
            _canva.select_obj_arr.add(now_obj);
        } 
        _canva.repaint();
    }
    draw_obj now_mov_obj = null;
    Point offset = new Point();
    boolean is_select_group;
    @Override
    public void drag(Point start, Point end) {
        if(now_mov_obj==null){
            now_mov_obj =_canva.find_object(start);
            if(now_mov_obj!=null)offset = new Point(end.x-now_mov_obj.pt.x,end.y-now_mov_obj.pt.y );
        }
        if(now_mov_obj!=null){
            end.x-=offset.x;
            end.y-=offset.y;
            now_mov_obj.move_obj(end);
        }
        else{
            select_group(start,end);
        }
        _canva.repaint();
   }
   Point select_start;
   select_square select_square= new select_square();
   private void select_group(Point start,Point end){
    de_select_obj();
    if(is_select_group == false){
        _canva.canva_obj_arr.add(select_square);
        is_select_group = true;
    }
    Point left_up = new Point(Math.min(start.x,end.x), Math.min(start.y,end.y));
        Point right_down = new Point(Math.max(start.x,end.x), Math.max(start.y,end.y));
        for (draw_obj obj : _canva.draw_object_arr) {
            if(obj.try_select(left_up, right_down)){
                obj.select_obj(true);
                _canva.select_obj_arr.add(obj);
            }
        }
        select_square.update_pos(start,end);
    }

   @Override
   public void release(Point pt){
        now_mov_obj = null;
        offset = null;
        _canva.canva_obj_arr.remove(select_square);
        is_select_group = false ;
        _canva.repaint();
   }

    @Override
    public void activate() {
   }

    @Override
    public void deactivate() {
        de_select_obj();
   }

}
