package engisubs.gameobject;

public class Player extends GameObject{
 	/**
 	 * Nama pemain
 	 */
	private String player_name;
	/**
	 * Kapasitas air
	 */
	private int water;
	/**
	 * Uang pemain
	 */
	private double uang;
	/**
	 * Posisi baris pemain
	 */
	private int currentRow;
	/**
	 * Posisi kolom pemain
	 */
	private int currentCol;
	/**
	 * Arah hadap pemain
	 */
	private DirectionType direction;
	/**
	 * Menyimpan worldmap
	 */
	private List<List<Cell>> worldMap;
	/**
	 * Inventory pemain untuk menyimpan product
	 */
	private List <Product> inventory;
	/**
	 * Konstruktor player
	 * @param  _name     Nama pemain
	 * @param  _water    Jumlah air awal yang dimiliki pemain
	 * @param  _uang     Jumlah uang awal yang dimiliki pemain
	 * @param  row       Posisi absis pemain
	 * @param  col       Posisi ordinat pemain
	 * @param  _worldMap Peta dunia
	 * @return           Objek Player
	 */
    public Player(String _name, int _water, double _uang, int row, int col, List<List<Cell>> _worldMap){
		setName(_name);
		setWater(_water);
		setUang(_uang);
		setPosition(x,y);
		initGameObject(PLAYER, 'P');
		worldMap = _worldMap;
		inventory = new LinkedList<Product>;
	}
	/**
	 * Getter nama pemain
	 * @return player_name
	 */
	public String getName() {
		return player_name;
	}
	/**
	 * Getter air pemain
	 * @return water
	 */
	public int getWater() {
		return water;
	}
	/**
	 * Getter inventory
	 * @return inventory
	 */
	public List<Product> getInventory(){
		return inventory;
	}

	public void removeInventory(int idx){
		try{
			inventory.remove(idx);
		} catch {
			System.err.println("Index tidak terdefinisi");
		}
		
	}

	public void emptyInventory(){
		inventory.clear();
	}

	public double getUang(){
		return uang;	
	}

	public int getCurrentRow(){
		return currentRow;
	}

	public int getCurrentCol(){
		return currentCol;
	}
	
	public int getCount(Product _product){
		int cnt = 0;
		for(int i = 0; i < inventory.size(); i++){
			if(inventory.get(i).getObjectType() == _product.getObjectType()){
				cnt++;
			}
		}
	}

	public void setWater(int _water){
		water = _water;
	}

	public void addInventory(Product _barang){
		inventory.add(_barang);
	}

	public void setUang(double _uang){
		uang = _uang;
	}

	public void setCurrentRow(int _currentRow){
		currentRow = _currentRow;
	}

	public void setCurrentCol(int _currentCol){
		currentCol = _currentCol;
	}

	public void talk(){
		Cell targetCell = getCellInFront();
		if(targetCell.isWalkable()){
			Land targetLand = targetCell;
			if(targetLand.isOccupied()){
				FarmAnimal targetAnimal = (targetLand.getObjectHere());
				targetAnimal.talk();
				return;
			}
		} 
		throw logic_error("Tidak ada hewan disitu");
	}

	public void interact(){
		Cell targetCell = getCellInFront();
		if(targetCell != NULL){
			if(targetCell.isWalkable()){
				Land targetLand = (targetCell);
				if(targetLand.getObjectHere() != NULL){
					targetLand.getObjectHere().interact(this);
					//cout << "INTERACT DIPANGGIL" << endl;
					return;
				}
			} else {
				Facility targetFacility = (targetCell);
				targetFacility.interact(this);
				return;
			}
		}
		throw logic_error("Tidak ada object yang bisa dilakukan interact disitu");
	}

	public void kill(){
		Cell targetCell = getCellInFront();
		if(targetCell != NULL and targetCell.isWalkable()){
			Land targetLand = (targetCell);
			if(targetLand.isOccupied()){
				FarmAnimal targetAnimal = (targetLand.getObjectHere());
				if(targetAnimal.isKillable()){
					farmAnimalList.remove(farmAnimalList.get(farmAnimalList.findElement(targetAnimal)));
					MeatProducing m = (targetAnimal);
					m.produceMeat(this);
					targetLand.setObjectHere(NULL);
					return;
				}
			}
		} 
		throw logic_error("Tidak ada hewan yang bisa disembelih disitu");
	}

	public void grow(){
		Cell targetCell = worldMap.get(currentRow).get(currentCol);
		Land targetLand = (targetCell);
		if (!targetLand.isGrown()) {
			if (water > 0){
				targetLand.grow();
				water--;
			} else{
				throw logic_error("Air Anda tidak cukup");
			}
		} else {
			throw logic_error("Sudah ada Rumput di Land ini, mau dijadiin Pohon?");
		}
	}

	public void move(DirectionType direction){
		int di[4] = {-1,1,0,0};
		int dj[4] = {0,0,1,-1};
		targetRow = currentRow+di[direction];
		targetCol = currentCol+dj[direction];
		if(isValid(targetPosition, worldMap)){
			Land currentLand = (worldMap.get(currentRow).get(currentCol));
			currentLand.setObjectHere(NULL);
			currentRow = targetRow;
			currentCol = targetCol;
			currentLand = worldMap.get(targetRow).get(targetCol);
			currentLand.setObjectHere(this);
			this.direction = direction;
		} else {
			throw logic_error("Langkah tidak valid");
		}
	}

	public Cell getCellInFront(){
		int di[4] = {-1,1,0,0};
		int dj[4] = {0,0,1,-1};
		targetRow = currentRow+di[direction];
		targetCol = currentCol+dj[direction];
		if(targetRow < 0 || targetRow >= worldMap.size() || targetCol < 0 || targetCol >= worldMap.get(0).size()){
			return NULL;
		}
		return worldMap.get(targetRow).get(targetCol);
	}

	public void changeDirection(DirectionType newDirection){
		direction = newDirection;
	}

	public boolean isValid(int row, int col){
		int n = worldMap.size();
		int m = (worldMap.get(0)).size();
		if(row < 0 or row >= n or col < 0 or col >= m){
			return false;
		}
		Cell *targetCell = worldMap.get(row).get(col);
		if(!targetCell.isWalkable()){
			return false;
		}
		Land targetLand = (targetCell);
		if(targetLand.isOccupied())return false;
		return true;
	}
}