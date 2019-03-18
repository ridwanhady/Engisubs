#ifndef _PTERODACTYL_H_
#define _PTERODACTYL_H_
#include "FarmAnimal.hpp"
#include "PterodactylEgg.hpp"

class Pterodactyl : public FarmAnimal {
      // ctor
      Pterodactyl();
      
      // 
      PterodactylEgg produceEgg();

};

#endif
