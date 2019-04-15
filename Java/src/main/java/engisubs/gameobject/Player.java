package main.java.engisubs.gameobject;

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
		inventory = new LinkedList<Product>();
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
	/**
	 * Mengkosongkan suatu indeks pada inventory
	 * @param idx indeks pada inventory yang ingin dihapus
	 */

	public void removeInventory(int idx){
		try{
			inventory.remove(idx);
		} catch (Exception e) {
			System.err.println("Index tidak terdefinisi");
		}
		
	}
	/**
	 * Mengkosongkan inventory
	 */
	public void emptyInventory(){
		inventory.clear();
	}
	/**
	 * Getter uang
	 * @return uang
	 */
	public double getUang(){
		return uang;	
	}
	/**
	 * Getter currentRow
	 * @return currentRow
	 */
	public int getCurrentRow(){
		return currentRow;
	}
	/**
	 * Getter currentCol
	 * @return currentCol
	 */
	public int getCurrentCol(){
		return currentCol;
	}
	/**
	 * Menghitung banyaknya suatu product pada inventory
	 * @param  _product Product yang ingin dicari jumlahnya
	 * @return          Count dari suatu product
	 */
	public int getCount(Product _product){
		int cnt = 0;
		for(int i = 0; i < inventory.size(); i++){
			if(inventory.get(i).getObjectType() == _product.getObjectType()){
				cnt++;
			}
		}
	}
	/**
	 * Setter water
	 * @param _water Nilai water yang baru
	 */
	public void setWater(int _water){
		water = _water;
	}
	/**
	 * Menambah barang pada inventory
	 * @param _barang Barang yang ingin dimasukkan ke inventory
	 */
	public void addInventory(Product _barang){
		inventory.add(_barang);
	}
	/**
	 * Setter uang
	 * @param _uang Nilai uang yang baru
	 */
	public void setUang(double _uang){
		uang = _uang;
	}
	/**
	 * Setter currentRow
	 * @param _currentRow Nilai currentRow yang baru
	 */
	public void setCurrentRow(int _currentRow){
		currentRow = _currentRow;
	}
	/**
	 * Setter currentCol
	 * @param _currentCol Nilai currentCol yang baru
	 */
	public void setCurrentCol(int _currentCol){
		currentCol = _currentCol;
	}
	/**
	 * Fungsi talk berguna untuk ngobrol hewan.
	 * Hewan yang diajak ngobrol, adalah hewan
	 * yang berada di depan player.
	 */
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
	/**
	 * Fungsi interact berguna untuk melakukan
	 * interaksi dengan objek objek yang ada.
	 * Efek Interaksi bergantung pada objek yang dikenai.
	 */
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
	/**
	 * Fungsi kill berguna untuk menyembelih hewan
	 * hewan dalam kategori MeatProducing.
	 */
	public void kill(){
		Cell targetCell = getCellInFront();
		if(targetCell != NULL && targetCell.isWalkable()){
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
	/**
	 * Fungsi grow berguna untuk menumbuhkan rumput
	 * pada land yang dikenai, agar bisa dimakan oleh
	 * Hewan yang berada pada land tersebut.
	 */
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
	/**
	 * Fungsi Move berguna untuk mengubah posisi dari
	 * player sesuai dengan direction yang diberikan.
	 */
	public void move(DirectionType direction){
		int di[] = {-1,1,0,0};
		int dj[] = {0,0,1,-1};
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
	/**
	 * Mengembalikan cell yang dihadapan pemain
	 * @return Cell
	 */
	public Cell getCellInFront(){
		int di[] = {-1,1,0,0};
		int dj[] = {0,0,1,-1};
		targetRow = currentRow+di[direction];
		targetCol = currentCol+dj[direction];
		if(targetRow < 0 || targetRow >= worldMap.size() || targetCol < 0 || targetCol >= worldMap.get(0).size()){
			return NULL;
		}
		return worldMap.get(targetRow).get(targetCol);
	}
	/**
	 * Mengganti arah hadap pemain
	 * @param newDirection Direction pemain yang baru
	 */
	public void changeDirection(DirectionType newDirection){
		direction = newDirection;
	}
	/**
	 * Mengecek apakah suatu koordinat valid atau tidak
	 * @param  row row koordinat yang ingin dicek
	 * @param  col col koordinat yang ingin dicek
	 * @return     boolean true jika valid
	 */
	public boolean isValid(int row, int col){
		int n = worldMap.size();
		int m = (worldMap.get(0)).size();
		if(row < 0 || row >= n || col < 0 || col >= m){
			return false;
		}
		Cell targetCell = worldMap.get(row).get(col);
		if(!targetCell.isWalkable()){
			return false;
		}
		Land targetLand = (targetCell);
		if(targetLand.isOccupied())return false;
		return true;
	}
}