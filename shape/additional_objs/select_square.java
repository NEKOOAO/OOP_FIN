package shape.additional_objs;

import java.awt.Graphics;
import java.awt.Point;

import shape.canva_object;

public class select_square extends canva_object{
    Point endpoint;
    Point pt;

    public void update_pos(Point l, Point r){
        pt = l;
        endpoint = r;
    }

    @Override
    public void draw(Graphics g) {
        g.drawRect(
        Math.min(pt.x,endpoint.x), 
        Math.min(pt.y,endpoint.y),
        Math.abs(endpoint.x-pt.x),
        Math.abs(endpoint.y-pt.y));
    }
    
}
