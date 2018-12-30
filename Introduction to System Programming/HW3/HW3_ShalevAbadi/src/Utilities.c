/*
 * Utilities.c
 *
 *  Created on: Dec 28, 2018
 *      Author: shale
 */
#include <stdio.h>

#define ALLOCATION_ERROR_STR "ERROR! Not enough memory!\n"

printAllocationError() {
	printf("%s", ALLOCATION_ERROR_STR);
}

void clearBuffer() {
	char garbage;
	do {
		scanf("%c", &garbage);
	} while (garbage != '\n');
}
