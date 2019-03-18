#ifndef _PTERODACTYL_H_
#define _PTERODACTYL_H_

#include "FarmAnimal.hpp"
#include "PterodactylEgg.hpp"
#include <string>

class Pterodactyl : public FarmAnimal {
      // ctor
      Pterodactyl();
      
      // ctor dengan parameter
      Pterodactyl(const string _name);
      
        // getter
        setName( _name);
    
        // setter
        getName(); 
      
      
      // produksi
      PterodactylEgg produceEgg();

};

#endif
