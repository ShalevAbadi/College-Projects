/*
 * printMatrix.c
 *
 *  Created on: Nov 10, 2018
 *      Author: shale
 */

#include <stdio.h>
#include "printMatrix.h"

void printMatrix(int rows,int cols, int * p) {
	int index = 0;
	for (int j = 0; j < rows; j++) {
		for (int i = 0; i < cols; i++) {
			printf("%d  ", *(p + index));
			index += 1;
		}
		printf("\n");
	}
		printf("\n");
}
