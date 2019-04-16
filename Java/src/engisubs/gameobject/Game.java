package engisubs.gameobject;

import engisubs.gameobject.*;
import engisubs.gameobject.GameObject.GameObjectType;
import engisubs.gameobject.cell.land.*;
import engisubs.gameobject.cell.Cell;
import engisubs.gameobject.farmanimal.*;
import engisubs.gameobject.product.farmproduct.egg.*;
import engisubs.gameobject.product.farmproduct.meat.*;
import engisubs.gameobject.product.farmproduct.milk.*;
import engisubs.gameobject.product.sideproduct.*;
import engisubs.gameobject.product.Product;
import engisubs.gameobject.cell.facility.*;


import java.util.*;

public class Game{
	/**
	 * Boolean yang mengecek apakah game sedang berjalan atau tidak
	 */
	private boolean isGameStarted = false;
	/**
	 * Time elapsed pada game
	 */
	private int currentTime = 0;
	/**
	 * Daftar hewan yang masih hidup pada game
	 */
	private List<FarmAnimal> farmAnimalList;
	/**
	 * Daftar cell pada game
	 */
	private List<LinkedList<Cell>> cellList;
	/**
	 * Daftar product pada game
	 */
	private static List<GameObject.GameObjectType> daftarProduct;
	/**
	 * Objek player pada game
	 */
	private Player mainPlayer;
	/**
	 * Banyak baris pada game
	 */
	private int n = 10;
	/**
	 * Banyak kolom pada game
	 */
	private int m = 10;
	/**
	 * Mengecek apakah suatu koordinat valid atau tidak
	 * @param  row row koordinat yang ingin dicek
	 * @param  col col koordinat yang ingin dicek
	 * @return     boolean true jika valid
	 */
	private boolean isValid(Map<String, Integer> position){
		int row = position.get("Row");
		int col = position.get("Col");
		if(row < 0 || row >= n || col < 0 || col >= m){
			return false;
		}

		Cell targetCell = cellList.get(row).get(col);

		if (!targetCell.isWalkable()){
			return false;
		}
		Land targetLand = (Land) targetCell;
		if(targetLand.isOccupied()) return false;
		return true;
	}
	/**
	 * Mengubah indeks resep menjadi string
	 * @param  idxResep Indek dari resep yang dipilih
	 * @return          Representasi String dari indeks tersebut
	 */
	private String ConvertIdxToString(int idxResep){
		if (idxResep == 0)
			return "MEAT";
		else if (idxResep == 1)
			return "EGG";
		else if (idxResep == 2)
			return "MILK";
		return "NOT FOUND";
	}

