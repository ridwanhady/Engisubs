#ifndef _CHICKEN_H_
#define _CHICKEN_H_

#include "Land.hpp"
#include "EggProducing.hpp"
#include "MeatProducing.hpp"
#include "ChickenEgg.hpp"
#include "ChickenMeat.hpp"
#include "Player.hpp"
#include <string>

#define HARGA_TELUR_AYAM 5
#define HARGA_DAGING_AYAM 20

class Chicken : public EggProducing, MeatProducing {
    public:
      /*
      Constructor yang menerima parameter position, name, egg, dan meat
      Parameter diturunkan dari EggProducing dan MeatProducing.
      */
      Chicken(pair<int,int> _position, string _name, Land* _landPos);

      /*
      Method untuk mengetahui apakah Chicken sudah mati
      karena dagingnya diproduksi. Method diturunkan dari
      MeatProducing
      */
      void produceMeat(Player& _player);

      /*
      Method untuk mengetahui apakah Chicken sudah
      memproduksi susu. Method diturunkan dari
      MilkProducing
      */
      void produceEgg(Player& _player);

      void eat();

      void talk();

      void interact(Player* _p);
};

#endif
