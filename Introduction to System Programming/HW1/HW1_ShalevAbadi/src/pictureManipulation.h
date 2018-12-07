/*
 * pictureManipulation.h
 *
 *  Created on: Nov 10, 2018
 *      Author: shale
 */

#ifndef SRC_PICTUREMANIPULATION_H_
#define SRC_PICTUREMANIPULATION_H_

void pictureManipulationMain();
void fillMatrixWithRandoms(int *matrixFirstIndexPointer);
void pictureManipulationPrintMenu();
void handle_pm_choice(int *returnToMainMenu, int *matrixFirstIndexPointer);
void flipVertical(int *matrixFirstIndexPointer);
void rotateMatrix90DegreesClockwise(int *matrixFirstIndexPointer);
void transposeMatrix(int *matrixFirstIndexPointer);
void rotateMatrix90DegreesCounterClockwise(int *matrixFirstIndexPointer);
void flipHorizontal(int *matrixFirstIndexPointer);

#endif
