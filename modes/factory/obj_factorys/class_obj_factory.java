package modes.factory.obj_factorys;

import java.awt.Point;

import modes.factory.obj_factory;
import shape.UML_obj;
import shape.UML_objs.class_object;

public class class_obj_factory implements obj_factory{
    @Override
    public UML_obj create_obj(Point pt) {
        return new class_object(pt);
    }
}
