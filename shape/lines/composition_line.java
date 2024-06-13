package shape.lines;

import java.awt.Graphics;
import java.awt.Point;

import shape.baseline;
import shape.additional_objs.port;

public class composition_line extends baseline {

    public composition_line(port start) {
        super(start);
        arrow_len = 10;
        arrow_list.add(new Point(-arrow_len, -arrow_len));
        arrow_list.add(new Point(-arrow_len, arrow_len));
        arrow_list.add(new Point(-(int) 2 * arrow_len, 0));
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        int[] ptx = new int[] { end_point.x, new_arrow_pt.get(0).x, new_arrow_pt.get(2).x, new_arrow_pt.get(1).x };
        int[] pty = new int[] { end_point.y, new_arrow_pt.get(0).y, new_arrow_pt.get(2).y, new_arrow_pt.get(1).y };
        g.fillPolygon(ptx, pty, 4);
    }

}
