package shape;

import java.awt.Graphics;
import java.awt.Point;

public abstract class canva_object {
    protected boolean is_select;
    public abstract void draw(Graphics g);
    public boolean try_select(Point pt){
        return false;
    }
    public boolean try_select(Point l,Point r){
        return false;
    }
    public void select_obj(boolean is_select){
        this.is_select = is_select;
    }
}
