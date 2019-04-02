#ifndef _FARMPRODUCT_HPP_
#define _FARMPRODUCT_HPP_
#include "Product.hpp"

//Kelas ini merepresentasikan produk dari hewan.
class FarmProduct : public Product {
  protected:
      //Nama hewan yang memproduksi.
      string producer;
  public:
      //Constructor harus menerima harga, dan menginisialisasi tipe untuk superclass.
      FarmProduct();

      string getProducer(){
          return producer;
      }
};

#endif
