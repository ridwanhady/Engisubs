#ifndef _DOG_H_
#define _DOG_H_

#include "DogMeat.hpp"
#include "MeatProducing.hpp"
#include <string>

class Dog : public MeatProducing {
    public:
      /*
      Constructor yang menerima parameter position, name, meat.
      Parameter diturunkan dari MeatProducing.
      */
      Dog(pair<int,int> _position, string _name, Meat _meat);

      /*
      Method untuk mengetahui apakah Dog sudah mati
      karena dagingnya diproduksi. Method diturunkan dari
      MeatProducing
      */
      void produceMeat(Player& _player);
};

#endif