	/**
	 * Konstruktor game
	 * @return Objek Game
	 */
	public Game(){
		String namaPemain;

		farmAnimalList = new ArrayList<FarmAnimal>();
		cellList = new LinkedList<LinkedList<Cell>>();
		daftarProduct = new ArrayList<GameObjectType>();
		Random rand = new Random();
		//Init cell (
		for(int i = 0; i < n; i++){
			LinkedList<Cell> temp = new LinkedList<Cell> ();
			for(int j = 0; j < m; j++){
				Map<String,Integer> pos = new HashMap<String,Integer>();
				pos.put("Row", i);
				pos.put("Col", j);
				if(rand.nextInt()%100 <= 90){
					int r = rand.nextInt()%3;
					if (r == 0){
						temp.add(new Grassland(pos));
					}else if (r == 1){
						temp.add(new Barn(pos));
					}else {
						temp.add(new Coop(pos));
					}
				} else {
					int r = rand.nextInt()%3;
					if (r == 0){
						temp.add(new Truck(pos));
					}else if (r == 1){
						temp.add(new Mixer(pos));
					}else {
						temp.add(new Well(pos));
					}
				}
			}
			
			cellList.add(temp);
		}
		//Init animal
		
		int cntAnimal = 8;
		while(cntAnimal > 0){
			cntAnimal--;
			Map<String,Integer> randPosition = new HashMap<String,Integer>();
			int randRow = rand.nextInt()%n;
			int randCol = rand.nextInt()%m;
			while(!isValid(randPosition)){
				randRow = rand.nextInt()%n;
				randCol = rand.nextInt()%m;
			}
			randPosition.put("Row", randRow);
			randPosition.put("Col", randCol);
			int randAnimal = rand.nextInt()%6;
			if(randAnimal == 0){
				Chicken x = new Chicken(randPosition, "Chicken", (cellList.get(randRow).get(randCol)));
				farmAnimalList.add(x);
				((cellList.get(randRow).get(randCol))).setObjectHere(x);
			} else if(randAnimal == 1){
				Bison x = new Bison(randPosition, "Bison", (cellList.get(randRow).get(randCol)));
				farmAnimalList.add(x);
				((cellList.get(randRow).get(randCol))).setObjectHere(x);
			} else if(randAnimal == 2){
				Dog x = new Dog(randPosition, "Dog", (cellList.get(randRow).get(randCol)));
				farmAnimalList.add(x);
				((cellList.get(randRow).get(randCol))).setObjectHere(x);
			} else if(randAnimal == 3){
				Platypus x = new Platypus(randPosition, "Platypus", (cellList.get(randRow).get(randCol)));
				farmAnimalList.add(x);
				((cellList.get(randRow).get(randCol))).setObjectHere(x);
			} else if(randAnimal == 4){
				Pterodactyl x = new Pterodactyl(randPosition, "Pterodactyl", (cellList.get(randRow).get(randCol)));
				farmAnimalList.add(x);
				((cellList.get(randRow).get(randCol))).setObjectHere(x);
			} else {
				TRex x = new TRex(randPosition, "TRex", (cellList.get(randRow).get(randCol)));
				farmAnimalList.add(x);
				((cellList.get(randRow).get(randCol))).setObjectHere(x);
			
			}
		}

		//Meminta nama pemain
		System.out.println("Masukkan nama pemain");
		Scanner sc = new Scanner(System.in);
		namaPemain = sc.nextLine();

		//Menaruh player di posisi random
		Map<String,Integer> pos = new HashMap<String,Integer>();
		pos.put("Row", rand.nextInt()%n);
		pos.put("Col", rand.nextInt()%m);
		while(!isValid(pos)){
			pos.put("Row", rand.nextInt()%n);
			pos.put("Col", rand.nextInt()%m);
		}
		int curRow = pos.get("Row");
		int curCol = pos.get("Col");
		mainPlayer = new Player(namaPemain, 10, 10, pos, cellList);
		((Land) (cellList.get(curRow).get(curCol))).setObjectHere(mainPlayer);
		//Melakukkan inisialisasi daftarProduct hanya saat belum pernah ada instance game
		if(daftarProduct.size() == 0){
			daftarProduct.add(GameObject.GameObjectType.CHEESE);
			daftarProduct.add(GameObject.GameObjectType.EKADO);
			daftarProduct.add(GameObject.GameObjectType.MAYONAISE);
			daftarProduct.add(GameObject.GameObjectType.STEAK);
			Cheese.InitResep();
			Ekado.InitResep();
			Mayonaise.InitResep();
			Steak.InitResep();
		}
	}

	/**
	 * Memulai game
	 */
	public void startGame(){
		isGameStarted = true;
	}

