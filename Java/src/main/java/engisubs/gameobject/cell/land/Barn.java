package engisubs.gameobject.cell.land;

import java.util.*;

public class Barn extends Land{

    public Barn(Map <String, Integer> _position){
        super(_position, true, LandType.BARN);
    }
    /*
    public Barn(Map <String, Integer> _position, boolean _isGrown){
        super(_position, _isGrown, LandType.BARN);
    }
    */
}