/*
 * swap.c
 *
 *  Created on: Nov 11, 2018
 *      Author: shale
 */

#include "swap.h"

void swap(int first, int second, int * arr) {
	int temp = *(arr + first);
	*(arr + first) = *(arr + second);
	*(arr + second) = temp;
}
