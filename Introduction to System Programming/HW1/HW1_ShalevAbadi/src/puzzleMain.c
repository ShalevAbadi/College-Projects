/*
 * puzzleMain.c
 *
 *  Created on: Nov 11, 2018
 *      Author: shale
 */

#include "puzzleMain.h"
#include "initializePuzzle.h"
#include "printMatrix.h"
#include <stdio.h>
#define ROWS 4
#define COLS 3
int puzzle[ROWS][COLS];

void puzzleMain() {
	initializePuzzle(ROWS, COLS, puzzle);
	printMatrix(ROWS,COLS,puzzle);

}
