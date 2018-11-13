/*
 * puzzleMain.c
 *
 *  Created on: Nov 11, 2018
 *      Author: shale
 */

#include "puzzleMain.h"
#include "initializePuzzle.h"
#include "generalMethods.h"
#include <stdio.h>
#define ROWS 4
#define COLS 3
int puzzle[ROWS][COLS];

void puzzleMain1() {
	initializePuzzle1(ROWS, COLS, puzzle);

}

