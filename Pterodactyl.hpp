#ifndef _PTERODACTYL_H_
#define _PTERODACTYL_H_

#include "EggProducing.hpp"
#include "PterodactylEgg.hpp"
#include "Player.hpp"
#include <string>

class Pterodactyl : public EggProducing {
    public:
        /*
        Constructor yang menerima parameter position, name, egg.
        Parameter diturunkan dari EggProducing
        */
        Pterodactyl(pair <int,int> position, string _name, Egg* _egg);

        /*
        Method untuk memproduksi egg. Method diturunkan dari
        EggProducing
        */
        void produceEgg(Player& _player);
};

#endif
