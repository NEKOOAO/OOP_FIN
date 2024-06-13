package modes;

import java.awt.Point;

import modes.factory.obj_factory;

public class create_mode extends Basemode {
    obj_factory my_factory;
    public create_mode(obj_factory fac){
        my_factory = fac;
    }

    @Override
    public void click(Point now) {
        _canva.draw_object_arr.add(my_factory.create_obj(now));
        _canva.repaint();
    }

    @Override
    public void drag(Point start, Point end) {
    }

    @Override
    public void activate() {
   }

    @Override
    public void deactivate() {
   }
    
}
