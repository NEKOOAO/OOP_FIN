package shape.lines;

import java.awt.Graphics;
import java.awt.Point;

import shape.baseline;
import shape.additional_objs.port;

public class association_line extends baseline {

    public association_line(port start) {
        super(start);
        arrow_list.add(new Point(-10, 10));
        arrow_list.add(new Point(-10, -10));
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.drawLine(end_point.x, end_point.y, new_arrow_pt.get(0).x, new_arrow_pt.get(0).y);
        g.drawLine(end_point.x, end_point.y, new_arrow_pt.get(1).x, new_arrow_pt.get(1).y);
    }

}
