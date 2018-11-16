/*
 * pictureManipulation.c
 *
 *  Created on: Nov 10, 2018
 *      Author: shale
 */

#include <stdio.h>
#include <stdlib.h>
#include "pictureManipulation.h"
#include "generalMethods.h"

#define PM_SIZE 5
#define PM_MENU_STR "Please choose one of the following options\n1 - 90 degree clockwise\n2 - 90 degree counter clockwise\n3 - Flip Horizontal\n4 - Flip Vertical\n-1 - Quit\n"
#define PM_LOWER_RAND 0
#define PM_UPPER_RAND 99
#define PM_DIGITS 2

int PM_MATRIX[PM_SIZE][PM_SIZE];

void pictureManipulationMain() {
	fillMatrixWithRandoms(PM_MATRIX);
	printMatrix(PM_SIZE, PM_SIZE, PM_MATRIX);
	pictureManipulationPrintMenu();
	handlePMchoice();

}

void fillMatrixWithRandoms(int * matrix) {
	srand(time(NULL));
	for (int i = 0; i < PM_SIZE * PM_SIZE; i++) {
		*(matrix + i) = randomFromRange(PM_LOWER_RAND, PM_UPPER_RAND);
	}
}

void pictureManipulationPrintMenu() {
	printf("%s", PM_MENU_STR);
}

void handlePMchoice() {
	int choice;

	do {
		scanf("%d", &choice);
		switch (choice) {
		case 1:
			rotateMatrix90DegreesClockwise(PM_MATRIX);
			printMatrix(PM_SIZE, PM_SIZE, PM_MATRIX);
			break;
		case 2:
			rotateMatrix90DegreesCounterClockwise(PM_MATRIX);
			printMatrix(PM_SIZE, PM_SIZE, PM_MATRIX);
			break;
		case 3:
			flipHorizontal(PM_MATRIX);
			printMatrix(PM_SIZE, PM_SIZE, PM_MATRIX);
			break;
		case 4:
			flipVertical(PM_MATRIX);
			printMatrix(PM_SIZE, PM_SIZE, PM_MATRIX);
			break;
		case -1:
			exit(0);
			break;
		default:
			getchar();
		}
	} while (1);
}

void rotateMatrix90DegreesClockwise(int * matrix) {

	int temp;
	for (int i = 0; i < PM_SIZE; i++) {
		for (int j = i + 1; j < PM_SIZE; j++) {
			temp = *(matrix + (i * PM_SIZE + j));
			*(matrix + (i * PM_SIZE + j)) = *(matrix + (j * PM_SIZE + i));
			*(matrix + (j * PM_SIZE + i)) = temp;
		}
	}

	flipVertical(matrix);
}

void flipVertical(int * matrix) {
	for (int i = 0; i < PM_SIZE; i++) {
		for (int j = 0; j < PM_SIZE / 2; j++) {
			swap((i * PM_SIZE + j), (i * PM_SIZE + (PM_SIZE - 1 - j)), matrix);
		}
	}
}

void flipHorizontal(int * matrix){
	int temp;
		for (int i = 0; i < PM_SIZE / 2; i++) {
			for (int j = 0; j < PM_SIZE; j++) {
				temp = *(matrix + (i * PM_SIZE + j));
				*(matrix + (i * PM_SIZE + j)) =
						*(matrix + ((PM_SIZE-1-i) * PM_SIZE + j));
				*(matrix + ((PM_SIZE-1-i) * PM_SIZE + j)) = temp;
			}
		}
}

void rotateMatrix90DegreesCounterClockwise(int * matrix) {
	int temp;
	for (int i = 0; i < PM_SIZE; i++) {
		for (int j = PM_SIZE - i - 2; j >= 0; j--) {
			temp = *(matrix + (i * PM_SIZE + j));
			*(matrix + (i * PM_SIZE + j)) = *(matrix
					+ ((PM_SIZE - 1 - j) * PM_SIZE + PM_SIZE - 1 - i));
			*(matrix + ((PM_SIZE - 1 - j) * PM_SIZE + PM_SIZE - 1 - i)) = temp;
		}
	}

	flipVertical(matrix);
}

