/*
 * generateMatrix.c
 *
 *  Created on: Nov 10, 2018
 *      Author: shale
 */

#include "fillMatrixWithRandoms.h"

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int lower = 1;
int upper = 99;
void fillMatrixWithRandoms1(int size, int * matrix) {
	srand(time(NULL));
	for (int i = 0; i < size * size; i++) {
		*(matrix + i) = (rand() % (upper - lower + 1)) + lower;
	}
}

