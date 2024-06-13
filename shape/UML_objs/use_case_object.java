package shape.UML_objs;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import shape.UML_obj;

public class use_case_object extends UML_obj {
    int textdy = 25;
    public use_case_object(Point pt) {
        super(pt,60,100);
    }
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillOval(pt.x, pt.y, length, heigth);
        g.setColor(Color.black);
        g.drawOval(pt.x, pt.y, length, heigth);
        //System.out.println(" " +pt.x+" "+ pt.y+" "+ length+" "+ heigth);
        // find the width for the specified string.
		int stringWidth = g.getFontMetrics(font).stringWidth(class_name);
		double dx = (length - stringWidth)/2;
		g.setFont(font);	
		g.drawString(class_name, pt.x + (int)dx, pt.y + textdy);
        super.draw(g);
    }
    
    
     
}
