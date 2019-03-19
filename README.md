# Engisubs
Mohon bersabar Bu / Pak, program ini sedang dikerjakan atau mungkin baru akan dikerjakan.
Engi's Kitchen by AWSUBS 

# Diagram

## Object
![class_object](https://user-images.githubusercontent.com/37581792/54508343-40963600-4978-11e9-9f58-b854045a9d64.png)

### Cell
![class_cell](https://user-images.githubusercontent.com/37581792/54508515-bf8b6e80-4978-11e9-9bd4-5d2590ae0b3c.png)

### Product
![class_product](https://user-images.githubusercontent.com/37581792/54508345-42f89000-4978-11e9-9e66-65cffefa3a71.png)

### Farm Animal
![class_farm_animal](https://user-images.githubusercontent.com/37581792/54508363-54da3300-4978-11e9-8c47-ab433c12ff00.png)

# To-do list
- Object **Done**
	- Cell **Done**
		- Land **Done**
			- Coop **Done**
			- Barn **Done**
			- Grassland **Done**
		- Facility **Done**
			- Well **Done**
			- Mixer **Done**
			- Truck **Done**
	- Farm Animal **File Created** (Nama, isFed, hasProduct)
		Jika tidak makan selama 5 tick, maka akan mati.   
		Setelah makan rumput, hewan dapat diambil produknya,
		kecuali hewan dengan produk daging, yang dapat disembelih
		tanpa makan terlebih dahulu.
		- Egg Producing **File Created**
		- Meat Producing **File Created**
		- Milk Producing **File Created**
	- Product (Harga)
		- Farm Product
			- Egg **File Created** 
			- Meat **File Created**
			- Milk **File Created**
		- Side Product
			- Mayonnaise (Telur, Telur) **File Created**
			- Steak (Daging, Daging) **File Created**
			- Ekado (Daging, telur) **File Created**
			- Keju (Susu, Susu) **File Created**
	- Player **Done**
- Linked List **Done**
- Game **Done**

Macam Farm animal
- Pterodactyl (Telur) **File Created**
- Platypus (Telur, daging, susu) **File Created**
- Chicken (Telur, daging) **File Created**
- Bison  (Daging, susu) **File Created**
- Dog (Daging) **File Created**
- T-rex (Daging) **File Created**

Macam Telur
- Pterodactyl Egg **File Created**
- Platypus Egg **File Created**
- Chicken Egg **File Created**

Macam Daging
- Chicken Meat **File Created**
- Platypus Meat **File Created**
- TRex Meat **File Created**
- Bison Meat **File Created**
- Dog Meat **File Created**

Macam Susu
- Platypus Milk **File Created**
- Bison Milk **File Created**

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
