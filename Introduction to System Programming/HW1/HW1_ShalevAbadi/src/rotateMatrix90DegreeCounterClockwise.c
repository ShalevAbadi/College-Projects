/*
 * rotateMatrix90DegreeCounterClockwise.c
 *
 *  Created on: Nov 10, 2018
 *      Author: shale
 */

#include <stdio.h>
#include "rotateMatrix90DegreeCounterClockwise.h"
#include "flipVertical.h"

void rotateMatrix90DegreeCounterClockwise(int size, int * matrix) {
	int temp;
	for (int i = 0; i < size; i++) {
		for (int j = size - i - 2; j >= 0; j--) {
			temp = *(matrix + (i * size + j));
			*(matrix + (i * size + j)) = *(matrix + ((size - 1 - j) * size + size - 1 - i));
			*(matrix + ((size - 1 - j) * size + size - 1 - i)) = temp;
		}
	}

	flipVertical(size, matrix);
}

