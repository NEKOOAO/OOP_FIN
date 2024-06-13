package modes;

import java.awt.Point;

import window.canva;

public abstract class Basemode {
    canva _canva;
    protected Basemode(){
        this._canva = canva.get_canva();
    }
    public abstract void click(Point now);
    public abstract void drag(Point start,Point end);
    public abstract void activate();
    public abstract void deactivate();
    public void release(Point end){};
}
