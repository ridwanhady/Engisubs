#ifndef _PTERODACTYL_H_
#define _PTERODACTYL_H_

#include "FarmAnimal.hpp"
#include "PterodactylEgg.hpp"
#include <string>

class Pterodactyl : public FarmAnimal {
    public:
        // ctor
        // Jangan lupa tambah Egg yang diproduksi di initialization list.
        Pterodactyl();

        // ctor dengan parameter
        // Jangan lupa tambah Egg yang diproduksi di initialization list.
        Pterodactyl(const string _name);

        // getter
        setName( _name);

        // setter
        getName();
};

#endif
