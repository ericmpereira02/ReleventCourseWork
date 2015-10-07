/*
PROGRAM: load_and_save_image_files.CPP
Written by Austin Haggard
This program loads and saves images
Last modification: 15FEB2015
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
int index(unsigned,unsigned, unsigned);
using namespace std;
/** DO NOT MODIFY FUNCTION SIGNATURE **/
unsigned* load_image(const char* fileName, unsigned & width, unsigned & height, unsigned & maxPixelValue){
/**************************************/

    /** Implement the function **/
    ifstream file(fileName);
    stringstream iss;
    string line, widthS, heightS, maxS, imgS;
    assert(file.good());
    //gets image type
    getline(file,line);
    assert(line == "P2");
    iss << file.rdbuf();
    //reads width height and max pixel value
    iss >> widthS >> heightS >> maxS;
    istringstream reader(widthS);
    reader >> width;
    istringstream reader1(heightS);
    reader1 >> height;
    istringstream reader2(maxS);
    reader2 >> maxPixelValue;
    unsigned *image = new unsigned[width * height];
    //gets image
    for (int i = 0; i < (int)height; ++i) {
		for (int j = 0; j < (int)width; ++j) {
		   	iss >> imgS;
		   	stringstream reader3(imgS);
	    	reader3 >> image[index(i, j, width)];
	    	assert (image[index(i, j, width)] <= maxPixelValue);
		}
	}
    return image;
}
/** DO NOT MODIFY FUNCTION SIGNATURE **/
int save_image(const char* fileName, const unsigned* Image, unsigned width, unsigned height, unsigned maxPixelValue){
/**************************************/

    /** Implement the function **/
	//outputs file
	ofstream outFile(fileName);
	assert(outFile.good());
	outFile << "P2" << endl;
	outFile << width << ' ' << height << endl;
	outFile << maxPixelValue << endl;
	for (int i = 0; i < (int)height; ++i) {
		for (int j = 0; j < (int)width; ++j) {
			outFile << Image[index(i,j,width)] << ' ';
		}
		outFile << endl;
	}
return 0;
}


/** DO NOT MODIFY FUNCTION SIGNATURE **/
void load_and_save(const char* imageToLoad, const char* imageToSave){
/**************************************/
    /** Implement the function **/
	//tests file extension
	string img1 = imageToLoad, img2 = imageToSave;
	assert(img1.substr(img1.find_last_of(".") + 1) == "pgm");
	assert(img2.substr(img2.find_last_of(".") + 1) == "pgm");
	unsigned width, height, maxPixelVal, *image;
	image = load_image(imageToLoad,width,height,maxPixelVal);
	save_image(imageToSave,(const unsigned*)image, width, height, maxPixelVal);
}
//for single array to 2d conversion
int index(unsigned i, unsigned j, unsigned M){

	return (unsigned) i * M + j;

}

int main()
{
    
    /**                       DO NOT MODIFY UNDER THIS LINE
     * ***************************************************************************************/
    int retval = test2(load_and_save);
    return retval;
}
