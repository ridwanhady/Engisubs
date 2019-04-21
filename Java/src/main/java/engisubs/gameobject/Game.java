package engisubs.gameobject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Objects;

import engisubs.gameobject.GameObject.GameObjectType;
import engisubs.gameobject.cell.Cell;
import engisubs.gameobject.cell.facility.*;
import engisubs.gameobject.cell.land.*;
import engisubs.gameobject.farmanimal.*;
import engisubs.gameobject.product.sideproduct.*;

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

	private String outplayer;

	Scanner sc = new Scanner(System.in);

	/**
	 * Mengecek apakah suatu koordinat valid atau tidak
	 * @param  row row koordinat yang ingin dicek
	 * @param  col col koordinat yang ingin dicek
	 * @return     boolean true jika valid
	 */
	private boolean isValid(Map<String, Integer> position, boolean isCoopWalkable, boolean isBarnWalkable, boolean isGrasslandWalkable){
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
		if(targetLand.getLandType() == Land.LandType.COOP && !isCoopWalkable)return false;
		else if(targetLand.getLandType() == Land.LandType.BARN && !isBarnWalkable) return false;
		else if(targetLand.getLandType() == Land.LandType.GRASSLAND && !isGrasslandWalkable) return false;
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
		System.out.println("Initiating...");
		String namaPemain;

		farmAnimalList = new ArrayList<FarmAnimal>();
		cellList = new LinkedList<LinkedList<Cell>>();
		daftarProduct = new ArrayList<GameObjectType>();
		//Meminta nama pemain
		System.out.println("Masukkan nama pemain");
		namaPemain = sc.nextLine();
		System.out.println(namaPemain);
		Random rand = new Random();
		if(Objects.equals(namaPemain, new String("random"))){
			//Init cell (
			for(int i = 0; i < n; i++){
				LinkedList<Cell> temp = new LinkedList<Cell> ();
				for(int j = 0; j < m; j++){
					Map<String,Integer> pos = new HashMap<String,Integer>();
					pos.put("Row", i);
					pos.put("Col", j);
					System.out.println("On " + pos.get("Row") + " " + pos.get("Col"));
					if(rand.nextInt(100) <= 90){
						int r = rand.nextInt(3);
						if (r == 0){
							temp.add(new Grassland(pos));
						}else if (r == 1){
							temp.add(new Barn(pos));
						}else {
							temp.add(new Coop(pos));
						}
					} else {
						int r = rand.nextInt(3);
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
		} else {
			BufferedReader br = null;
		    try {
		    	try {
		    		br = new BufferedReader(new FileReader("Map.txt"));	
		    	} catch (FileNotFoundException e){
		    		System.out.println("Tidak ada file tersebut");
		    	}
		    	String line = "";
		    	try {
		    		line = br.readLine();	
		    	} catch (IOException e){
		    		System.out.println(e.getMessage());
		    	}
			    
			    int i = 0;
			    while (line != null) {
			        LinkedList<Cell> temp = new LinkedList<Cell> ();
			        for(int j = 0; j < line.length(); j++){
			        	Map<String,Integer> pos = new HashMap<String,Integer>();
			        	pos.put("Row", i);
			        	pos.put("Col", j);
			        	char x = line.charAt(j);
		                if (x == '-'){
		                    // Adding Grassland
		                    temp.add(new Grassland(pos, false));
		                } else if (x == 'x'){
		                    // Adding Barn
		                    temp.add(new Barn(pos, false));
		                } else if (x == 'o'){
		                    // Adding Coop
		                    temp.add(new Coop(pos, false));
		                } else if (x == 'T') {
		                    //Adding Truck
		                    temp.add(new Truck(pos));
		                } else if (x == 'M') {
		                    //Adding Mixer
		                    temp.add(new Mixer(pos));
		                } else if (x == 'W') {
		                    //Adding Well
		                    temp.add(new Well(pos));
		                } else if (x == '#'){
		                	temp.add(new Grassland(pos, true));
		                } else if (x == '*'){
		                	temp.add(new Barn(pos, true));
		                } else if (x == '@'){
		                	temp.add(new Coop(pos, true));
		                }
			        }
			        m = line.length();
			        cellList.add(temp);
			        i++;
			    	try {
			    		line = br.readLine();	
			    	} catch (IOException e){
			    		System.out.println(e.getMessage());
			    	}
			    }
			    n = i;
			    System.out.println(n + " " + m);
		    } finally {
		    	try {
		    		br.close();
		    	} catch (IOException e){
		    		System.out.println(e.getMessage());
		    	}
		    	
		    }
		}
		//Melakukkan inisialisasi daftarProduct hanya saat belum pernah ada instance game

		//Menaruh player di posisi random
		Map<String,Integer> pos = new HashMap<String,Integer>();
		pos.put("Row", rand.nextInt(n));
		pos.put("Col", rand.nextInt(m));
		System.out.println(pos.get("Row") + " " + pos.get("Col"));
		while(!isValid(pos,true,true,true)){
			pos.put("Row", rand.nextInt(n));
			pos.put("Col", rand.nextInt(m));
		}
		int curRow = pos.get("Row");
		int curCol = pos.get("Col");
		mainPlayer = new Player(namaPemain, 10, 10, pos, cellList);
		((Land) (cellList.get(curRow).get(curCol))).setObjectHere(mainPlayer);

			//Init animal
			boolean isCoopWalkable[] = {EggProducing.class.isAssignableFrom(Chicken.class), EggProducing.class.isAssignableFrom(Bison.class), EggProducing.class.isAssignableFrom(Dog.class), EggProducing.class.isAssignableFrom(Platypus.class), EggProducing.class.isAssignableFrom(Pterodactyl.class), EggProducing.class.isAssignableFrom(TRex.class)};
			boolean isBarnWalkable[] = {MilkProducing.class.isAssignableFrom(Chicken.class), MilkProducing.class.isAssignableFrom(Bison.class), MilkProducing.class.isAssignableFrom(Dog.class), MilkProducing.class.isAssignableFrom(Platypus.class), MilkProducing.class.isAssignableFrom(Pterodactyl.class), MilkProducing.class.isAssignableFrom(TRex.class)};
			boolean isGrasslandWalkable[] = {MeatProducing.class.isAssignableFrom(Chicken.class), MeatProducing.class.isAssignableFrom(Bison.class), MeatProducing.class.isAssignableFrom(Dog.class), MeatProducing.class.isAssignableFrom(Platypus.class), MeatProducing.class.isAssignableFrom(Pterodactyl.class), MeatProducing.class.isAssignableFrom(TRex.class)};				

			int cntAnimal = 8;
			while(cntAnimal > 0){
				cntAnimal--;
				int randAnimal = rand.nextInt(6);
				Map<String,Integer> randPosition = new HashMap<String,Integer>();
				int randRow = rand.nextInt(n);
				int randCol = rand.nextInt(m);
				randPosition.put("Row", randRow);
				randPosition.put("Col", randCol);
				while(!isValid(randPosition,isCoopWalkable[randAnimal],isBarnWalkable[randAnimal],isGrasslandWalkable[randAnimal])){ //Todo: cek siapa yang walkable
					randRow = rand.nextInt(n);
					randCol = rand.nextInt(m);
					randPosition.replace("Row", randRow);
					randPosition.replace("Col", randCol);
				}
				if(randAnimal == 0){
					Chicken x = new Chicken(randPosition, "Chicken", (Land) (cellList.get(randRow).get(randCol)));
					farmAnimalList.add(x);
					((Land) (cellList.get(randRow).get(randCol))).setObjectHere(x);
				} else if(randAnimal == 1){
					Bison x = new Bison(randPosition, "Bison",(Land) (cellList.get(randRow).get(randCol)));
					farmAnimalList.add(x);
					((Land) (cellList.get(randRow).get(randCol))).setObjectHere(x);
				} else if(randAnimal == 2){
					Dog x = new Dog(randPosition, "Dog",(Land) (cellList.get(randRow).get(randCol)));
					farmAnimalList.add(x);
					((Land) (cellList.get(randRow).get(randCol))).setObjectHere(x);
				} else if(randAnimal == 3){
					Platypus x = new Platypus(randPosition, "Platypus",(Land) (cellList.get(randRow).get(randCol)));
					farmAnimalList.add(x);
					((Land) (cellList.get(randRow).get(randCol))).setObjectHere(x);
				} else if(randAnimal == 4){
					Pterodactyl x = new Pterodactyl(randPosition, "Pterodactyl",(Land) (cellList.get(randRow).get(randCol)));
					farmAnimalList.add(x);
					((Land) (cellList.get(randRow).get(randCol))).setObjectHere(x);
				} else {
					TRex x = new TRex(randPosition, "TRex",(Land) (cellList.get(randRow).get(randCol)));
					farmAnimalList.add(x);
					((Land) (cellList.get(randRow).get(randCol))).setObjectHere(x);
				
				}
			}
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
			System.out.println("Command Entered: " + command);
			System.out.println();
			System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
			if(command.equals("HELP") ){
				System.out.println();
				System.out.println("Command yang tersedia:");
				System.out.println("UP,  DOWN,  RIGHT,  LEFT,  TALK,  INTERACT,  KILL,  GROW");
				System.out.println("Command untuk mengubah arah hadap player (Tidak akan menambah waktu bermain):");
				System.out.println("LU,  LD,  LL,  LR,  QUIT,  SHOW,  STATUS");
			} else if(command.equals("UP")){
				try{
					mainPlayer.move(GameObject.DirectionType.UP);
					updateGame();				
				} catch (Exception e){
					System.out.println("Error: " + e.getMessage());
				}
			} else if(command.equals("DOWN")){
				try{
					mainPlayer.move(GameObject.DirectionType.DOWN);
					updateGame();				
				} catch (Exception e){
					System.out.println("Error: " + e.getMessage());
				}

			} else if(command.equals("RIGHT")){
				try{
					mainPlayer.move(GameObject.DirectionType.RIGHT);
					updateGame();				
				} catch (Exception e){
					System.out.println("Error: " + e.getMessage());
				}
			} else if(command.equals("LEFT")){
				try{
					mainPlayer.move(GameObject.DirectionType.LEFT);
					updateGame();				
				} catch (Exception e){
					System.out.println("Error: " + e.getMessage());
				}
			} else if(command.equals("TALK")){
				try{
					mainPlayer.talk();
					updateGame();				
				} catch (Exception e){
					System.out.println(e.getMessage());
				}
			} else if(command.equals("INTERACT")){
				try{
					mainPlayer.interact();
					updateGame();				
				} catch (Exception e){
					System.out.println(e.getMessage());
				}
			} else if(command.equals("KILL")){
				try{
					mainPlayer.kill(farmAnimalList);
					updateGame();				
				} catch (Exception e){
					System.out.println(e.getMessage());
				}
			} else if(command.equals("GROW")){
				try{
					mainPlayer.grow();
					updateGame();				
				} catch (Exception e){
					System.out.println(e.getMessage());
				}
			} else if(command.equals("LU")){
				mainPlayer.changeDirection(GameObject.DirectionType.UP);
			} else if(command.equals("LD")){
				mainPlayer.changeDirection(GameObject.DirectionType.DOWN);
			} else if(command.equals("LL")){
				mainPlayer.changeDirection(GameObject.DirectionType.LEFT);
			} else if(command.equals("LR")){
				mainPlayer.changeDirection(GameObject.DirectionType.RIGHT);
			} else if(command.equals("QUIT")){
				endGame();
			} else if(command.equals("SHOW")) {
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
			} else if (command.equals("STATUS")) {
				System.out.println("WAKTU: " + currentTime);
				System.out.println("WATER : " + mainPlayer.getWater());
				System.out.println("UANG : "  + mainPlayer.getUang());
				System.out.println("Berikut adalah isi dari Inventori:");
				for (int i = 0 ; i < mainPlayer.getInventory().size() ; i ++) {
					System.out.println(mainPlayer.getInventory().get(i).getProductName() + ",");
				}
				System.out.println();
			} else if (command.equals("SHOWRESEP")){
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
				idxDaftarProduct = Integer.parseInt(sc.nextLine());
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


	public void gameHandler(String command){
		if (isGameStarted && farmAnimalList.size() > 0){
			mainPlayer.lastConvo = "";
			if(command.equals("HELP") ){
				/* INVOKE THIS IN VIEW.
				System.out.println();
				System.out.println("Command yang tersedia:");
				System.out.println("UP,  DOWN,  RIGHT,  LEFT,  TALK,  INTERACT,  KILL,  GROW");
				System.out.println("Command untuk mengubah arah hadap player (Tidak akan menambah waktu bermain):");
				System.out.println("LU,  LD,  LL,  LR,  QUIT,  SHOW,  STATUS");
				*/
			} else if(command.equals("UP")){
				try{
					mainPlayer.move(GameObject.DirectionType.UP);
					updateGame();				
				} catch (Exception e){
					outplayer = ("Error: " + e.getMessage());
				}
			} else if(command.equals("DOWN")){
				try{
					mainPlayer.move(GameObject.DirectionType.DOWN);
					updateGame();				
				} catch (Exception e){
					outplayer = ("Error: " + e.getMessage());
				}

			} else if(command.equals("RIGHT")){
				try{
					mainPlayer.move(GameObject.DirectionType.RIGHT);
					updateGame();				
				} catch (Exception e){
					outplayer = ("Error: " + e.getMessage());
				}
			} else if(command.equals("LEFT")){
				try{
					mainPlayer.move(GameObject.DirectionType.LEFT);
					updateGame();				
				} catch (Exception e){
					outplayer = ("Error: " + e.getMessage());
				}
			} else if(command.equals("TALK")){
				try{
					mainPlayer.talk();
					updateGame();				
				} catch (Exception e){
					outplayer = (e.getMessage());
				}
			} else if(command.equals("INTERACT")){
				try{
					mainPlayer.interact();
					updateGame();				
				} catch (Exception e){
					outplayer = (e.getMessage());
				}
			} else if(command.equals("KILL")){
				try{
					mainPlayer.kill(farmAnimalList);
					updateGame();				
				} catch (Exception e){
					outplayer = (e.getMessage());
				}
			} else if(command.equals("GROW")){
				try{
					mainPlayer.grow();
					updateGame();				
				} catch (Exception e){
					outplayer = (e.getMessage());
				}
			} else if(command.equals("LU")){
				mainPlayer.changeDirection(GameObject.DirectionType.UP);
			} else if(command.equals("LD")){
				mainPlayer.changeDirection(GameObject.DirectionType.DOWN);
			} else if(command.equals("LL")){
				mainPlayer.changeDirection(GameObject.DirectionType.LEFT);
			} else if(command.equals("LR")){
				mainPlayer.changeDirection(GameObject.DirectionType.RIGHT);
			} else if(command.equals("QUIT")){
				endGame();
			} else if(command.equals("SHOW")) {
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
			} else if (command.equals("STATUS")) {
				System.out.println("WAKTU: " + currentTime);
				System.out.println("WATER : " + mainPlayer.getWater());
				System.out.println("UANG : "  + mainPlayer.getUang());
				System.out.println("Berikut adalah isi dari Inventori:");
				for (int i = 0 ; i < mainPlayer.getInventory().size() ; i ++) {
					System.out.println(mainPlayer.getInventory().get(i).getProductName() + ",");
				}
				System.out.println();
			} else if (command.equals("SHOWRESEP")){
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
				idxDaftarProduct = Integer.parseInt(sc.nextLine());
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
		int di[] = {-1,1,0,0,0};
		int dj[] = {0,0,1,-1,0};
		Random rand = new Random();
		System.out.println("Size list adalah " + farmAnimalList.size());
		for(int i = 0; i < farmAnimalList.size(); i++){
			if(farmAnimalList.get(i) == null){
				farmAnimalList.remove(farmAnimalList.get(i));
				i--;
				continue;
			}
			
			farmAnimalList.get(i).updateCondition();
			if(farmAnimalList.get(i).isHungry()){
				System.out.println("HEWAN ke - " + i + " LAPAR");
				farmAnimalList.get(i).eat();
				System.out.println("HEWAN ke - " + i + " MAKAN");
			}
			
			System.out.println("Hewan ke " + i  + " " + farmAnimalList.get(i).isHungry());
			
			if(farmAnimalList.get(i).getTimeUntilDead() == 0){
				farmAnimalList.remove(farmAnimalList.get(i));
				i--;
				continue;
			}
			//Melakukan randomisasi gerakan, jika muncul angka 4, maka hewan tidak akan bergerak
			int moveDirection;
			int curRow = farmAnimalList.get(i).getPosition().get("Row");
			int curCol = farmAnimalList.get(i).getPosition().get("Col");
			Map<String,Integer> tempPos = new HashMap<String,Integer>();
			
			do{
				moveDirection = rand.nextInt(5);
				tempPos.put("Row", curRow+di[moveDirection]);
				tempPos.put("Col", curCol+dj[moveDirection]);
				if(moveDirection < 4 && isValid(tempPos, farmAnimalList.get(i) instanceof EggProducing, farmAnimalList.get(i) instanceof MilkProducing, farmAnimalList.get(i) instanceof MeatProducing)){
					//Fungsi untuk gerak random
					farmAnimalList.get(i).move(dir[moveDirection], cellList);
					break;
				} else if(moveDirection == 4){
					System.out.println("HEWAN BERHENTI.");
					break;
				}
			} while (!isValid(tempPos, farmAnimalList.get(i) instanceof EggProducing, farmAnimalList.get(i) instanceof MilkProducing, farmAnimalList.get(i) instanceof MeatProducing));
			
		}

		
		//Mengupdate seluruh state Truck
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				Cell targetCell = cellList.get(i).get(j);
				if(targetCell.getGameObjectType() == GameObject.GameObjectType.TRUCK){
					Truck targetTruck = (Truck) targetCell;
					targetTruck.setNotUsableTurns(Integer.max(0,targetTruck.getNotUsableTurns() - 1));
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
				System.out.print(" ");
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

	public int getRowCount(){
		return n;
	}

	public int getColCount(){
		return m;
	}

	public Cell getCell(int i, int j){
		return cellList.get(i).get(j);
	}

	public Player getPlayer(){
		return mainPlayer;
	}
}
