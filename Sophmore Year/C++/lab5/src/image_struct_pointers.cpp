/*
PROGRAM: image_struct_pointers.CPP
Written by Austin Haggard
This program loads and saves an image using the image struct
Last modification: 19FEB2015
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
Image* load_image(const char* fileName){
/******* Implement the function *******/
		Image *img = new Image;
		ifstream file(fileName);
	    stringstream iss;
	    string line, widthS, heightS, maxS;
	    unsigned temp;
	    assert(file.good());
	    //gets image type
	    getline(file,line);
	    img->magicNumber = line;
	    assert(img->magicNumber == "P2");
	    iss << file.rdbuf();
	    //reads width height and max pixel value
	    iss >> widthS >> heightS >> maxS;
	    istringstream reader(widthS);
	    reader >> img->width;
	    istringstream reader1(heightS);
	    reader1 >> img->height;
	    istringstream reader2(maxS);
	    reader2 >> img->maxPixelValue;
	    img->pixelRaster = new unsigned char[img->width * img->height];
	    //gets image
	    for (unsigned i = 0; i < img->height; ++i) {
			for (unsigned j = 0; j < img->width; ++j) {
			   	iss >> temp;
			   	assert (temp <= img->maxPixelValue);
		    	img->pixelRaster[index(i, j, img->width)] = static_cast<unsigned char>(temp);

			}
		}
	    file.close();
	    return img;
}
/** DO NOT MODIFY FUNCTION SIGNATURE **/
int save_image(const char* fileName, const Image* im){
/******* Implement the function *******/
	//outputs file
	ofstream outFile(fileName);
	assert(outFile.good());
	outFile << im->magicNumber << endl;
	outFile << im->width << ' ' << im->height << endl;
	outFile << im->maxPixelValue << endl;
	for (unsigned i = 0; i < im->height; ++i) {
		for (unsigned j = 0; j < im->width; ++j) {
			//respects line limit
			if (j % 17 == 0)
				outFile << endl;
			outFile << static_cast<unsigned>(im->pixelRaster[index(i,j,im->width)]) << ' ';
		}
		outFile << endl;
	}
	outFile.close();
return 0;
}


/** DO NOT MODIFY FUNCTION SIGNATURE **/
void load_and_save(const char* imageToLoad, const char* imageToSave){
/******* Implement the function *******/
	Image *image;
	//tests file extension
	string img1 = imageToLoad, img2 = imageToSave;
	assert(img1.substr(img1.find_last_of(".") + 1) == "pgm");
	assert(img2.substr(img2.find_last_of(".") + 1) == "pgm");
	image = load_image(imageToLoad);
	save_image(imageToSave, image);

}

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
