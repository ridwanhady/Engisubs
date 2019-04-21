package engisubs.gameobject.cell.land;

import java.util.*;

public class Barn extends Land{
	/**
	 * Constructor dari Barn
	 * @param  _position Posisi dari Barn
	 * @return           Instance dari Barn
	 */
    public Barn(Map <String, Integer> _position){
        super(_position, true, LandType.BARN);
    }
    /**
     * Constructor dari Barn
     * @param  _position Posisi dari Barn
     * @param  _isGrown  Menandakan apakah terdapat rumput pada Land ini
     * @return           Instance dari Barn
     */
    public Barn(Map <String, Integer> _position, boolean _isGrown){
        super(_position, _isGrown, LandType.BARN);
    }
}