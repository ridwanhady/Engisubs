#include "Map.hpp"
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
            vector<Cell> tempContent;
	        getline(mapfile,content); // Saves the line in STRING.
	        int j = 0;
            for(char x : content){
                pair<int,int> pos = {i,j};
                if (x == '-'){
                    // Adding Grassland
                    
                    Grassland grass(pos, false);
                    tempContent.push_back(grass);
                } else if (x == 'x'){
                    // Adding Barn
                    Barn barn(pos, false);
                    tempContent.push_back(barn);
                } else if (x == 'o'){
                    // Adding Coop
                    Coop coop(pos, false);
                    tempContent.push_back(coop);
                }
                j++;
            }
            contents.push_back(tempContent);
            i++;
        }
    mapfile.close();
}