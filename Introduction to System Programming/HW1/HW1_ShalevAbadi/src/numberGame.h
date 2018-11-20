/*
 * puzzle.h
 *
 *  Created on: Nov 13, 2018
 *      Author: shale
 */

#ifndef SRC_NUMBERGAME_H_
#define SRC_NUMBERGAME_H_


void puzzleMain();
void initializePuzzle(int *firstIndexPointer, int emptyPositionIndex);
void shufflePuzzle(int *firstIndexPointer, int emptyPositionIndex);
void playerMove(int *firstIndexPointer, int emptyPositionIndex);
void generateRowAndColRandoms(int * rowPointer, int * colPointer);
int validateWin(int *firstIndexPointer, int emptyPositionIndex);
int checkAroundEmptyPositionAndSwap(int userInput, int emptyPositionIndex,int* firstIndexPointer);
int checkLeftAndSwap(int userInput, int *firstIndexPointer, int emptyPositionIndex);
int checkRightAndSwap(int user_input, int *firstIndexPointer, int emptyPositionIndex);
int checkUpAndSwap(int user_input, int *firstIndexPointer, int emptyPositionIndex);
int checkDownAndSwap(int user_input, int *firstIndexPointer, int emptyPositionIndex);
int isUserInputAtIndex(int index, int user_input, int *firstIndexPointer);
int isEmptyPositionOnTop(int *firstIndexPointer, int emptyPositionIndex);
int isEmptyPositionOnBottom(int *firstIndexPointer, int emptyPositionIndex);
int isEmptyPositionOnRightEdge(int *firstIndexPointer, int emptyPositionIndex);
int isEmptypositionOnLeftEdge(int *firstIndexPointer, int emptyPositionIndex);
int checkAndSwapAroundEmptyPosition(int userInput, int *firstIndexPointer, int emptyPositionIndex);

#endif
