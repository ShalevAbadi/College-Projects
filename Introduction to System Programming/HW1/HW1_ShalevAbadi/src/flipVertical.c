/*
 * flipVertical.c
 *
 *  Created on: Nov 11, 2018
 *      Author: shale
 */

#include <stdio.h>
#include "flipVertical.h"
#include "swap.h"

void flipVertical(int size, int * matrix) {
	for (int i = 0; i < size; i++) {
		for (int j = 0; j < size / 2; j++) {
			swap((i * size + j), (i * size + (size - 1 - j)), matrix);
		}
	}
}
