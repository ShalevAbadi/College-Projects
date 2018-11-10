/*
 * flipVertical.c
 *
 *  Created on: Nov 11, 2018
 *      Author: shale
 */

#include <stdio.h>
#include "flipVertical.h"

void flipVertical(int size, int * matrix) {
	int temp;
	for (int i = 0; i < size; i++) {
		for (int j = 0; j < size / 2; j++) {
			temp = *(matrix + (i * size + j));
			*(matrix + (i * size + j)) =
					*(matrix + (i * size + (size - 1 - j)));
			*(matrix + (i * size + (size - 1 - j))) = temp;
		}
	}
}
