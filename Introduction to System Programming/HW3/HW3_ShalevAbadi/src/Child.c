/*
 * Child.c
 *
 *  Created on: Dec 26, 2018
 *      Author: shale
 */

#include <stdio.h>
#include "Child.h"

#define ASK_ID "ID No.:\n"
#define ASK_AGE "Age:\n"
#define SEARCH_ID "Enter child id:\n"
#define CHILD_EXIST "This child is in the Kindergarten\n"

Child* initChild(int newId, int newAge) {
	Child* newChild = (Child*) malloc(sizeof(Child));
	newChild->id = newId;
	newChild->age = newAge;
	return newChild;
}

Child** initEmptyChildrenArr(int size) {
	return (Child**) malloc(sizeof(Child) * size);
}

Child** initChildrenArrFromUser(int numOfChildren) {
	int i;
	Child** childrenArr = initEmptyChildrenArr(numOfChildren);
	for (i = 0; i < numOfChildren; i++) {
		childrenArr[i] = initChildFromUserIfNotExist(childrenArr,
				numOfChildren);
	}
	return childrenArr;
}

Child* initChildFromUserIfNotExist(Child** arrToSearchIn, int size) {
	int age;
	int id = getChildIdFromUser(arrToSearchIn, size);
	printf("%s", ASK_AGE);
	scanf("%d", &age);
	getchar();
	return initChild(id, age);
}

int getChildIdFromUser(Child** arrToSearchIn, int size) {
	int loopFlag = 1;
	int id;
	while (loopFlag) {
		printf("%s", ASK_ID);
		scanf("%d", &id);
		getchar();
		loopFlag = isChildInArrById(arrToSearchIn, size, id);
		if (loopFlag) {
			printf("%s", CHILD_EXIST);
		}
	}
	return id;
}

int isChildInArrById(Child** arrToSearch, int size, int id) {
	return getChildFromArr(arrToSearch, size, id) != NULL;
}

Child* searchChildInArrByUserInput(Child** arrToSearchIn, int size) {
	int id;
	printf("%s", SEARCH_ID);
	scanf("%d", &id);
	return getChildFromArr(arrToSearchIn, size, id);
}

Child* getChildFromArr(Child** arrToSearch, int size, int id) {
	int i;
	for (i = 0; i < size; i++) {
		if (arrToSearch[i]) {
			if (isChildIdEqualToId(arrToSearch[i], id)) {
				return arrToSearch[i];
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
	for (int i = 0; i < numOfChildren; i++) {
		printChild(childrenArr[i]);
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
	childToChange->age = newAge;
}

void releaseChildrenArr(Child** arrToRelease, int size) {
	int i;
	for (i = 0; i < size; i++) {
		releaseChild(arrToRelease[i]);
	}
	free(arrToRelease);
}

void releaseChild(Child* childToRelease) {
	free(childToRelease);
}
