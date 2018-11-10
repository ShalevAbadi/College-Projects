/*
 * rotateMatrix90DegreeCounterClockwise.c
 *
 *  Created on: Nov 10, 2018
 *      Author: shale
 */

#include <stdio.h>
#include "rotateMatrix90DegreeCounterClockwise.h"

void rotateMatrix90DegreeCounterClockwise(int size, int * matrix){
	int temp;
	for (int i = 0; i < size; i++)
	    {
	        for (int j = i + 1; j < size; j++)
	        {
	            temp = matrix[i][j];
	            matrix[i][j] = matrix[j][i];
	            matrix[j][i] = temp;
	        }
	    }

	    for (int i = 0; i < size; i++)
	    {
	        for (int j = 0; j < size / 2; j++)
	        {
	            temp = matrix[i][j];
	            matrix[i][j] = matrix[i][size - 1 - j];
	            matrix[i][size - 1 - j] = temp;
	        }
}
