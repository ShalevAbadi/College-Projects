/*
 * puzzle.c
 *
 *  Created on: Nov 13, 2018
 *      Author: shale
 */

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "generalMethods.h"
#include "puzzle.h"

#define ROWS 4
#define COLS 3
#define INVALID_MESSAGE_STR "Invalid step! \n"
#define STEP_STR "Your step: "
#define WIN_STR "You win! The game is over!"
#define SHUFFLE_COUNT 30

int win = -1;
int emptyPosition = 10;
int puzzle[ROWS][COLS];
int** p = puzzle;

void puzzleMain() {
	initializePuzzle();
	printMatrix(ROWS, COLS, *puzzle);
	printMatrix(ROWS, COLS, *puzzle);
	while (validateWin() < 0) {
		move();
	}
	printf("%s", WIN_STR);
}

void initializePuzzle() {

	for (int i = 0; i < ROWS * COLS; i++) {
		*(p + i) = i + 1;
	}
	*(p + 10) = 0;
	*(p + 11) = 11;
}

void shufflePuzzle() {
	int randA;
	int randB;
	srand(time(NULL));
	for (int i = 0; i < SHUFFLE_COUNT; i++) {
		randA = randomFromRange(0, ROWS * COLS - 1);
		randB = randomFromRange(0, ROWS * COLS - 1);
		swap(randA, randB, puzzle);
		if (randA == emptyPosition) {
			emptyPosition = randB;
		} else if (randB == emptyPosition) {
			emptyPosition = randA;
		}
	}
}

void move() {
	printf("%s", STEP_STR);
	int c;
	scanf("%d", &c);
	if (checkRight(c) < 0) {
		if (checkLeft(c) < 0) {
			if (checkUp(c) < 0) {
				if (checkDown(c) < 0) {
					printf("%s", INVALID_MESSAGE_STR);
					getchar();
				}
			}
		}
	}
	printMatrix(ROWS, COLS, *puzzle);

}

int validateWin() {
	if (emptyPosition == ROWS * COLS - 1) {
		for (int i = 0; i < ROWS * COLS - 2; i++) {
			if (*(p + i) != i + 1) {
				return -1;
			}
		}
		return 1;
	}
	return -1;
}

int checkUp(int userInput) {
	if (emptyPosition >= COLS) {
		int up = *(p + emptyPosition - COLS);
		if (up == userInput) {
			swap(emptyPosition - COLS, emptyPosition, *puzzle);
			emptyPosition = emptyPosition - COLS;
			return 1;
		}
	}
	return -1;
}

int checkDown(int userInput) {
	if (emptyPosition < COLS * (ROWS - 1)) {
		int up = *(p + emptyPosition + COLS);
		if (up == userInput) {
			swap(emptyPosition + COLS, emptyPosition, *puzzle);
			emptyPosition = emptyPosition + COLS;
			return 1;
		}
	}
	return -1;
}

int checkLeft(int userInput) {
	if ((emptyPosition + COLS) % COLS != 0) {
		int left = *(p + emptyPosition - 1);
		if (left == userInput) {
			swap(emptyPosition - 1, emptyPosition, *puzzle);
			emptyPosition--;
			return 1;
		}
	}
	return -1;
}

int checkRight(int userInput) {
	if ((emptyPosition) % COLS != COLS - 1) {
		int right = *(p + emptyPosition + 1);
		if (right == userInput) {
			swap(emptyPosition + 1, emptyPosition, *puzzle);
			emptyPosition++;
			return 1;
		}
	}
	return -1;
}

