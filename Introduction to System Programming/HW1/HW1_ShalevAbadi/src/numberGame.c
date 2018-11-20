/*
 * puzzle.c
 *
 *  Created on: Nov 13, 2018
 *      Author: shale
 */

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#include "numberGame.h"
#include "utilities.h"

#define ROWS 4
#define COLS 3
#define SHUFFLE_COUNT 30
#define INVALID_MESSAGE_STR "Invalid step! \n"
#define STEP_STR "Your step: "
#define WIN_STR "You win! The game is over!"

void puzzleMain() {

	int emptyPositionIndex = 0;
	int puzzle[ROWS][COLS];
	int* firstIndexPointer = &puzzle[0][0];
	initializePuzzle(firstIndexPointer, emptyPositionIndex);
	printMatrix(ROWS, COLS, firstIndexPointer);
	do {
		playerMove(firstIndexPointer, emptyPositionIndex);
	} while (!validateWin(firstIndexPointer, emptyPositionIndex));
	printf("%s", WIN_STR);
}

void initializePuzzle(int *firstIndexPointer, int emptyPositionIndex) {

	for (int i = 0; i < ROWS * COLS; i++) {
		*(firstIndexPointer + i) = i;
	}
	shufflePuzzle(firstIndexPointer, emptyPositionIndex);
}

void shufflePuzzle(int *firstIndexPointer, int emptyPositionIndex) {
	int randARow, randACol, randBRow, randBCol;
	int * randARowPointer = &randARow;
	int * randAColPointer = &randACol;
	int * randBRowPointer = &randBRow;
	int * randBColPointer = &randBCol;
	srand(time(NULL));
	for (int i = 0; i < SHUFFLE_COUNT; i++) {
		generateRowAndColRandoms(randARowPointer, randAColPointer);
		generateRowAndColRandoms(randBRowPointer, randBColPointer);
		int randAIndex = randARow * COLS + randACol;
		int randBIndex = randBRow * COLS + randBCol;
		swap(randAIndex, randBIndex, firstIndexPointer);
		if (randAIndex == emptyPositionIndex) {
			emptyPositionIndex = randBIndex;
		} else if (randBIndex == emptyPositionIndex) {
			emptyPositionIndex = randAIndex;
		}
	}
}

void generateRowAndColRandoms(int * rowPointer, int * colPointer) {
	*rowPointer = randomFromRange(0, ROWS - 1);
	*colPointer = randomFromRange(0, COLS - 1);
}

void playerMove(int *firstIndexPointer, int emptyPositionIndex) {
	int userInput = 0;
	int invalidStep = 1;
	while (invalidStep) {
		printf("%s", STEP_STR);
		scanf("%d", &userInput);
		clearBuffer();
		invalidStep = 0;
		if (!checkAroundEmptyPositionAndSwap(userInput, emptyPositionIndex,
				firstIndexPointer)) {
			printf("%s", INVALID_MESSAGE_STR);
			invalidStep = 1;
		}
	}
	printMatrix(ROWS, COLS, firstIndexPointer);
}

int checkAroundEmptyPositionAndSwap(int userInput, int emptyPositionIndex,
		int* firstIndexPointer) {
	if (!checkRightAndSwap(userInput, firstIndexPointer, emptyPositionIndex)) {
	} else if (!checkLeftAndSwap(userInput, firstIndexPointer,
			emptyPositionIndex)) {
	} else if (!checkUpAndSwap(userInput, firstIndexPointer,
			emptyPositionIndex)) {
	} else if (!checkDownAndSwap(userInput, firstIndexPointer,
			emptyPositionIndex)) {
		return 0;
	}
	return 1;
}

int validateWin(int *firstIndexPointer, int emptyPositionIndex) {
	if (emptyPositionIndex == ROWS * COLS - 1) {
		for (int i = 0; i < ROWS * COLS - 2; i++) {
			if (*(firstIndexPointer + i) != i + 1) {
				return 0;
			}
		}
		return 1;
	}
	return 0;
}

int checkUpAndSwap(int userInput, int *firstIndexPointer,
		int emptyPositionIndex) {
	if (!isEmptyPositionOnTop(firstIndexPointer, emptyPositionIndex)) {
		int up = emptyPositionIndex - COLS;
		if (isUserInputAtIndex(up, userInput, firstIndexPointer)) {
			swap(up, emptyPositionIndex, firstIndexPointer);
			emptyPositionIndex = emptyPositionIndex - COLS;
			return 1;
		}
	}
	return 0;
}

int isEmptyPositionOnTop(int *firstIndexPointer, int emptyPositionIndex) {
	return emptyPositionIndex < COLS;
}

int isUserInputAtIndex(int index, int userInput, int *firstIndexPointer) {
	return (*(firstIndexPointer + index) == userInput);
}

int checkDownAndSwap(int userInput, int *firstIndexPointer,
		int emptyPositionIndex) {
	if (!isEmptyPositionOnBottom(firstIndexPointer, emptyPositionIndex)) {
		int down = emptyPositionIndex + COLS;
		if (isUserInputAtIndex(down, userInput, firstIndexPointer)) {
			swap(down, emptyPositionIndex, firstIndexPointer);
			emptyPositionIndex = emptyPositionIndex + COLS;
			return 1;
		}
	}
	return 0;
}

int isEmptyPositionOnBottom(int *firstIndexPointer, int emptyPositionIndex) {
	return (emptyPositionIndex >= COLS * (ROWS - 1));
}

int checkLeftAndSwap(int userInput, int *firstIndexPointer,
		int emptyPositionIndex) {
	if (!isEmptypositionOnLeftEdge(firstIndexPointer, emptyPositionIndex)) {
		int left = emptyPositionIndex - 1;
		if (isUserInputAtIndex(left, userInput, firstIndexPointer)) {
			swap(left, emptyPositionIndex, firstIndexPointer);
			emptyPositionIndex--;
			return 1;
		}
	}
	return 0;
}

int isEmptypositionOnLeftEdge(int *firstIndexPointer, int emptyPositionIndex) {
	return (emptyPositionIndex + COLS) % COLS == 0;
}

int checkRightAndSwap(int userInput, int *firstIndexPointer,
		int emptyPositionIndex) {
	if (!isEmptyPositionOnRightEdge(firstIndexPointer, emptyPositionIndex)) {
		int right = emptyPositionIndex + 1;
		if (isUserInputAtIndex(right, userInput, firstIndexPointer)) {
			swap(right, emptyPositionIndex, firstIndexPointer);
			emptyPositionIndex++;
			return 1;
		}
	}
	return 0;
}

int isEmptyPositionOnRightEdge(int *firstIndexPointer, int emptyPositionIndex) {
	return ((emptyPositionIndex) % COLS == COLS - 1);
}
