/*
 * handlePMchoice.c
 *
 *  Created on: Nov 10, 2018
 *      Author: shale
 */


#include <stdio.h>
#include <stdlib.h>
#include "handlePMchoice.h"
#include "flipVertical.h"
#include "rotateMatrix90DegreeClockwise.h"
#include "rotateMatrix90DegreeCounterClockwise.h"
#include "flipHorizontal.h"
#include "generalMethods.h"

void handlePMchoice1(int size, int * matrix){
int choice;

do{
		scanf("%d", &choice);
		switch (choice) {
		case 1:
			rotateMatrix90DegreeClockwise(size,matrix);
			printMatrix(size, size, matrix);
			break;
		case 2:
			rotateMatrix90DegreeCounterClockwise(size, matrix);
			printMatrix(size, size, matrix);

			break;
		case 3:
			flipHorizontal(size, matrix);
			printMatrix(size, size, matrix);
			break;
		case 4:
			flipVertical(size, matrix);
			printMatrix(size, size, matrix);
			break;
		case -1:
			exit(0);
			break;
		default:
		getchar();
		}
	} while(1);
}
