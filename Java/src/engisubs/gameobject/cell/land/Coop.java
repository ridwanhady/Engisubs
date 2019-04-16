package engisubs.gameobject.cell.land;

import java.util.*;

public class Coop extends Land{

    public Coop(Map <String, Integer> _position){
        super(_position, true, LandType.BARN);
    }

    public Coop(Map <String, Integer> _position, boolean _isGrown){
        super(_position, _isGrown, LandType.COOP);
    }
}