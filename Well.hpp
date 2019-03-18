#ifndef _WELL_HPP
#define _WELL_HPP

#include "Facility.hpp"

class Well : public Facility{
    public:
        /**
         * Interact berguna untuk berinteraksi dengan 'Well'.
         * Berinteraksi dengan 'Well' akan menambah persediaan
         * 'Water' yang dimiliki hingga mencapai maksimal.
         */
        void interact();
};

#endif
