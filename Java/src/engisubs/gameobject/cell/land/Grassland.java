package engisubs.gameobject.cell.land;

import java.util.*;

public class Grassland extends Land{

    public Grassland(Map <String, Integer> _position){
        super(_position, true, LandType.GRASSLAND);
    }

    public Grassland(Map <String, Integer> _position, boolean _isGrown){
        super(_position, _isGrown, LandType.GRASSLAND);
    }
}