/*
 * pictureManipulation.c
 *
 *  Created on: Nov 10, 2018
 *      Author: shale
 */

#include <stdio.h>
#include <stdlib.h>
#include "pictureManipulation.h"
#include "generateMatrix.h"
#include "printMatrix.h"

void pictureManipulation(){
	int size= 5;
	int matrix[size][size];
	generateMatrix(size, matrix);
	printMatrix(size, matrix);

}
