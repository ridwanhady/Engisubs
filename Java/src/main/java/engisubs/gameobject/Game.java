import java.util.Random;
import java.util.Collection;

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
	private List<List<Cell>> cellList;
	/**
	 * Daftar product pada game
	 */
	private static List<ObjectType> daftarProduct;
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
		row = position.get("Row");
		col = position.get("Col");
		if(row < 0 || row >= n || col < 0 || col >= m){
			return false;
		}

		Cell targetCell = cellList.get(row).get(col);

		if (!targetCell.isWalkable()){
			return false;
		}
		Land targetLand = (targetCell);
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
	}

	/**
	 * Konstruktor game
	 * @return Objek Game
	 */
	public Game(){
		string namaPemain;

		farmAnimalList = new ArrayList<FarmAnimal>();
		cellList = new LinkedList<LinkedList<Cell>>();
		daftarProduct = new ArrayList<Product>();
		//Init cell (
		for(int i = 0; i < n; i++){
			List<Cell> temp = new LinkedList<Cell> ();
			for(int j = 0; j < m; j++){
				Map<String,Integer> pos = new HashMap<String,Integer>();
				pos.put("Row", i);
				pos.put("Col", j);
				if(rand.nextInteger()%100 <= 90){
					int r = rand.nextInteger()%3;
					if (r == 0){
						temp.add(new Grassland(pos,1));
					}else if (r == 1){
						temp.add(new Barn(pos,1));
					}else {
						temp.add(new Coop(pos,1));
					}
				} else {
					int r = rand.nextInteger()%3;
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
		while(cntAnimal--){
			Map<String,Integer> pos = new HashMap<String,Integer>();
			pos.put("Row", rand.nextInteger()%n);
			pos.put("Col", rand.nextint()%m);
			while(!isValid(pos)){
				pos.put("Row", rand.nextInteger()%n);
				pos.put("Col", rand.nextint()%m);
			}
			int randAnimal = rand.nextInteger()%6;
			if(randAnimal == 0){
				Chicken x = new Chicken(randPosition, "Chicken", (cellList.get(randPosition.first).get(randPosition.second)));
				farmAnimalList.add(x);
				((cellList.get(randPosition.first).get(randPosition.second))).setObjectHere(x);
			} else if(randAnimal == 1){
				Bison x = new Bison(randPosition, "Bison", (cellList.get(randPosition.first).get(randPosition.second)));
				farmAnimalList.add(x);
				((cellList.get(randPosition.first).get(randPosition.second))).setObjectHere(x);
			} else if(randAnimal == 2){
				Dog x = new Dog(randPosition, "Dog", (cellList.get(randPosition.first).get(randPosition.second)));
				farmAnimalList.add(x);
				((cellList.get(randPosition.first).get(randPosition.second))).setObjectHere(x);
			} else if(randAnimal == 3){
				Platypus x = new Platypus(randPosition, "Platypus", (cellList.get(randPosition.first).get(randPosition.second)));
				farmAnimalList.add(x);
				((cellList.get(randPosition.first).get(randPosition.second))).setObjectHere(x);
			} else if(randAnimal == 4){
				Pterodactyl x = new Pterodactyl(randPosition, "Pterodactyl", (cellList.get(randPosition.first).get(randPosition.second)));
				farmAnimalList.add(x);
				((cellList.get(randPosition.first).get(randPosition.second))).setObjectHere(x);
			} else {
				TRex x = new TRex(randPosition, "TRex", (cellList.get(randPosition.first).get(randPosition.second)));
				farmAnimalList.add(x);
				((cellList.get(randPosition.first).get(randPosition.second))).setObjectHere(x);
			
			}
		}

		//Meminta nama pemain
		System.out.println("Masukkan nama pemain");
		Scanner sc = new Scanner(System.in);
		namaPemain = sc.nextLine();

		//Menaruh player di posisi random
		Map<String,Integer> pos = new HashMap<String,Integer>();
		pos.put("Row", rand.nextInteger()%n);
		pos.put("Col", rand.nextint()%m);
		while(!isValid(pos)){
			pos.put("Row", rand.nextInteger()%n);
			pos.put("Col", rand.nextint()%m);
		}
		curRow = pos.get("Row");
		curCol = pos.get("Col");
		mainPlayer = new Player(namaPemain, 10, 10, pos, cellList);
		mainPlayer.addInventory(new PlatypusMilk(HARGA_SUSU_PLATYPUS, "Test"));
		mainPlayer.addInventory(new PlatypusEgg(HARGA_TELUR_PLATYPUS, "Test"));
		(cellList.get(curRow).get(curCol)).setObjectHere(mainPlayer);
		//Melakukkan inisialisasi daftarProduct hanya saat belum pernah ada instance game
		if(daftarProduct.size() == 0){
			daftarProduct.add(CHEESE);
			daftarProduct.add(EKADO);
			daftarProduct.add(MAYONAISE);
			daftarProduct.add(STEAK);
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
		string command;
		Scanner sc = new Scanner();
		while(isGameStarted && farmAnimalList.size() > 0){
			System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
			System.out.println("STATUS ");
			System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
			System.out.println("NAMA :" + mainPlayer.getName());
			System.out.println("WATER : " + mainPlayer.getWater());
			System.out.println("UANG : " + mainPlayer.getUang());
			System.out.println("Berikut adalah isi dari Inventori:");
			for (int i = 0 ; i < mainPlayer.getInventory().size() ; i ++) {
				System.out.println(  "[" + i + "] " + mainPlayer.getInventory().get(i).getName());
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
					mainPlayer.move(UP);
					updateGame();				
				} catch (logic_error e){
					System.out.println(e.what());
				}
			} else if(command == "DOWN"){
				try{
					mainPlayer.move(DOWN);
					updateGame();				
				} catch (logic_error e){
					System.out.println(e.what());
				}

			} else if(command == "RIGHT"){
				try{
					mainPlayer.move(RIGHT);
					updateGame();				
				} catch (logic_error e){
					System.out.println(e.what());
				}
			} else if(command == "LEFT"){
				try{
					mainPlayer.move(LEFT);
					updateGame();				
				} catch (logic_error e){
					System.out.println(e.what());
				}
			} else if(command == "TALK"){
				try{
					mainPlayer.talk();
					updateGame();				
				} catch (logic_error e){
					System.out.println(e.what());
				}
			} else if(command == "INTERACT"){
				try{
					mainPlayer.interact();
					updateGame();				
				} catch (logic_error e){
					System.out.println(e.what());
				}
			} else if(command == "KILL"){
				try{
					mainPlayer.kill(farmAnimalList);
					updateGame();				
				} catch (logic_error e){
					System.out.println(e.what());
				}
			} else if(command == "GROW"){
				try{
					mainPlayer.grow();
					updateGame();				
				} catch (logic_error e){
					System.out.println(e.what());
				}
			} else if(command == "LU"){
				mainPlayer.changeDirection(UP);
			} else if(command == "LD"){
				mainPlayer.changeDirection(DOWN);
			} else if(command == "LL"){
				mainPlayer.changeDirection(LEFT);
			} else if(command == "LR"){
				mainPlayer.changeDirection(RIGHT);
			} else if(command == "QUIT"){
				endGame();
			} else if(command == "SHOW") {
				System.out.println("Berikut adalah isi dari DaftarProduct");
				for (int i = 0 ; i < daftarProduct.size() ; i++) {
					if (daftarProduct.get(i) == 21)
						System.out.println("[" + i + "] " + "CHEESE");
					else if (daftarProduct.get(i) == 22)
						System.out.println("[" + i + "] " + "EKADO");
					else if (daftarProduct.get(i) == 23)
						System.out.println("[" + i + "] " + "MAYONAISE");
					else if (daftarProduct.get(i) == 24)
						System.out.println("[" + i + "] " + "STEAK");
				}
			} else if (command == "STATUS") {
				System.out.println("WATER : " + mainPlayer.getWater());
				System.out.println("UANG : "  + mainPlayer.getUang());
				System.out.println("Berikut adalah isi dari Inventori:");
				for (int i = 0 ; i < mainPlayer.getInventory().size() ; i ++) {
					System.out.println(mainPlayer.getInventory().get(i).getName() + ",");
				}
				System.out.println();
			} else if (command == "SHOWRESEP"){
				System.out.println("Berikut adalah isi dari DaftarProduct");
				for (int i = 0 ; i < daftarProduct.size() ; i++) {
					if (daftarProduct.get(i) == 21)
						System.out.println("CHEESE");
					else if (daftarProduct.get(i) == 22)
						System.out.println("EKADO");
					else if (daftarProduct.get(i) == 23)
						System.out.println("MAYONAISE");
					else if (daftarProduct.get(i) == 24)
						System.out.println("STEAK");
				}
				System.out.println("Pilih indeks dari Daftar Product!");
				int idxDaftarProduct;
				idxDaftarProduct = sc.nextInteger();
				System.out.println("Resep untuk membuat product adalah:");
				if (idxDaftarProduct >= 0 && idxDaftarProduct <= 3) {
					if (idxDaftarProduct == 0) {
						for (int i = 0 ; i < Cheese.getResep().size() ; i++) {
							System.out.println(ConvertIdxToString(Cheese.getResepwithIdx(i)));
						}
					} else if (idxDaftarProduct == 1) {
						for (int i = 0 ; i < Ekado.getResep().size() ; i++) {
							System.out.println(ConvertIdxToString(Ekado.getResepwithIdx(i)));
						}
					} else if (idxDaftarProduct == 2) {
						for (int i = 0 ; i < Mayonaise.getResep().size() ; i++) {
							System.out.println(ConvertIdxToString(Mayonaise.getResepwithIdx(i)));
						}
					} else if (idxDaftarProduct == 3) {
						for (int i = 0 ; i < Steak.getResep().size() ; i++) {
							System.out.println(ConvertIdxToString(Steak.getResepwithIdx(i)));
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
		DirectionType dir[] = {UP,DOWN,RIGHT,LEFT};
		int di[] = {-1,1,0,0};
		int dj[] = {0,0,1,-1};
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
				delete temp;
				i--;
				continue;
			}
			//Melakukan randomisasi gerakan, jika muncul angka 4, maka hewan tidak akan bergerak
			int moveDirection;
			Map<String,Integer> pos = new farmAnimalList.get(i).getPos();
			curRow = farmAnimalList.get(i).getRow();
			curCol = farmAnimalList.get(i).getCol();
			Map<String,Integer> tempPos = new HashMap<String,Integer>();
			do{
				moveDirection = rand.nextIntegereger()%5;
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
				if(targetCell.getObjectType() == TRUCK){
					Truck targetTruck = (targetCell);
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
	public static List<ObjectType> getProduct(){
		return Game.daftarProduct;
	}
}
