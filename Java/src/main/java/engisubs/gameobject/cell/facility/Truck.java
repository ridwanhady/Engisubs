package engisubs.gameobject.cell.facility;

import java.util.*;

import engisubs.gameobject.*;

public class Truck extends Facility
  {
    private int notUsableTurns;
    /**
     * Constructor dari Truck
     * @param  _position Posisi dari Truck
     * @return           Instance dari Truck
     */
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
     * @param _p Reference dari player untuk melakukan penambahan inventory
     */
    public void interact(Player<?> _p){
      //LinkedList <Product *> inventTemp = _p->getInventory();
      if(notUsableTurns > 0){
        System.out.println("Supir truck terlihat lelah, berikan dia waktu " + notUsableTurns + " ticks lagi sebelum menjual inventorymu!");
      } else {
        for(int i = 0; i < _p.inventory.size(); i++){
          _p.setUang(_p.getUang() + _p.inventory.get(i).getPrice());
        }
        setNotUsableTurns(10);
        System.out.println("Isi Inventori Sekarang Kosong!");

        //Todo: Delete inventory
        _p.inventory.clear();;

      }
    }

    /**
     * Setter notUsableTurns
     * @param nut Nilai notUsableTurns yang baruu
     */
    public void setNotUsableTurns(int nut){
      notUsableTurns = nut;
    }

    /**
     * Getter getNotUsableTurns
     * @return notUsableTurns
     */
    public int getNotUsableTurns(){
      return notUsableTurns;
    }
  }
