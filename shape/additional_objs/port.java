package shape.additional_objs;

import java.awt.Graphics;
import java.awt.Point;

import shape.canva_object;

public class port extends canva_object{
    Point pt;
    int port_len = 10;
    public port(Point pt,int port_len) {
        this.pt = pt;
        this.port_len = port_len;
        port_adj();
    }

    @Override
    public void draw(Graphics g) {
        g.fillRect(pt.x, pt.y, port_len, port_len);
    }

    public void move_obj(Point new_pt){
        pt = new_pt;
        port_adj();
    }

    public Point get_point(){
        return pt;
    }

    private void port_adj(){
        pt.x-=port_len/2;
        pt.y-=port_len/2;
    }
    
}
