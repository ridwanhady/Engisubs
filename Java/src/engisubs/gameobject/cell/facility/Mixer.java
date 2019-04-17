package engisubs.gameobject.cell.facility;

import java.util.*;
import engisubs.gameobject.*;
import engisubs.gameobject.product.Product.ProductType;
import engisubs.gameobject.product.farmproduct.*;
import engisubs.gameobject.product.sideproduct.*;

public class Mixer extends Facility
  {
    public Mixer(Map <String, Integer> _position){
      super(_position);
      initGameObject(GameObjectType.MIXER, 'M');
    }

    //Implementasi virtual interact()
    public void interact(Player _p){
      //minta input
      int idxInventory_1, idxInventory_2, idxSideProd, idxResep;
      boolean isIdx1Valid, isIdx2Valid, isIdxSideProdValid, isFarmProduct;
      FarmProductType idx1_farmProductType = FarmProductType.NOT_FOUND;
      boolean isFoundIdx1 = false;
      boolean isFoundIdx2 = false;

      //Panggil static dari Game dilakukan
      List<GameObjectType> daftarSideProduct = Game.getProduct();

      Scanner inputScanner = new Scanner(System.in);

      System.out.println("Masukkan indeks inventori (dari 0 - size)");
      idxInventory_1 = inputScanner.nextInt();
      System.out.println("Masukkan indeks inventori kedua (dari 0 - size)");
      idxInventory_2 = inputScanner.nextInt();
      
      //Cek apakah indeks pertama dan kedua valid;
      isIdx1Valid = (idxInventory_1 >= 0  && idxInventory_1 < (_p).getInventory().size());
      isIdx2Valid = (idxInventory_2 >= 0  && idxInventory_2 < (_p).getInventory().size());

      if (isIdx1Valid && isIdx2Valid && idxInventory_1 != idxInventory_2){
        //Jika valid, dapatkan ProductType, ObjectType, serta Price.
        //Perhatikan bahwa (_p).getInventory().get(idxInventory_1) merupakan tipe data Product*

        //Cek ProductType: Mixer akan berhasil kalau kedua indeks mengembalikan FARMPRODUCT
        isFarmProduct = ( ((_p).getInventory().get(idxInventory_1)).getProductType() == ProductType.FARMPRODUCT) && ( ((_p).getInventory().get(idxInventory_2)).getProductType() == ProductType.FARMPRODUCT) ;
        if (isFarmProduct) {
          //Jika SideProduct yang dipilih benar (CHEESE, EKADO, STEAK, dan MAYONAISE )
          System.out.println("Silakan masukkan indeks SideProduct yang anda mau!");
          idxSideProd = inputScanner.nextInt();
          isIdxSideProdValid = (idxSideProd >= 0 && idxSideProd < daftarSideProduct.size());

          //Cek apakah indeks untuk linkedList Resep valid atau tidak.
          if (isIdxSideProdValid) {
            if (daftarSideProduct.get(idxSideProd) == GameObjectType.CHEESE){
              //Cari resep yang digunakan untuk membuat cheese
              for (idxResep = 0 ; idxResep < Cheese.getResep().size() ; idxResep++) {
                //Kalau inventory yang dipilih pemain cocok dengan resep CHEESE
                if (FarmProduct.getFarmProductType( ((_p).getInventory().get(idxInventory_1)).getObjectType()) == Cheese.getResepwithIdx(idxResep)) {
                  //Simpam FarmProductType pada idx1_farmProductType, sebagai validasi idxInventory_2
                  idx1_farmProductType = Cheese.getResepwithIdx(idxResep);
                  isFoundIdx1 = true;
                  break;
                }
              }

              for (idxResep = 0 ; idxResep < Cheese.getResep().size() ; idxResep++) {
                //Kalau inventory yang dipilih pemain cocok dengan resep CHEESE
                if (FarmProduct.getFarmProductType( ((_p).getInventory().get(idxInventory_2)).getObjectType()) == Cheese.getResepwithIdx(idxResep)) {
                  //Kalau tipenya berbeda (contoh : EGG dan MILK, bukan EGG dan EGG maupun MILK dan MILK )
                  if (idx1_farmProductType != Cheese.getResepwithIdx(idxResep)) {
                    isFoundIdx2 = true;
                    break;
                  }
                }
              }

              if (isFoundIdx1 && isFoundIdx2) {
                //Kalau dua duanya valid, HAPUS DUA BARANG TERSEBUT PADA INVENTORI.
                if(idxInventory_1 > idxInventory_2){
                  _p.inventory.remove( _p.inventory.get(idxInventory_1));
                  _p.inventory.remove( _p.inventory.get(idxInventory_2));
                } else {
                  _p.inventory.remove( _p.inventory.get(idxInventory_2));
                  _p.inventory.remove( _p.inventory.get(idxInventory_1));                  
                }

                //Tambahkan Cheese pada Inventori:
                //Construct newCheese
                _p.inventory.add(new Cheese(50));

                System.out.println("MEMBUAT CHEESE BERHASIL! Dua Barang dihilangkan dari inventori Anda!");
              } else {
                System.out.println("Gagal membuat product karena dua tipe sama atau tidak sesuai tipe");
              }
            } else if (daftarSideProduct.get(idxSideProd) == GameObjectType.STEAK){
              //Cari resep yang digunakan untuk membuat STEAK
              for (idxResep = 0 ; idxResep < Steak.getResep().size() ; idxResep++) {
                //Kalau inventory yang dipilih pemain cocok dengan resep STEAK
                if (FarmProduct.getFarmProductType( ((_p).getInventory().get(idxInventory_1)).getObjectType()) == Steak.getResepwithIdx(idxResep)) {
                  //Simpam FarmProductType pada idx1_farmProductType, sebagai validasi idxInventory_2
                  idx1_farmProductType = Steak.getResepwithIdx(idxResep);
                  isFoundIdx1 = true;
                  break;
                }
              }

              for (idxResep = 0 ; idxResep < Steak.getResep().size() ; idxResep++) {
                //Kalau inventory yang dipilih pemain cocok dengan resep STEAK
                if (FarmProduct.getFarmProductType( ((_p).getInventory().get(idxInventory_2)).getObjectType()) == Steak.getResepwithIdx(idxResep)) {
                  //Kalau tipenya berbeda (contoh : EGG dan MILK, bukan EGG dan EGG maupun MILK dan MILK )
                  if (idx1_farmProductType != Steak.getResepwithIdx(idxResep)) {
                    isFoundIdx2 = true;
                    break;
                  }
                }
              }

              if (isFoundIdx1 && isFoundIdx2) {
                //Kalau dua duanya valid, HAPUS DUA BARANG TERSEBUT PADA INVENTORI.
                if(idxInventory_1 > idxInventory_2){
                  _p.inventory.remove( _p.inventory.get(idxInventory_1));
                  _p.inventory.remove( _p.inventory.get(idxInventory_2));
                } else {
                  _p.inventory.remove( _p.inventory.get(idxInventory_2));
                  _p.inventory.remove( _p.inventory.get(idxInventory_1));                  
                }

                //Tambahkan Steak pada Inventori:
                //Construct newSteak
                _p.inventory.add(new Steak(500));

                System.out.println("MEMBUAT STEAK BERHASIL! Dua Barang dihilangkan dari inventori Anda!");
              } else {
                System.out.println("Gagal membuat product karena dua tipe sama atau tidak sesuai tipe");
              }
            } else if (daftarSideProduct.get(idxSideProd) == GameObjectType.EKADO){
              //Cari resep yang digunakan untuk membuat EKADO
              for (idxResep = 0 ; idxResep < Ekado.getResep().size() ; idxResep++) {
                //Kalau inventory yang dipilih pemain cocok dengan resep EKADO
                if (FarmProduct.getFarmProductType( ((_p).getInventory().get(idxInventory_1)).getObjectType()) == Ekado.getResepwithIdx(idxResep)) {
                  //Simpam FarmProductType pada idx1_farmProductType, sebagai validasi idxInventory_2
                  idx1_farmProductType = Ekado.getResepwithIdx(idxResep);
                  isFoundIdx1 = true;
                  break;
                }
              }

              for (idxResep = 0 ; idxResep < Ekado.getResep().size() ; idxResep++) {
                //Kalau inventory yang dipilih pemain cocok dengan resep Ekado
                if (FarmProduct.getFarmProductType( ((_p).getInventory().get(idxInventory_2)).getObjectType()) == Ekado.getResepwithIdx(idxResep)) {
                  //Kalau tipenya berbeda (contoh : EGG dan MILK, bukan EGG dan EGG maupun MILK dan MILK )
                  if (idx1_farmProductType != Ekado.getResepwithIdx(idxResep)) {
                    isFoundIdx2 = true;
                    break;
                  }
                }
              }
              if (isFoundIdx1 && isFoundIdx2) {
                //Kalau dua duanya valid, HAPUS DUA BARANG TERSEBUT PADA INVENTORI.
                if(idxInventory_1 > idxInventory_2){
                  _p.inventory.remove( _p.inventory.get(idxInventory_1));
                  _p.inventory.remove( _p.inventory.get(idxInventory_2));
                } else {
                  _p.inventory.remove( _p.inventory.get(idxInventory_2));
                  _p.inventory.remove( _p.inventory.get(idxInventory_1));                  
                }
                //Tambahkan Ekado pada Inventori:
                //Construct newEkado
                _p.inventory.add(new Ekado(300));

                System.out.println("MEMBUAT EKADO BERHASIL! Dua Barang dihilangkan dari inventori Anda!");
              } else {
                System.out.println("Gagal membuat product karena dua tipe sama atau tidak sesuai tipe");
              }
            } else if (daftarSideProduct.get(idxSideProd) == GameObjectType.MAYONAISE){
              //Cari resep yang digunakan untuk membuat Mayonaise
              for (idxResep = 0 ; idxResep < Mayonaise.getResep().size() ; idxResep++) {
                //Kalau inventory yang dipilih pemain cocok dengan resep MAYONAISE
                if (FarmProduct.getFarmProductType( ((_p).getInventory().get(idxInventory_1)).getObjectType()) == Mayonaise.getResepwithIdx(idxResep)) {
                  //Simpam FarmProductType pada idx1_farmProductType, sebagai validasi idxInventory_2
                  idx1_farmProductType = Mayonaise.getResepwithIdx(idxResep);
                  isFoundIdx1 = true;
                  break;
                }
              }

              for (idxResep = 0 ; idxResep < Mayonaise.getResep().size() ; idxResep++) {
                //Kalau inventory yang dipilih pemain cocok dengan resep Mayonaise
                if (FarmProduct.getFarmProductType( ((_p).getInventory().get(idxInventory_2)).getObjectType()) == Mayonaise.getResepwithIdx(idxResep)) {
                  //Kalau tipenya berbeda (contoh : EGG dan MILK, bukan EGG dan EGG maupun MILK dan MILK )
                  if (idx1_farmProductType != Mayonaise.getResepwithIdx(idxResep)) {
                    isFoundIdx2 = true;
                    break;
                  }
                }
              }

              if (isFoundIdx1 && isFoundIdx2) {
                //Kalau dua duanya valid, HAPUS DUA BARANG TERSEBUT PADA INVENTORI.
                if(idxInventory_1 > idxInventory_2){
                  _p.inventory.remove( _p.inventory.get(idxInventory_1));
                  _p.inventory.remove( _p.inventory.get(idxInventory_2));
                } else {
                  _p.inventory.remove( _p.inventory.get(idxInventory_2));
                  _p.inventory.remove( _p.inventory.get(idxInventory_1));                  
                }

                //Tambahkan Mayonaise pada Inventori:
                //Construct newMayonaise
                _p.inventory.add(new Mayonaise(400));

                System.out.println("MEMBUAT MAYONAISE BERHASIL! Dua Barang dihilangkan dari inventori Anda!");
              } else {
                System.out.println("Gagal membuat product karena dua tipe sama atau tidak sesuai tipe");
              }
            } 

          } else {
            System.out.println("Indeks yang Anda masukkan tidak valid atau sama.");
          }

        } else {
          System.out.println("Product yang dibuat haruslah product langsung dari HEWAN!");
        }
        
      } else {
        System.out.println("Indeks yang Anda masukkan tidak valid.");
      }
      inputScanner.close();
    }
}
