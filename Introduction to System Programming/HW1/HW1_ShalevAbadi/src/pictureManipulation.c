/*
 * pictureManipulation.c
 *
 *  Created on: Nov 10, 2018
 *      Author: shale
 */

#include <stdio.h>
#include <stdlib.h>
#include "pictureManipulation.h"
#include "fillMatrixWithRandoms.h"
#include "printMatrix.h"
#include "pictureManipulationPrintMenu.h"
#include "rotateMatrix90DegreeClockwise.h"

void pictureManipulation(){
	int size= 5;
	int matrix[size][size];
	fillMatrixWithRandoms(size, matrix);
	printMatrix(size, matrix);
	pictureManipulationPrintMenu();
	rotateMatrix90DegreeClockwise(size, matrix);
	printMatrix(size, matrix);



}
