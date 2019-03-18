#ifndef _PTERODACTYL_H_
#define _PTERODACTYL_H_

#include "EggProducing.hpp"
#include "PterodactylEgg.hpp"
#include <string>

class Pterodactyl : public EggProducing {
    public:
        // ctor dengan parameter
        // Jangan lupa tambah Egg yang diproduksi di initialization list.
        Pterodactyl(const string _name);
};

#endif
