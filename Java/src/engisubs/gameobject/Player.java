package engisubs.gameobject;

import java.util.*;
import engisubs.gameobject.cell.*;
import engisubs.gameobject.cell.facility.*;
import engisubs.gameobject.cell.land.*;
import engisubs.gameobject.farmanimal.*;
import engisubs.gameobject.product.*;

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
	 * Posisi pemain
	 */
	private Map<String,Integer> currentPos;
	/**
	 * Arah hadap pemain
	 */
	private DirectionType direction;
	/**
	 * Menyimpan worldmap
	 */
	private List<LinkedList<Cell>> worldMap;
	/**
	 * Inventory pemain untuk menyimpan product
	 */
	public List<Product> inventory;
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
    public Player(String _name, int _water, double _uang, Map<String,Integer> pos, List<LinkedList<Cell>> _worldMap){
		setName(_name);
		setWater(_water);
		setUang(_uang);
		setPosition(pos);
		initGameObject(GameObject.GameObjectType.PLAYER, 'P');
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
	 * Getter currentPos
	 * @return currentPos
	 */
	public Map<String,Integer> getCurrentPos(){
		return currentPos;
	}
	/**
	 * Menghitung banyaknya suatu product pada inventory
	 * @param  _product Product yang ingin dicari jumlahnya
	 * @return          Count dari suatu product
	 */
	public int getCount(Product _product){
		int cnt = 0;
		for(int i = 0; i < inventory.size(); i++){
			if(inventory.get(i).getGameObjectType() == _product.getGameObjectType()){
				cnt++;
			}
		}

		return cnt;
	}
	/**
	 * Setter name
	 * @param _name Nilai name yang baru
	 */
	public void setName(String _name){
		player_name = _name;
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
	 * Setter currentPos
	 * @param _currentPos Nilai _currentPos yang baru
	 */
	public void setPosition(Map<String,Integer> _currentPos){
		currentPos = _currentPos;
	}
	/**
	 * Fungsi talk berguna untuk ngobrol hewan.
	 * Hewan yang diajak ngobrol, adalah hewan
	 * yang berada di depan player.
	 */
	public void talk(){
		Cell targetCell = getCellInFront();
		if(targetCell.isWalkable()){
			Land targetLand = (Land) targetCell;
			if(targetLand.isOccupied()){
				FarmAnimal targetAnimal = (FarmAnimal) targetLand.getObjectHere();
				targetAnimal.talk();
				return;
			}
		} 
		throw new RuntimeException("Tidak ada hewan disitu");
	}
	/**
	 * Fungsi interact berguna untuk melakukan
	 * interaksi dengan objek objek yang ada.
	 * Efek Interaksi bergantung pada objek yang dikenai.
	 */
	public void interact(){
		Cell targetCell = getCellInFront();
		if(targetCell != null){
			if(targetCell.isWalkable()){
				Land targetLand = (Land) targetCell;
				if(targetLand.getObjectHere() != null){
					targetLand.getObjectHere().interact(this);
					//cout << "INTERACT DIPANGGIL" << endl;
					return;
				}
			} else {
				Facility targetFacility = (Facility) targetCell;
				targetFacility.interact(this);
				return;
			}
		}
		throw new RuntimeException("Tidak ada object yang bisa dilakukan interact disitu");
	}
	/**
	 * Fungsi kill berguna untuk menyembelih hewan
	 * hewan dalam kategori MeatProducing.
	 */
	public void kill(List<FarmAnimal> farmAnimalList){
		Cell targetCell = getCellInFront();
		if(targetCell != null && targetCell.isWalkable()){
			Land targetLand = (Land) targetCell;
			if(targetLand.isOccupied()){
				FarmAnimal targetAnimal = (FarmAnimal) targetLand.getObjectHere();
				if(targetAnimal.isKillable()){
					farmAnimalList.remove(targetAnimal);
					MeatProducing m = (MeatProducing) targetAnimal;
					m.produceMeat(this);
					targetLand.setObjectHere(null);
					return;
				}
			}
		} 
		throw new RuntimeException("Tidak ada hewan yang bisa disembelih disitu");
	}
	/**
	 * Fungsi grow berguna untuk menumbuhkan rumput
	 * pada land yang dikenai, agar bisa dimakan oleh
	 * Hewan yang berada pada land tersebut.
	 */
	public void grow(){
		int currentRow = currentPos.get("Row");
		int currentCol = currentPos.get("Col");
		Cell targetCell = worldMap.get(currentRow).get(currentCol);
		Land targetLand = (Land) targetCell;
		if (!targetLand.isGrown()) {
			if (water > 0){
				targetLand.grow();
				water--;
			} else{
				throw new RuntimeException("Air Anda tidak cukup");
			}
		} else {
			throw new RuntimeException("Sudah ada Rumput di Land ini, mau dijadiin Pohon?");
		}
	}
	/**
	 * Fungsi Move berguna untuk mengubah posisi dari
	 * player sesuai dengan direction yang diberikan.
	 */
	public void move(DirectionType direction){
		int di[] = {-1,1,0,0};
		int dj[] = {0,0,1,-1};
		Map<String,Integer> targetPos = new HashMap<String,Integer>();
		int currentRow = targetPos.get("Row");
		int currentCol = targetPos.get("Col");
		targetPos.put("Row",currentRow+di[direction.getValue()]);
		targetPos.put("Col",currentCol+dj[direction.getValue()]);
		if(isValid(targetPos)){
			int targetRow = targetPos.get("Row");
			int targetCol = targetPos.get("Col");
			Land currentLand = (Land) worldMap.get(currentRow).get(currentCol);
			currentLand.setObjectHere(null);
			currentRow = targetRow;
			currentCol = targetCol;
			currentLand = (Land) worldMap.get(targetRow).get(targetCol);
			currentLand.setObjectHere(this);
			this.direction = direction;
		} else {
			throw new RuntimeException("Langkah tidak valid");
		}
	}
	/**
	 * Mengembalikan cell yang dihadapan pemain
	 * @return Cell
	 */
	public Cell getCellInFront(){
		int di[] = {-1,1,0,0};
		int dj[] = {0,0,1,-1};
		int currentRow = currentPos.get("Row");
		int currentCol = currentPos.get("Col");
		int targetRow = currentRow+di[direction.getValue()];
		int targetCol = currentCol+dj[direction.getValue()];
		if(targetRow < 0 || targetRow >= worldMap.size() || targetCol < 0 || targetCol >= worldMap.get(0).size()){
			return null;
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
	public boolean isValid(Map<String,Integer> pos){
		int row = pos.get("Row");
		int col = pos.get("Col");
		int n = worldMap.size();
		int m = (worldMap.get(0)).size();
		if(row < 0 || row >= n || col < 0 || col >= m){
			return false;
		}
		Cell targetCell = worldMap.get(row).get(col);
		if(!targetCell.isWalkable()){
			return false;
		}
		Land targetLand = (Land) targetCell;
		if(targetLand.isOccupied())return false;
		return true;
	}
}