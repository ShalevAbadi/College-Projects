/*
 * flipHorizontal.c
 *
 *  Created on: Nov 11, 2018
 *      Author: shale
 */

#include <stdio.h>
#include "flipHorizontal.h"

void flipHorizontal1(int size, int * matrix){
	int temp;
		for (int i = 0; i < size / 2; i++) {
			for (int j = 0; j < size; j++) {
				temp = *(matrix + (i * size + j));
				*(matrix + (i * size + j)) =
						*(matrix + ((size-1-i) * size + j));
				*(matrix + ((size-1-i) * size + j)) = temp;
			}
		}
}
