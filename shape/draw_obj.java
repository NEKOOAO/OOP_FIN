package shape;

import java.awt.Point;

import shape.additional_objs.port;

public abstract class draw_obj extends canva_object {
    protected int heigth,length;
    public Point right_pt;
    public Point pt;
    public boolean controlable;
    public draw_obj(Point pt,int hei,int len) {
        controlable = true;
        this.pt = pt;
        heigth = hei;
        length = len;
        update_rightpt();
    }
    
    public boolean try_select(Point mouse_pt){
        double dx = mouse_pt.getX()-pt.getX();
        double dy = mouse_pt.getY()-pt.getY();
        if(dx>0 && dx < length&& dy >0 &&dy<heigth &&controlable){
            return true;
        }
        else{
            return false;
        }
    }
    public void move_obj_vec(Point vec){
        Point new_pt = new Point(pt.x+vec.x, vec.y+pt.y);
        move_obj(new_pt);
    }
    public void move_obj(Point new_pt){
        pt = new_pt;
    }  
    protected boolean pt_in_block(Point now,Point left,Point right){
        if(
            left.x<now.x &&
            now.x<right.x &&
            left.y<now.y &&
            right.y>now.y&&
            controlable
        )
        {return true;}
        else 
        {return false;}
    }

    private void update_rightpt(){
        right_pt = new Point(pt.x+length,pt.y+heigth);
    }
    public boolean try_select(Point left,Point right){
        if(
            pt_in_block(pt, left, right)&&
            pt_in_block(right_pt, left, right)&&
            controlable
        )
        {return true;}
        else {return false;}
    }
    public port connect_port(Point pt){return null;}
    public void remove_group(){}
    public void change_name(String s){}
}
