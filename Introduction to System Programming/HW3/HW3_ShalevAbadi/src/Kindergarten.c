/*
 * Kindergarten.c
 *
 *  Created on: Dec 26, 2018
 *      Author: shale
 */

#include "Kindergarten.h"
#define SEARCH_KG_NAME_STR "Give me the Kindergarten Name:\n"
#define CREATE_KG_NAME_STR "Name:\n"
#define CREATE_KG_TYPE_STR "Garden type:\nEnter 0 for Chova\nEnter 1 for Trom Chova\nEnter 2 for Trom Trom Chova\n"
#define INVALID_TYPE_STR "Invalid Type!\n"
#define CREATE_KG_NUM_OF_CHILDREN_STR "Enter children Details:\n\nChildren count:\n"
#define KG_EXIST_STR "This Kindergarten already in list\n"
const char* kindergartenTypeStr[] = { "Chova", "Trom Chova", "Trom Trom hova" };

Kindergarten* initKindergarten(char* kgName, kindergartenType kgType,
		Child** childrenArr, int kgNumOfChildren) {
	Kindergarten* res = (Kindergarten*) malloc(sizeof(Kindergarten));
	res->name = kgName;
	res->type = kgType;
	res->children = childrenArr;
	res->numOfChildren = kgNumOfChildren;
	return res;
}

Kindergarten* initKindergartenFromUserIfNotExist(Kindergarten** arrToSearchIn,
		int size) {
	char* kgName = getKgNameFromUser(arrToSearchIn, size);
	kindergartenType kgType = getKgTypeFromUser();
	int numOfChildren = getNumOfChildrenFromUser();
	Child** childrenArr = initChildrenArrFromUser(numOfChildren);
	return initKindergarten(kgName, kgType, childrenArr, numOfChildren);
}

char* getKgNameFromUser(Kindergarten** arrToSearchIn, int size) {
	int loopFlag = 1;
	char kgName[KINDERGARTEN_NAME_MAX_LEN];
	while (loopFlag) {
		printf("%s", CREATE_KG_NAME_STR);
		scanf("%s", kgName);
		getchar();
		loopFlag = isKindergartenInArr(arrToSearchIn, size, kgName);
		if (loopFlag) {
			printf("%s", KG_EXIST_STR);
		}
	}
	return strdup(kgName);
}

kindergartenType getKgTypeFromUser() {
	kindergartenType res;
	int loopFlag = 1;
	while (loopFlag) {
		printf("%s", CREATE_KG_TYPE_STR);
		scanf("%u", &res);
		getchar();
		loopFlag = !isValidType(res);
		if (loopFlag) {
			printf("%s", INVALID_TYPE_STR);
		}
	}
	return res;
}

int isValidType(kindergartenType check) {
	return (check >= 0 && check < NUM_OF_ENUM_TYPES);
}

int getNumOfChildrenFromUser() {
	int res;
	printf("%s", CREATE_KG_NUM_OF_CHILDREN_STR);
	scanf("%d", &res);
	getchar();
	return res;
}

void addChildToKindergartenFromUser(Kindergarten* kgToAdd) {
	Child* childToAdd = initChildFromUserIfNotExist(kgToAdd->children,
			kgToAdd->numOfChildren);
	increaseKindergartenNumOfChildren(kgToAdd);
	addChildToKindergartenArr(kgToAdd, childToAdd);
}

void increaseKindergartenNumOfChildren(Kindergarten* dstKg) {
	dstKg->numOfChildren++;
	dstKg->children = realloc(dstKg->children, dstKg->numOfChildren);
}

void addChildToKindergartenArr(Kindergarten* dstKg, Child* childToAdd) {
	dstKg->children[dstKg->numOfChildren-1] = childToAdd;
}

int isKindergartenInArr(Kindergarten** arrToSearch, int size,
		char* kgToSearchName) {
	return getKindergartenFromArr(arrToSearch, size, kgToSearchName) != NULL;
}

Kindergarten* getKindergartenFromArrByUserInput(Kindergarten** arrToSearch,
		int size) {
	char name[KINDERGARTEN_NAME_MAX_LEN];
	printf("%s", SEARCH_KG_NAME_STR);
	scanf("%s", name);
	return getKindergartenFromArr(arrToSearch, size, name);
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
	for (i = 0; i < size; i++) {
		kgArr[i] = readKindergartenFromFile(src);
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
		writeKindergartenToFile(arrToWrite[i], dst);
	}
}

void writeKindergartenToFile(Kindergarten* kgToWrite, FILE* dst) {
	fprintf(dst, " %s %d %d\n", kgToWrite->name, kgToWrite->type,
			kgToWrite->numOfChildren);
	writeChildrenArrToFile(kgToWrite->children, kgToWrite->numOfChildren, dst);
}

void releaseKindergartenArr(Kindergarten** arrToFree, int size) {
	int i;
	for (i = 0; i < size; i++) {
		releaseKindergarten(arrToFree[i]);
	}
	free(arrToFree);
}

void releaseKindergarten(Kindergarten* kgToRelease) {
	releaseChildrenArr(kgToRelease->children, kgToRelease->numOfChildren);
	free(kgToRelease->name);
	free(kgToRelease);
}
