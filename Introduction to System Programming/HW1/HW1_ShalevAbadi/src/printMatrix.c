/*
 * printMatrix.c
 *
 *  Created on: Nov 10, 2018
 *      Author: shale
 */

#include <stdio.h>
#include "printMatrix.h"

void printMatrix(int size, int *p) {
	int index = 0;
	for (int j = 0; j < size; j++) {
		for (int i = 0; i < size; i++) {
			printf("%d  ", *(p + index));
			index += 1;
		}
		printf("\n");
	}
		printf("\n");
}
