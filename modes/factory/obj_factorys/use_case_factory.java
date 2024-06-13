package modes.factory.obj_factorys;

import java.awt.Point;

import modes.factory.obj_factory;
import shape.UML_obj;
import shape.UML_objs.use_case_object;

public class use_case_factory implements obj_factory{
    @Override
    public UML_obj create_obj(Point pt) {
        return new use_case_object(pt);
    }
}
