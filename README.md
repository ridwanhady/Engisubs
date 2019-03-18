# Engisubs
Mohon bersabar Bu / Pak, program ini sedang dikerjakan atau mungkin baru akan dikerjakan.
Engi's Kitchen by AWSUBS 

# Diagram
## Object
![Object Diagaram](https://user-images.githubusercontent.com/37581792/54507139-894af080-4972-11e9-8e9a-db9fe6841978.png)
### Land
![Land Diagram](https://user-images.githubusercontent.com/37581792/54507226-07a79280-4973-11e9-95ab-0c9af88477be.png)
### Farm Product
![Farm Product Diagram](https://user-images.githubusercontent.com/37581792/54507193-daf37b00-4972-11e9-9229-1679ffec351e.png)
### Side Product
![Side Product Diagram](https://user-images.githubusercontent.com/37581792/54507238-11c99100-4973-11e9-8bfa-c4751bb4683b.png)
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
	- Farm Animal **PERLU** (Nama, isFed, hasProduct)
		Jika tidak makan selama 5 tick, maka akan mati.   
		Setelah makan rumput, hewan dapat diambil produknya,
		kecuali hewan dengan produk daging, yang dapat disembelih
		tanpa makan terlebih dahulu.
		- Egg Producing
		- Meat Producing 
		- Milk Producing
	- Product (Harga)
		- Farm Product
			- Egg **File Created** 
			- Meat **File Created**
			- Milk **File Created**
		- Side Product
			- Mayonnaise (Telur, Telur)
			- Steak (Daging, Daging)
			- Ekado (Daging, telur)
			- Keju (Susu, Susu)
	- Player
- Linked List **Done**
- Game

Macam Farm animal
- Pterodactyl (Telur)
- Platypus (Telur, daging, susu)
- Chicken (Telur, daging)
- Bison  (Daging, susu)
- Dog (Daging)
- T-rex (Daging)

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
