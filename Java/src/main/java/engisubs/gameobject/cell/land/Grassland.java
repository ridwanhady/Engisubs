package engisubs.gameobject.cell.land;

import java.util.*;

public class Grassland extends Land{
	/**
	 * Constructor dari Grassland
	 * @param  _position Posisi dari Grassland
	 * @return           Instance dari Grassland
	 */    
    public Grassland(Map <String, Integer> _position){
        super(_position, true, LandType.GRASSLAND);
    }
    /**
     * Constructor dari Grassland
     * @param  _position Posisi dari Grassland
     * @param  _isGrown  Menandakan apakah terdapat rumput pada Land ini
     * @return           Instance dari Grassland
     */
    public Grassland(Map <String, Integer> _position, boolean _isGrown){
        super(_position, _isGrown, LandType.GRASSLAND);
    }
}