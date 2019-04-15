import engisubs.gameobject.GameObject;
import engisubs.gameobject.cell.land.Land;

abstract class FarmAnimal extends GameObject {
    protected static int animalCount = 0;
    protected int position_row;
    protected int position_col;
    protected Boolean hungry = false;
    protected int timeUntilDead = 10;
    protected int timeUntilHungry = 0;
    protected Boolean isProductProduced = false;
    protected String name = "";
    protected Land landPos;
    protected Boolean killable = false;

    public FarmAnimal(){

    }

    protected void initializeFarmAnimal(int _position_row, int _position_col, String _name, Land _landPos){
        position_row = _position_row;
        position_col = _position_col;
        name = _name;
        landPos = _landPos;
    }

    public int getPositionRow(){
        return position_row;
		}
		
		public int getPositionCol(){
				return position_col;
	}

    public int getTimeUntilDead(){
        return timeUntilDead;
    }

    public int getTimeUntilHungry(){
        return timeUntilHungry;
    }

    public Boolean getIsProductProduced(){
        return isProductProduced;
    }

    public String getName(){
        return name;
    }

    public Land getLandPos(){
        return landPos;
    }

    public Boolean isKillable(){
        return killable;
    }

    public abstract void talk();

    protected void setPosition(int _position_row, int _position_col){
				position_row = _position_row;
				position_col = _position_col;
    }

    protected void setTimeUntilDead(int _timeUntilDead){
        timeUntilDead = _timeUntilDead;
    }
}