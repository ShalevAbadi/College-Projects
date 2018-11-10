/*
 * rotateMatrix90DegreeClockwise.c
 *
 *  Created on: Nov 10, 2018
 *      Author: shale
 */

#include <stdlib.h>
#include "rotateMatrix90DegreeClockwise.h"

void rotateMatrix90DegreeClockwise(int size, int * matrix) {
	int temp;
	for (int i = 0; i < size; i++) {
		for (int j = i + 1; j < size; j++) {
			temp = *(matrix + (i * size + j));
			*(matrix + (i * size + j)) = *(matrix + (j * size + i));
			*(matrix + (j * size + i)) = temp;
		}
	}

	for (int i = 0; i < size; i++) {
		for (int j = 0; j < size / 2; j++) {
			temp = *(matrix + (i * size + j));
			*(matrix + (i * size + j)) =
					*(matrix + (i * size + (size - 1 - j)));
			*(matrix + (i * size + (size - 1 - j))) = temp;
		}
	}
}
