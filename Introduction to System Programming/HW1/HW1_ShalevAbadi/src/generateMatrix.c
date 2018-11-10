/*
 * generateMatrix.c
 *
 *  Created on: Nov 10, 2018
 *      Author: shale
 */

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "generateMatrix.h"
#include "printMatrix.h"

int lower = 1;
int upper = 99;
void generateMatrix(int size, int matrix[][size]) {
	for (int j = 0; j < size; j++) {
		for (int i = 0; i < size; i++) {
			matrix[i][j] = (rand() % (upper - lower + 1)) + lower;
		}
	}
}
