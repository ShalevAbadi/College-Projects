/*
 * Child.c
 *
 *  Created on: Dec 26, 2018
 *      Author: shale
 */

#include <stdio.h>
#include "Child.h"
#include "Utilities.h"

Child* initChild(int newId, int newAge) {
	Child* newChild = (Child*) malloc(sizeof(Child));
	if (newChild) {
		newChild->id = newId;
		newChild->age = newAge;
	} else {
		printAllocationError();
	}
	return newChild;
}

Child** initEmptyChildrenArr(int size) {
	return (Child**) malloc(sizeof(Child) * size);
}

int isChildInArrById(Child** arrToSearch, int size, int id) {
	return getChildFromArr(arrToSearch, size, id) != NULL;
}

Child* getChildFromArr(Child** arrToSearch, int size, int id) {
	int i;
	if (arrToSearch) {
		for (i = 0; i < size; i++) {
			if (arrToSearch[i]) {
				if (isChildIdEqualToId(arrToSearch[i], id)) {
					return arrToSearch[i];
				}
			}
		}
	}
	return NULL;
}

int isChildIdEqualToId(Child* childToCheck, int idToCheck) {
	return childToCheck->id == idToCheck;
}

void writeChildrenArrToFile(Child** arrToWrite, int size, FILE* dst) {
	int i;
	for (i = 0; i < size; i++) {
		writeChildToFile(arrToWrite[i], dst);
	}
}

void writeChildToFile(Child* childToWrite, FILE* dst) {
	fprintf(dst, "%d %d\n", childToWrite->id, childToWrite->age);
}

void printChildrenArr(Child** childrenArr, int numOfChildren) {
	if (childrenArr) {
		for (int i = 0; i < numOfChildren; i++) {
			if (childrenArr[i]) {
				printChild(childrenArr[i]);
			}
		}
	}
}

void printChild(Child* childToPrint) {
	if (childToPrint) {
		printf("ID:%d	Age:%d\n", childToPrint->id, childToPrint->age);
	}
}

Child** readChildrenArrFromFile(int size, FILE* src) {
	Child** childrenArr = initEmptyChildrenArr(size);
	fillChildArrFromFile(size, src, childrenArr);
	return childrenArr;
}

void fillChildArrFromFile(int size, FILE* src, Child** childrenArr) {
	int i;
	for (i = 0; i < size; i++) {
		Child* newChild = readChildFromFile(src);
		childrenArr[i] = newChild;
	}
}

Child* readChildFromFile(FILE* src) {
	int age, id;
	fscanf(src, "%d %d", &id, &age);
	return initChild(id, age);
}

void changeChildAge(Child* childToChange, int newAge) {
	if (childToChange) {
		childToChange->age = newAge;
	}
}

void releaseChildrenArr(Child** arrToRelease, int size) {
	int i;
	if (arrToRelease) {
		for (i = 0; i < size; i++) {
			releaseChild(arrToRelease[i]);
		}
		free(arrToRelease);
	}
}

void releaseChild(Child* childToRelease) {
	if (childToRelease) {
		free(childToRelease);
	}
}
