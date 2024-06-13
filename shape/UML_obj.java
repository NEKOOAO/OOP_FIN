package shape;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;

import shape.additional_objs.port;

public abstract class UML_obj extends draw_obj {
    protected Font font = new Font(Font.DIALOG, Font.BOLD, 14);
    protected String class_name = new String("class");
    int textdy = 25,portlen = 10;
    port[] ports = new port[4];
    Point[] port_pt = new Point[4];
    boolean[] port_activate = new boolean[4];

    public UML_obj(Point pt,int hei,int len) {
        super(pt, hei, len);

        for (int i = 0; i < port_activate.length; i++) {
            port_activate[i] = false;
        }
        set_port_pt();
        for(int i = 0;i<4;i++){
            ports[i] = new port(port_pt[i],portlen);
        }
    }
    private void set_port_pt(){
        port_pt = new Point[]{
            new Point(pt.x+length/2,pt.y-portlen/2),
            new Point(pt.x+length/2,pt.y+heigth+portlen/2),
            new Point(pt.x-portlen/2,pt.y+heigth/2),
            new Point(pt.x+length+portlen/2,pt.y+heigth/2)
        };
    }
    @Override
    public void draw(Graphics g){
        if(is_select){
            for (port now_port : ports) {
                now_port.draw(g);
            }
        }
    }


    public port connect_port(Point pt){
        double port_dis ;
        double mindis=-1;
        int min_id = -1;
        for (int i = 0; i < port_pt.length; i++) {
            port_dis = (Math.abs(pt.x-port_pt[i].x)+Math.abs(pt.y-port_pt[i].y));
            if(min_id == -1 || mindis > port_dis){
                min_id = i;
                mindis = port_dis;
            }
        }
       // port_activate[min_id] = true;
        return ports[min_id];
    }
    @Override 
    public void move_obj(Point new_pt){
        super.move_obj(new_pt);
        set_port_pt();
        for (int i = 0; i < ports.length; i++) {
            ports[i].move_obj(port_pt[i]);
        }
    }

    public void change_name(String new_name){
        class_name = new_name;
    }


    

     
}
