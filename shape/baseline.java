package shape;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import shape.additional_objs.port;

public abstract class baseline extends canva_object{
    port start,end = null;
    protected Point start_point,end_point;
    protected int arrow_len = 40;
    protected ArrayList<Point> arrow_list;
    protected ArrayList<Point> new_arrow_pt;
    public baseline(port start){
        this.start = start;
        arrow_list = new ArrayList<>();
    }
    public void draw(Graphics g){
        start_point = start.get_point();
        if(end != null)end_point = end.get_point();
        g.drawLine(start_point.x, start_point.y, end_point.x, end_point.y);
        new_arrow_pt = new ArrayList<>();
      for (Point point : arrow_list) {
           new_arrow_pt.add(rotate(point,start_point,end_point));
         
        }
    }
    public void set_end_port(port port){
        end = port;
    }
    public void set_line_end(Point pt){
        end_point = pt;
    }
    protected Point rotate(Point pt,Point start,Point end){
        Point vec = new Point(end.x - start.x, end.y-start.y);
        Point ret = new Point();
        double sin = (vec.getY()/vec.distance(0, 0));
        double cos = (vec.getX()/vec.distance(0, 0));
        ret.x = (int) (pt.x * cos - pt.y*sin);
        ret.y = (int) (pt.x * sin + pt.y*cos);
        ret.x+=end.x;
        ret.y+=end.y;
        return ret;
    }
    

}
