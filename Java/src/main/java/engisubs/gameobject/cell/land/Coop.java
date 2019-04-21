package engisubs.gameobject.cell.land;

import java.util.*;

public class Coop extends Land{
	/**
	 * Constructor dari Coop
	 * @param  _position Posisi dari Coop
	 * @return           Instance dari Coop
	 */
    public Coop(Map <String, Integer> _position){
        super(_position, true, LandType.COOP);
    }
    /**
     * Constructor dari Coop
     * @param  _position Posisi dari Coop
     * @param  _isGrown  Menandakan apakah terdapat rumput pada Land ini
     * @return           Instance dari Coop
     */
    public Coop(Map <String, Integer> _position, boolean _isGrown){
        super(_position, _isGrown, LandType.COOP);
    }
}