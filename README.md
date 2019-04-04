# Engisubs
# ArrayList\<Task\> TO-DO = new ArrayList\<Task\>();
- Object **TESTED**
	- Cell **TESTED**
		- Land **TESTED**
			- Coop **TESTED**
			- Barn **TESTED**
			- Grassland **TESTED**
		- Facility
			- Well 
			- Mixer
			- Truck
	- Farm Animal
		- Egg Producing
		- Meat Producing
		- Milk Producing
	- Product 
		- Farm Product
			- Egg  
			- Meat
			- Milk
		- Side Product
			- Mayonnaise (Telur, Telur) 
			- Steak (Daging, Daging) 
			- Ekado (Daging, telur) 
			- Keju (Susu, Susu) 
	- Player 
- Linked List 
- Game 
- Map

Macam Farm animal
- Pterodactyl (Telur) 
- Platypus (Telur, daging, susu) 
- Chicken (Telur, daging) 
- Bison  (Daging, susu) 
- Dog (Daging) 
- T-rex (Daging)

Macam Telur
- Pterodactyl Egg 
- Platypus Egg
- Chicken Egg

Macam Daging
- Chicken Meat
- Platypus Meat
- TRex Meat
- Bison Meat
- Dog Meat

Macam Susu
- Platypus Milk
- Bison Milk

Behaviour:
- Game
    - Selesai jika tidak ada hewan
    - Mengembalikan simbol yang benar untuk setiap instance di map
    - Mencatat waktu game
        - Melakukan update kepada setiap FarmAnimal setiap pergantian waktu
            - Menggerakkan seluruh FarmAnimal
            - Membunuh seluruh FarmAnimal yang sudah kelaparan selama 5 tick
- Player
    - Menampung Air
    - Menampung Product
    - Bergerak pada Cell yang diperbolehkan
        - Diperbolehkan: Land yang tidak terdapat FarmAnimal
    - Talk dengan FarmAnimal di sekeliling Player
        - Mengembalikan teks berupa suara yang dikeluarkan hewan
    - Interact dengan FarmAnimal di sekeliling Player
        - Berhasil jika terdapat EggProducingAnimal atau MilkProducingAnimal
        - Reject selain itu
    - Interact dengan Facility di sekeliling Player
        - Well untuk mengisi Air
        - Truck untuk menjual semua Product di Inventory, mengembalikan uang
        - Truck memiliki respawn time setelah diinteraksi
        - Mixer untuk membuat SideProduct
			- Mayonnaise (Telur, Telur)
			- Steak (Daging, Daging)
			- Ekado (Daging, telur)
			- Keju (Susu, Susu)
			- Reject selain itu
    - Kill Animal di sekeliling Player
        - Mendapatkan daging jika terdapat MeatProducingAnimal di sekeliling PLayer
        - Reject selain itu
    - Grow Land di petak Player berdiri
- FarmAnimal
    - Hanya bisa terdapat di Land
    - Hanya bisa terdapat 1 hewan di setiap Land
    - Dapat bergerak secara acak selama memenuhi kedua syarat di atas
    - Merasa lapar setelah waktu tertentu
        - Setelah 5 tick merasa lapar, hewan akan mati
        - Secara otomatis memakan rumput tempat dimana ia berdiri jika merasa lapar
            - Menghasilkan FarmProduct di dalam hewan tersebut, namun baru bisa diambil setelah hewan tersebut diinteract
            - Hanya bisa menyimpan 1 FarmProduct
            - Hanya berlaku untuk MilkProducingFarmAnimal dan EggProducingFarmAnimal
	    
## 1. Deskripsi Umum Tugas
Tugas ini adalah penerapan dari topik yang telah dibahas terkait konsep Pemrograman Berorientasi Objek.
## 2. Tujuan
1. Mahasiswa mampu merancang kelas dengan paradigma berorientasi objek, untuk menghasilkan rancangan kelas dan pengelompokan kelas yang sesuai dengan aturan serta dokumentasi rancangan dengan baik
2. Mahasiswa mampu mengantisipasi dan mengelola perubahan spesifikasi perangkat lunak
## 3. Deskripsi Persoalan
Sudah hampir setahun semenjak Chef membuka restoran Engi’s Kitchen. Chef telah lelah mengurus bisnis restorannya yang sudah berkembang pesat. Banyaknya peran yang harus ia ambil setelah ekspansi kurang lebih empat bulan lalu membuatnya lelah. Hari itu adalah hari yang cerah, Chef, sedang bebersih rumahnya. Saat membersihkan rumahnya, ia menemukan sebuah amplop berwarna putih bersih tanpa tulisan apapun di atasnya. Chef membuka amplop putih tersebut dan menemukan sepucuk surat yang ditulis oleh kakeknya yang telah meninggal sepuluh tahun lalu. Pada surat tersebut, tertulis bahwa kakeknya telah mewariskan padanya sebuah peternakan untuknya. Melihat kesempatan ini, Chef pun menutup restoran yang telah ia buka nyaris setahun. Chef tidak membuang waktu dan segera mencari peternakan warisan kakeknya untuk membuka Engi’s Farm. Petualangan Chef di Engi’s Farm pun dimulai. Pemain (Player) memiliki wadah air yang dapat menampung air dalam jumlah terbatas dan tas yang dapat menampung sejumlah terbatas Product. Pada Engi’s Farm, terdapat kumpulan petak tanah (Cell) yang direpresentasikan dengan sebuah matriks 2D dengan ukuran (X,Y). Setiap Cell dapat berupa Land, daerah untuk beternak hewan; atau Facility, yaitu fasilitas peternakan. Land digunakan untuk tempat hidup hewan. Land dapat dikategorikan sebagai Coop, Grassland, atau Barn. Coop digunakan untuk beternak hewan penghasil telur,Grassland digunakan untuk beternak hewan penghasil susu, Barn digunakan untuk beternak hewan penghasil daging.Facility dapat berupa Well, Mixer, atau Truck. Well digunakan untuk mengisi wadah air yang dimiliki Player; Mixer digunakan untuk membuat produk sampingan dari produk hewan; dan Truck digunakan untuk menjual barang hasil ternak. Hewan ternak (Farm Animal) dapat dikategorikan sebagai penghasil telur (Egg Producing Farm Animal, penghasil daging (Meat Producing Farm Animal), dan penghasil susu (Milk Producing Farm Animal). Hasil yang dapat dijual oleh peternakan (Product) dapat dikategorikan sebagai hasil ternak (Farm Product) dan hasil sampingan peternakan (Side Product).
# Diagram
## Object
![class_object](https://user-images.githubusercontent.com/37581792/54508343-40963600-4978-11e9-9f58-b854045a9d64.png)

### Cell
![class_cell](https://user-images.githubusercontent.com/37581792/54508515-bf8b6e80-4978-11e9-9bd4-5d2590ae0b3c.png)

### Product
![class_product](https://user-images.githubusercontent.com/37581792/54508345-42f89000-4978-11e9-9e66-65cffefa3a71.png)

### Farm Animal
![class_farm_animal](https://user-images.githubusercontent.com/37581792/54508363-54da3300-4978-11e9-8c47-ab433c12ff00.png)


