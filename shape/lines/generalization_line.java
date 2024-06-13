package shape.lines;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import shape.baseline;
import shape.additional_objs.port;

public class generalization_line extends baseline{

    public generalization_line(port start) {
        super(start);
       arrow_list.add( new Point(-10,10));
       arrow_list.add( new Point(-10,-10));
    }

    @Override
    public void draw(Graphics g){
        super.draw(g);
        int[] ptx = new int[]{end_point.x,new_arrow_pt.get(0).x,new_arrow_pt.get(1).x};
        int[] pty = new int[]{end_point.y,new_arrow_pt.get(0).y,new_arrow_pt.get(1).y};
        g.setColor(Color.white);
        g.fillPolygon(ptx, pty, 3);
        g.setColor(Color.black);
        g.drawPolygon(ptx, pty, 3);
        
    }
    
}
