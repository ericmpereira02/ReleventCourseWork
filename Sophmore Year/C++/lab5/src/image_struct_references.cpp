/*
PROGRAM: FILE_NAME.CPP
Written by YOUR_NAME_AND_SURNAME_HERE
This program...
Last modification:
*/

/** DO NOT REMOVE THIS INCLUDE STATEMENT **/
#include "dummy_driver.h"
/******************************************/

/** You might need to add some headers here **/
#include <cassert>
#include <fstream>
#include <sstream>
#include <string.h>
#include <iostream>
int index(unsigned, unsigned, unsigned);
using namespace std;
/** DO NOT MODIFY FUNCTION SIGNATURE **/
int load_image(const char* fileName, Image& im){
/******* Implement the function *******/
	ifstream file(fileName);
    stringstream iss;
    string line, widthS, heightS, maxS;
    unsigned temp;
    assert(file.good());
    //gets image type
    getline(file,line);
    im.magicNumber = line;
    assert(im.magicNumber == "P2");
    iss << file.rdbuf();
    //reads width height and max pixel value
    iss >> widthS >> heightS >> maxS;
    istringstream reader(widthS);
    reader >> im.width;
    istringstream reader1(heightS);
    reader1 >> im.height;
    istringstream reader2(maxS);
    reader2 >> im.maxPixelValue;
    im.pixelRaster = new unsigned char[im.width * im.height];
    //gets image
    for (unsigned i = 0; i < im.height; ++i) {
		for (unsigned j = 0; j < im.width; ++j) {
		   	iss >> temp;
		   	assert (temp <= im.maxPixelValue);
	    	im.pixelRaster[index(i, j, im.width)] = static_cast<unsigned char>(temp);

		}
	}
    file.close();
    return 1;
}
/** DO NOT MODIFY FUNCTION SIGNATURE **/
int save_image(const char* fileName, const Image& im){
/******* Implement the function *******/
	//outputs file
	ofstream outFile(fileName);
	assert(outFile.good());
	outFile << im.magicNumber << endl;
	outFile << im.width << ' ' << im.height << endl;
	outFile << im.maxPixelValue << endl;
	for (unsigned i = 0; i < im.height; ++i) {
		for (unsigned j = 0; j < im.width; ++j) {
			//respects line limit
			if (j % 17 == 0)
				outFile << endl;
			outFile << static_cast<unsigned>(im.pixelRaster[index(i,j,im.width)]) << ' ';
		}
		outFile << endl;
	}
	outFile.close();
return 1;
}


/** DO NOT MODIFY FUNCTION SIGNATURE **/
void load_and_save(const char* imageToLoad, const char* imageToSave){
/******* Implement the function *******/
	Image image;
	//tests file extension
	string img1 = imageToLoad, img2 = imageToSave;
	assert(img1.substr(img1.find_last_of(".") + 1) == "pgm");
	assert(img2.substr(img2.find_last_of(".") + 1) == "pgm");
	load_image(imageToLoad,image);
	save_image(imageToSave,image);
}
//calculates array index
int index(unsigned i, unsigned j, unsigned M){

	return (unsigned) i * M + j;

}

int main()
{
    
    /**                       DO NOT MODIFY UNDER THIS LINE
     * ***************************************************************************************/
    int retval = test1(load_and_save);
    return retval;
}
