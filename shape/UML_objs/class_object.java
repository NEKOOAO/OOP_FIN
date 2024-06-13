package shape.UML_objs;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import shape.UML_obj;

public class class_object extends UML_obj {
    
    int textdy = 25;
    public class_object(Point pt) {
        super(pt,120,200);
    }
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(pt.x, pt.y, length, heigth);
        g.setColor(Color.black);
        g.drawRect(pt.x, pt.y, length, heigth);
        for(int i = 1;i<=2;i++){
            g.drawLine(pt.x, pt.y+heigth/3*i, pt.x+length, pt.y+heigth/3*i);
        } 
        // find the width for the specified string.
		int stringWidth = g.getFontMetrics(font).stringWidth(class_name);
		double dx = (length - stringWidth)/2;
		g.setFont(font);	
		g.drawString(class_name, pt.x + (int)dx, pt.y + textdy);
        super.draw(g);
    }
    
    
     
}
