#ifndef _PTERODACTYL_H_
#define _PTERODACTYL_H_

#include "Land.hpp"
#include "EggProducing.hpp"
#include "PterodactylEgg.hpp"
#include "Player.hpp"
#include <string>

#define HARGA_TELUR_PTERODACTYL 8

class Pterodactyl : public EggProducing {
    public:
        /*
        Constructor yang menerima parameter position, name, egg.
        Parameter diturunkan dari EggProducing
        */
        Pterodactyl(pair <int,int> _position, string _name, Land* _landPos);

        /*
        Method untuk memproduksi egg. Method diturunkan dari
        EggProducing
        */
        void produceEgg(Player& _player);

        bool isKillable();

        void eat();

        void talk();

        void interact(Player* _p);
};

#endif