	/**
	 * Game loop, meminta command dari player dan memanggil updateGame.
	 * Pada fungsi ini game berjalan.
	 */
	public void gameLoop(){
		String command;
		Scanner sc = new Scanner(System.in);
		while(isGameStarted && farmAnimalList.size() > 0){
			System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
			System.out.println("STATUS ");
			System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
			System.out.println("NAMA :" + mainPlayer.getName());
			System.out.println("WATER : " + mainPlayer.getWater());
			System.out.println("UANG : " + mainPlayer.getUang());
			System.out.println("Berikut adalah isi dari Inventori:");
			for (int i = 0 ; i < mainPlayer.getInventory().size() ; i ++) {
				System.out.println(  "[" + i + "] " + mainPlayer.getInventory().get(i).getProductName());
			}
			System.out.println();

			System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
			showMap();
			System.out.println( "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
			System.out.println("Input: ");
			command = sc.nextLine();
			System.out.println();
			System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
			if(command == "HELP"){
				System.out.println();
				System.out.println("Command yang tersedia:");
				System.out.println("UP,  DOWN,  RIGHT,  LEFT,  TALK,  INTERACT,  KILL,  GROW");
				System.out.println("Command untuk mengubah arah hadap player (Tidak akan menambah waktu bermain):");
				System.out.println("LU,  LD,  LL,  LR,  QUIT,  SHOW,  STATUS");
			} else if(command == "UP"){
				try{
					mainPlayer.move(GameObject.DirectionType.UP);
					updateGame();				
				} catch (Exception e){
					System.out.println(e.getMessage());
				}
			} else if(command == "DOWN"){
				try{
					mainPlayer.move(GameObject.DirectionType.DOWN);
					updateGame();				
				} catch (Exception e){
					System.out.println(e.getMessage());
				}

			} else if(command == "RIGHT"){
				try{
					mainPlayer.move(GameObject.DirectionType.RIGHT);
					updateGame();				
				} catch (Exception e){
					System.out.println(e.getMessage());
				}
			} else if(command == "LEFT"){
				try{
					mainPlayer.move(GameObject.DirectionType.LEFT);
					updateGame();				
				} catch (Exception e){
					System.out.println(e.getMessage());
				}
			} else if(command == "TALK"){
				try{
					mainPlayer.talk();
					updateGame();				
				} catch (Exception e){
					System.out.println(e.getMessage());
				}
			} else if(command == "INTERACT"){
				try{
					mainPlayer.interact();
					updateGame();				
				} catch (Exception e){
					System.out.println(e.getMessage());
				}
			} else if(command == "KILL"){
				try{
					mainPlayer.kill(farmAnimalList);
					updateGame();				
				} catch (Exception e){
					System.out.println(e.getMessage());
				}
			} else if(command == "GROW"){
				try{
					mainPlayer.grow();
					updateGame();				
				} catch (Exception e){
					System.out.println(e.getMessage());
				}
			} else if(command == "LU"){
				mainPlayer.changeDirection(GameObject.DirectionType.UP);
			} else if(command == "LD"){
				mainPlayer.changeDirection(GameObject.DirectionType.DOWN);
			} else if(command == "LL"){
				mainPlayer.changeDirection(GameObject.DirectionType.LEFT);
			} else if(command == "LR"){
				mainPlayer.changeDirection(GameObject.DirectionType.RIGHT);
			} else if(command == "QUIT"){
				endGame();
			} else if(command == "SHOW") {
				System.out.println("Berikut adalah isi dari DaftarProduct");
				for (int i = 0 ; i < daftarProduct.size() ; i++) {
					if (daftarProduct.get(i) == GameObject.GameObjectType.CHEESE)
						System.out.println("[" + i + "] " + "CHEESE");
					else if (daftarProduct.get(i) == GameObject.GameObjectType.EKADO)
						System.out.println("[" + i + "] " + "EKADO");
					else if (daftarProduct.get(i) == GameObject.GameObjectType.MAYONAISE)
						System.out.println("[" + i + "] " + "MAYONAISE");
					else if (daftarProduct.get(i) == GameObject.GameObjectType.STEAK)
						System.out.println("[" + i + "] " + "STEAK");
				}
			} else if (command == "STATUS") {
				System.out.println("WATER : " + mainPlayer.getWater());
				System.out.println("UANG : "  + mainPlayer.getUang());
				System.out.println("Berikut adalah isi dari Inventori:");
				for (int i = 0 ; i < mainPlayer.getInventory().size() ; i ++) {
					System.out.println(mainPlayer.getInventory().get(i).getProductName() + ",");
				}
				System.out.println();
			} else if (command == "SHOWRESEP"){
				System.out.println("Berikut adalah isi dari DaftarProduct");
				for (int i = 0 ; i < daftarProduct.size() ; i++) {
					if (daftarProduct.get(i) == GameObject.GameObjectType.CHEESE)
						System.out.println("CHEESE");
					else if (daftarProduct.get(i) == GameObject.GameObjectType.EKADO)
						System.out.println("EKADO");
					else if (daftarProduct.get(i) == GameObject.GameObjectType.MAYONAISE)
						System.out.println("MAYONAISE");
					else if (daftarProduct.get(i) == GameObject.GameObjectType.STEAK)
						System.out.println("STEAK");
				}
				System.out.println("Pilih indeks dari Daftar Product!");
				int idxDaftarProduct;
				idxDaftarProduct = sc.nextInt();
				System.out.println("Resep untuk membuat product adalah:");
				if (idxDaftarProduct >= 0 && idxDaftarProduct <= 3) {
					if (idxDaftarProduct == 0) {
						for (int i = 0 ; i < Cheese.getResep().size() ; i++) {
							System.out.println(ConvertIdxToString(Cheese.getResepwithIdx(i).getValue()));
						}
					} else if (idxDaftarProduct == 1) {
						for (int i = 0 ; i < Ekado.getResep().size() ; i++) {
							System.out.println(ConvertIdxToString(Ekado.getResepwithIdx(i).getValue()));
						}
					} else if (idxDaftarProduct == 2) {
						for (int i = 0 ; i < Mayonaise.getResep().size() ; i++) {
							System.out.println(ConvertIdxToString(Mayonaise.getResepwithIdx(i).getValue()));
						}
					} else if (idxDaftarProduct == 3) {
						for (int i = 0 ; i < Steak.getResep().size() ; i++) {
							System.out.println(ConvertIdxToString(Steak.getResepwithIdx(i).getValue()));
						}
					}
				} else {
					System.out.println("Indeks tidak valid");
				}

			} else {
				System.out.println("Command tidak valid");
			}
		}
		if(farmAnimalList.size() == 0){
			System.out.println("Sudah tidak ada hewan lagi di game");
		}
		sc.close();
	}

	/**
	 * Mengupdate seluruh state game
	 */
	public void updateGame(){
		//Mengupdate seluruh state animal
		//Urutan pengerjaan:
		//1. Makan
		//2. Update hungryBar
		//3. Pindah ke cell lain
		GameObject.DirectionType dir[] = {GameObject.DirectionType.UP,GameObject.DirectionType.DOWN,GameObject.DirectionType.RIGHT,GameObject.DirectionType.LEFT};
		int di[] = {-1,1,0,0};
		int dj[] = {0,0,1,-1};
		Random rand = new Random();
		for(int i = 0; i < farmAnimalList.size(); i++){
			if(farmAnimalList.get(i) == null){
				farmAnimalList.remove(farmAnimalList.get(i));
				i--;
				continue;
			}
			if(farmAnimalList.get(i).isHungry()){
				farmAnimalList.get(i).eat();
			}
			farmAnimalList.get(i).updateCondition();
			if(farmAnimalList.get(i).getTimeUntilDead() == 0){
				FarmAnimal temp = farmAnimalList.get(i);
				farmAnimalList.remove(farmAnimalList.get(i));
				i--;
				continue;
			}
			//Melakukan randomisasi gerakan, jika muncul angka 4, maka hewan tidak akan bergerak
			int moveDirection;
			Map<String,Integer> pos = new HashMap<String,Integer>();
			pos = farmAnimalList.get(i).getPosition();
			int curRow = pos.get("Row");
			int curCol = pos.get("Col");
			Map<String,Integer> tempPos = new HashMap<String,Integer>();
			do{
				moveDirection = rand.nextInt()%5;
				tempPos.put("Row", curRow+di[moveDirection]);
				tempPos.put("Col", curCol+dj[moveDirection]);
				if(moveDirection < 4 && isValid(tempPos)){
					//Fungsi untuk gerak random
					farmAnimalList.get(i).move(dir[moveDirection], cellList);
					break;
				} else if(moveDirection == 4){
					break;
				}
			} while (!isValid(tempPos));

		}
		//Mengupdate seluruh state Truck
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				Cell targetCell = cellList.get(i).get(j);
				if(targetCell.getGameObjectType() == GameObject.GameObjectType.TRUCK){
					Truck targetTruck = (Truck) targetCell;
					targetTruck.setNotUsableTurns(max(0,targetTruck.getNotUsableTurns()-1));
				}
			}
		}
		currentTime++;
	}

	/**
	 * Menyelesaikan game
	 */
	public void endGame(){
		isGameStarted = false;
	}

	/**
	 * Menampilkan map
	 */
	public void showMap(){
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				cellList.get(i).get(j).render();
				System.out.println(" ");
			}
			System.out.println();
		}
	}
		
	/**
	 * Mengecek product yang bisa dibuat
	 * @return daftarProduct
	 */
	public static List<GameObject.GameObjectType> getProduct(){
		return Game.daftarProduct;
	}
}
