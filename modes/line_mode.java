package modes;

import java.awt.Point;

import modes.factory.line_factory;
import shape.baseline;
import shape.draw_obj;
import shape.additional_objs.port;

public class line_mode extends Basemode  {
    
    draw_obj draw_obj_start ;
    private line_factory my_factory;
    public line_mode(line_factory fac){
        my_factory = fac;
    }

    baseline nowline = null;
    @Override
    public void click(Point now) {
    }

    @Override
    public void release(Point end) {
        if(nowline!=null){
            draw_obj obj_end;
            obj_end = _canva.find_object(end);
            _canva.canva_obj_arr.remove(nowline);
            if(obj_end!=null && obj_end!=draw_obj_start){
                port end_port = obj_end.connect_port(end);
                if(end_port!=null){
                    nowline.set_end_port(end_port);
                    _canva.line_arr.add(nowline);
                }
            }
        }
        draw_obj_start = null;
        nowline = null;
        _canva.repaint();
   }
    @Override
    public void activate() {
   }

    @Override
    public void deactivate() {
   }


    @Override
    public void drag(Point start, Point end) {
        if(nowline == null){
           create_new(start, end);
        }
        if(nowline!=null)nowline.set_line_end(end);
        _canva.repaint();
        
    }
    private void create_new(Point start, Point end){
        draw_obj_start = _canva.find_object(end);
        if(draw_obj_start!=null && nowline==null){
            port start_port= _canva.find_object(start).connect_port(start);
            if(start_port!=null){
                nowline = my_factory.create_line(start_port);
                _canva.canva_obj_arr.add(nowline);
            }
            else draw_obj_start = null;
        }

    }

}
