package engisubs.gameobject.cell.facility;

import java.util.*;

import engisubs.gameobject.*;

public class Truck extends Facility
  {
    private int notUsableTurns;
    public Truck(Map <String, Integer> _position){
      super(_position);
      notUsableTurns = 0;
      initGameObject(GameObjectType.TRUCK, 'T');
    }

    /**
     * Interact() berguna untuk berinteraksi dengan 'Truck'.
     * Berinteraksi dengan 'Truck' akan menjual semua barang
     * yang ada di Inventory player, dan menambah uang pemain
     * sejumlah harga barang - barang tersebut.
     * Setelah interact digunakan, Interact tidak akan bisa
     * digunakan untuk sementara waktu.
     */
    public void interact(Player _p){
      //LinkedList <Product *> inventTemp = _p->getInventory();
      for(int i = 0; i < _p.inventory.size(); i++){
        _p.setUang(_p.getUang() + _p.inventory.get(i).getPrice());
      }
      setNotUsableTurns(10);
      System.out.println("Isi Inventori Sekarang Kosong!");

      //Todo: Delete inventory
      _p.inventory.clear();;
    }

    //Setter
    /**
     * setNotUsableTurns akan mengubah nilai dari notUsableTurn menjadi
     * sebesar nut.
     */
    public void setNotUsableTurns(int nut){
      notUsableTurns = nut;
    }

    //Getter
    public int getNotUsableTurns(){
      return notUsableTurns;
    }
  }
