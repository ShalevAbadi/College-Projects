/*
 * Kindergarten.c
 *
 *  Created on: Dec 26, 2018
 *      Author: shale
 */

#include "Kindergarten.h"
#include "Utilities.h"

const char* kindergartenTypeStr[] = { "Chova", "Trom Chova", "Trom Trom hova" };

Kindergarten* initKindergarten(char* kgName, kindergartenType kgType,
		Child** childrenArr, int kgNumOfChildren) {
	Kindergarten* res = (Kindergarten*) malloc(sizeof(Kindergarten));
	if (res) {
		res->name = kgName;
		res->type = kgType;
		res->children = childrenArr;
		res->numOfChildren = kgNumOfChildren;
	} else {
		printAllocationError();
	}
	return res;
}

int isValidType(kindergartenType check) {
	return (check >= 0 && check < NUM_OF_ENUM_TYPES);
}

void increaseKindergartenNumOfChildren(Kindergarten* dstKg) {
	if (dstKg) {
		dstKg->numOfChildren++;
		dstKg->children = realloc(dstKg->children,
				sizeof(Child*) * dstKg->numOfChildren);
		if (!dstKg->children) {
			printAllocationError();
		}
	}
}

void addChildToKindergartenArr(Kindergarten* dstKg, Child* childToAdd) {
	if (dstKg && childToAdd) {
		dstKg->children[dstKg->numOfChildren - 1] = childToAdd;
	}
}

int isKindergartenInArr(Kindergarten** arrToSearch, int size,
		char* kgToSearchName) {
	return getKindergartenFromArr(arrToSearch, size, kgToSearchName) != NULL;
}

Kindergarten* getKindergartenFromArr(Kindergarten** arrToSearch, int size,
		char* kgToSearchName) {
	int i;
	for (i = 0; i < size; i++) {
		if (arrToSearch[i]) {
			if (isEqualNames(arrToSearch[i]->name, kgToSearchName)) {
				return arrToSearch[i];
			}
		}
	}
	return NULL;
}

int isEqualNames(char* name1, char* name2) {
	return (strcmp(name1, name2) == 0);
}

Kindergarten** readKindergartensArrFromFile(int size, FILE* src) {
	int i;
	Kindergarten** kgArr = (Kindergarten**) malloc(
			sizeof(Kindergarten*) * (size));
	if (kgArr) {
		for (i = 0; i < size; i++) {
			kgArr[i] = readKindergartenFromFile(src);
		}
	} else {
		printAllocationError();
	}
	return kgArr;
}

Kindergarten* readKindergartenFromFile(FILE* src) {
	int newType, newNumOfChildren;
	char* name = readKindergartenNameFromFile(src);
	fscanf(src, "%u %d", &newType, &newNumOfChildren);
	Child** newChildrenArr = readChildrenArrFromFile(newNumOfChildren, src);
	return initKindergarten(name, newType, newChildrenArr, newNumOfChildren);
}

char* readKindergartenNameFromFile(FILE* src) {
	char tempName[KINDERGARTEN_NAME_MAX_LEN];
	fscanf(src, "%s", tempName);
	return strdup(tempName);
}

void printKindergartensArr(Kindergarten** kgArr, int size) {
	int i;
	for (i = 0; i < size; i++) {
		printf("\nKindergarten %d:\n", i);
		printKindergarten(kgArr[i]);
	}
}

void printKindergarten(Kindergarten* kgToPrint) {
	if (kgToPrint) {
		printf("Name:%s		Type:%s 	%d Children:\n", kgToPrint->name,
				kindergartenTypeStr[kgToPrint->type], kgToPrint->numOfChildren);
		printChildrenArr(kgToPrint->children, kgToPrint->numOfChildren);
	}
}

void writeKindergartenArrToFile(Kindergarten** arrToWrite, int size, FILE* dst) {
	int i;
	for (i = 0; i < size; i++) {
		if (arrToWrite[i]) {
			writeKindergartenToFile(arrToWrite[i], dst);
		}
	}
}

void writeKindergartenToFile(Kindergarten* kgToWrite, FILE* dst) {
	if (kgToWrite) {
		fprintf(dst, " %s %d %d\n", kgToWrite->name, kgToWrite->type,
				kgToWrite->numOfChildren);
		writeChildrenArrToFile(kgToWrite->children, kgToWrite->numOfChildren,
				dst);
	}
}

void releaseKindergartenArr(Kindergarten** arrToFree, int size) {
	int i;
	if (arrToFree) {
		for (i = 0; i < size; i++) {
			if (arrToFree[i]) {
				releaseKindergarten(arrToFree[i]);
			}
		}
		free(arrToFree);
	}
}

void releaseKindergarten(Kindergarten* kgToRelease) {
	if (kgToRelease) {
		releaseChildrenArr(kgToRelease->children, kgToRelease->numOfChildren);
		free(kgToRelease->name);
		free(kgToRelease);
	}
}
