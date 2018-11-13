/*
 * puzzle.h
 *
 *  Created on: Nov 13, 2018
 *      Author: shale
 */

void puzzleMain();
void initializePuzzle();
void shufflePuzzle();
void move();
int validateWin();
int checkLeft(int userInput);
int checkRight(int userInput);
int checkUp(int userInput);
int checkDown(int userInput);

