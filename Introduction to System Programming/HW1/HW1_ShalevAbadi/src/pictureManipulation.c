/*
 * pictureManipulation.c
 *
 *  Created on: Nov 10, 2018
 *      Author: shale
 */



#include <stdio.h>
#include <time.h>
#include <stdlib.h>

#include "pictureManipulation.h"
#include "utilities.h"

#define PM_SIZE 5
#define PM_LOWER_RAND 0
#define PM_UPPER_RAND 99
#define PM_DIGITS 2
#define PM_MENU_STR "\nPlease choose one of the following options\n1 - 90 degree clockwise\n2 - 90 degree counter clockwise\n3 - Flip Horizontal\n4 - Flip Vertical\n-1 - Quit\n"
#define PM_AFTER_STR "--------- picture after manipulation ---------\n"
#define PM_INVALID_STR "invalid input\n"

void pictureManipulationMain() {

	int PM_MATRIX[PM_SIZE][PM_SIZE];
	int *matrixFirstIndexPointer = &PM_MATRIX[0][0];
	fillMatrixWithRandoms(matrixFirstIndexPointer);
	int returnToMainMenu = 0;
	do {
		printMatrix(PM_SIZE, PM_SIZE, matrixFirstIndexPointer);
		handle_pm_choice(&returnToMainMenu, matrixFirstIndexPointer);
		if (!returnToMainMenu) {
			printf("%s", PM_AFTER_STR);
		}
	} while (!returnToMainMenu);
}

void fillMatrixWithRandoms(int *matrixFirstIndexPointer) {
	srand(time(NULL));
	for (int i = 0; i < PM_SIZE * PM_SIZE; i++) {
		*(matrixFirstIndexPointer + i) = randomFromRange(PM_LOWER_RAND,
		PM_UPPER_RAND);
	}
}

void pictureManipulationPrintMenu() {
	printf("%s", PM_MENU_STR);
}

void handle_pm_choice(int *returnToMainMenu, int *matrixFirstIndexPointer) {
	int isInvalidChoice;
	int choice;
	do {
		clearBuffer();
		pictureManipulationPrintMenu();
		scanf("%d", &choice);
		isInvalidChoice = 0;
		switch (choice) {
		case 1:
			rotateMatrix90DegreesClockwise(matrixFirstIndexPointer);
			break;
		case 2:
			rotateMatrix90DegreesCounterClockwise(matrixFirstIndexPointer);
			break;
		case 3:
			flipHorizontal(matrixFirstIndexPointer);
			break;
		case 4:
			flipVertical(matrixFirstIndexPointer);
			break;
		case -1:
			*returnToMainMenu = 1;
			break;
		default:
			isInvalidChoice = 1;
			printf("%s", PM_INVALID_STR);
			break;
		}
	} while (isInvalidChoice);

}

void rotateMatrix90DegreesClockwise(int *matrixFirstIndexPointer) {
	transposeMatrix(matrixFirstIndexPointer);
	flipVertical(matrixFirstIndexPointer);
}

void rotateMatrix90DegreesCounterClockwise(int *matrixFirstIndexPointer) {
	flipVertical(matrixFirstIndexPointer);
	transposeMatrix(matrixFirstIndexPointer);
}

void transposeMatrix(int *matrixFirstIndexPointer) {
	int firstIndex, secondIndex;
	for (int i = 0; i < PM_SIZE; i++) {
		for (int j = i + 1; j < PM_SIZE; j++) {
			firstIndex = i * PM_SIZE + j;
			secondIndex = j * PM_SIZE + i;
			swap(firstIndex, secondIndex, matrixFirstIndexPointer);
		}
	}
}

void flipVertical(int *matrixFirstIndexPointer) {
	int firstIndex, secondIndex;
	for (int i = 0; i < PM_SIZE; i++) {
		for (int j = 0; j < PM_SIZE / 2; j++) {
			firstIndex = i * PM_SIZE + j;
			secondIndex = i * PM_SIZE + (PM_SIZE - 1 - j);
			swap(firstIndex, secondIndex, matrixFirstIndexPointer);
		}
	}
}

void flipHorizontal(int *matrixFirstIndexPointer) {
	int firstIndex, secondIndex;
	for (int i = 0; i < PM_SIZE / 2; i++) {
		for (int j = 0; j < PM_SIZE; j++) {
			firstIndex = (i * PM_SIZE + j);
			secondIndex = (PM_SIZE - 1 - i) * PM_SIZE + j;
			swap(firstIndex, secondIndex, matrixFirstIndexPointer);
		}
	}
}

