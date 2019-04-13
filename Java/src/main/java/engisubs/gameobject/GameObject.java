package main.java.engisubs.gameobject;

/**
 * Enumerator untuk Tipe - Tipe GameObject
 */
enum ObjectType {
	PLAYER,
	MIXER,
	TRUCK,
	WELL,
	LAND,
	CHICKEN,
	PLATYPUS,
	PTERODACTYL,
	BISON,
	DOG,
	TREX,
	CHICKEN_EGG,
	PLATYPUS_EGG,
	PTERODACTYL_EGG,
	BISON_MEAT,
	CHICKEN_MEAT,
	DOG_MEAT,
	PLATYPUS_MEAT,
	TREX_MEAT,
	BISON_MILK,
	PLATYPUS_MILK,
	CHEESE,
	EKADO,
	MAYONAISE,
	STEAK
};

/**
 * Enumerator untuk Arah Gerak
 */
enum DirectionType{
	UP,
	DOWN,
	RIGHT,
	LEFT
};

/** 
 * Enumerator untuk tipe FarmProduct.
 */
enum FarmProductType {
    MEAT,
	EGG,
    MILK,
	NOT_FOUND
};

public class GameObject {
	/**
	 * Tipe dari suatu Objek, misalnya Product, TRex, etc
	 */
	
	protected ObjectType objectType;
	/**
	 * Simbol dari suatu Objek yang nantinya 
	 * akan ditampilkan di layar, misal C untuk Ayam
	 * Default = '?'
	 */
	public char objectSymbol;

	/**
	 * Constructor tanpa parameter, akan mengeset 
	 * nilai dari objectSymbol menjadi '?'
	 */
	public GameObject(){
		this.objectSymbol = '?';
	}

	/**
	 * Constructor dengan parameter, akan mengeset
	 * nilai dari objectSymbol sesuai dengan parameter 
	 * yang dimasukkan
	 * @param _objectSymbol
	 */
	public GameObject(char _objectSymbol){
		this.objectSymbol = _objectSymbol;
	}

	/**
	 * render() akan mengeluarkan objectSymbol ke layar
	 */
	public void render(){
		System.out.println(this.objectSymbol);
	}

	/**
	 * interact pada Kelas ini, berperan sebagai fungsi virtual
	 * nantinya akan di Override oleh kelas kelas anaknya.
	 * @param _p
	 */
	public void interact(Player _p){
		System.out.printerr("Must Be Override");
	}

	/**
	 * getter untuk ObjectType
	 * @return ObjectType
	 */
	public ObjectType getObjectType(){
		return this.objectType;
	}

	/**
	 * Menginisialisasi GameObject menyesuaikan parameter yang ada
	 * @param _objectType
	 * @param _objectSymbol
	 */
	public iniGameObject(ObjectType _objectType, char _objectSymbol){
		this.objectType = _objectType;
		this.objectSymbol = _objectSymbol;
	}
}