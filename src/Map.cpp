#include "../include/Map.hpp"
#include <iostream>
#include <fstream>
#include <string>

using namespace std;

Map::Map(){
    initMap("Map.txt");
}

Map::Map(string filename){
    initMap(filename);
}

void Map::initMap(string filename){
	string content;
    ifstream mapfile;
    mapfile.open (filename);
    int i = 0;
    while(!mapfile.eof) // To get you all the lines.
        {
            int j = 0;
            LinkedList<LinkedList<Cell*>> cellContent;
	        getline(mapfile,content); // Saves the line in STRING.
            //Per baris, inisialisasi LinkedList baru
            cellContent.add(LinkedList<Cell*>());
            for(char x: content){
                pair<int,int> pos = {i,j};
                if (x == '-'){
                    // Adding Grassland
                    cellContent.get(i).add(new Grassland(pos, false));
                } else if (x == 'x'){
                    // Adding Barn
                    cellContent.get(i).add(new Barn(pos, false));
                } else if (x == 'o'){
                    // Adding Coop
                    cellContent.get(i).add(new Coop(pos, false));
                } else if (x == 'T') {
                    //Adding Truck
                    cellContent.get(i).add(new Truck(pos));
                } else if (x == 'M') {
                    //Adding Mixer
                    cellContent.get(i).add(new Mixer(pos));
                } else if (x == 'W') {
                    //Adding Well
                    cellContent.get(i).add(new Well(pos));
                }
                j++;
            }
            i++;
        }
    mapfile.close();
}