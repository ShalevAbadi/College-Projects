/*
 * Child.h
 *
 *  Created on: Dec 26, 2018
 *      Author: shale
 */

#ifndef CHILD_H_
#define CHILD_H_

#include <stdio.h>
#include <stdlib.h>

typedef struct {
	int id;
	int age;
} Child;

Child* initChild(int newId, int newAge);
Child** initEmptyChildrenArr(int size);
Child** initChildrenArrFromUser(int numOfChildren);
Child* initChildFromUserIfNotExist(Child** arrToSearchIn, int size);
int getChildIdFromUser(Child** arrToSearchIn, int size);
int isChildInArrById(Child** arrToSearch, int size, int id);
Child* getChildFromArr(Child** arrToSearch, int size, int id);
int isChildIdEqualToId(Child* childToCheck, int idToCheck);
void writeChildrenArrToFile(Child** arrToWrite, int size, FILE* dst);
void writeChildToFile(Child* childToWrite, FILE* dst);
void printChildrenArr(Child** childrenArr, int numOfChildren);
void printChild(Child* childToPrint);
Child** readChildrenArrFromFile(int size, FILE* src);
void fillChildArrFromFile(int size, FILE* src, Child** childrenArr);
Child* readChildFromFile(FILE* src);
void changeChildAge(Child* childToChange, int newAge);
void releaseChildrenArr(Child** arrToRelease, int size);
void releaseChild(Child* childToRelease);

#endif /* CHILD_H_ */
