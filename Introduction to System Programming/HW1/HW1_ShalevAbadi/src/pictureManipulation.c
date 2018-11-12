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
#include  "rotateMatrix90DegreeCounterClockwise.h"
#include "handlePMchoice.h"

void pictureManipulation(){
	int size= 5;
	int matrix[size][size];
	fillMatrixWithRandoms(size, matrix);
	printMatrix(size, size, matrix);
	pictureManipulationPrintMenu();
	handlePMchoice(size, matrix);

}
