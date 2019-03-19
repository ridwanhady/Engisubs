#ifndef _CHICKEN_H_
#define _CHICKEN_H_

#include "EggProducing.hpp"
#include "MeatProducing.hpp"
#include "ChickenEgg.hpp"
#include "ChickenMeat.hpp"
#include <string>

class Chicken : public EggProducing, MeatProducing {
    public:
      /*
      Constructor yang menerima parameter position, name, egg, dan meat
      Parameter diturunkan dari EggProducing dan MeatProducing.
      */
      Chicken(pair<int,int> _position, string _name, Egg _egg, Meat _meat);

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
     void produceMilk(Player& _player) = 0;
};

#endif
