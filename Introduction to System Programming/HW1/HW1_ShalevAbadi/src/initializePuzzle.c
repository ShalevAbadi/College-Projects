/*
 * initializeMatrix.c
 *
 *  Created on: Nov 11, 2018
 *      Author: shale
 */

#include <stdio.h>
#include "initializePuzzle.h"

void initializePuzzle(int rows, int cols, int * puzzle){
	for (int i = 0 ; i < rows*cols; i++){
		*(puzzle + i) = i;
	}
}
