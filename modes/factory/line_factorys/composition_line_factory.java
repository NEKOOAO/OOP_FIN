package modes.factory.line_factorys;

import modes.factory.line_factory;
import shape.baseline;
import shape.additional_objs.port;
import shape.lines.composition_line;

public class composition_line_factory implements line_factory{

    @Override
    public baseline create_line(port start) {
        return new composition_line(start);
    }
    
}
