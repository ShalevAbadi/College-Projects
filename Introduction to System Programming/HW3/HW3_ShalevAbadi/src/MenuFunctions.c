/*
 * MenuFunctions.c
 *
 *  Created on: Dec 27, 2018
 *      Author: shale
 */

#include <stdio.h>
#include "MenuFunctions.h"
#include "Utilities.h"

#define FILE_NAME "DataFile.txt"
#define FILE_ERROR "Cannot Open File"
#define READ "r"
#define WRITE "w"
#define MENU_STR "==========================\nSelect:\n\n\t1. Read City information from file.\n\t2. Show all Kindergartens.\n\t3. Show a specific Kindergarten.\n\t4. Save City information to file.\n\t5. Add a Kindergarten.\n\t6. Add a Child.\n\t7. Birthday to a Child\n\t8. Count Hova children\n\t0. Exit\n"
#define SEARCH_KG_NAME_STR "Give me kindergarten name:\n"
#define KG_NOT_EXIST_STR "no such kindergarten\n"
#define CREATE_KG_NAME_STR "Name:\n"
#define CREATE_KG_TYPE_STR "Garden type:\nEnter 0 for Chova\nEnter 1 for Trom Chova\nEnter 2 for Trom Trom Chova\n"
#define INVALID_TYPE_STR "Invalid Type!\n"
#define CREATE_KG_NUM_OF_CHILDREN_STR "Enter children Details:\n\nChildren count:\n"
#define KG_EXIST_STR "This Kindergarten already in list\n"
#define ASK_ID "ID No.:\n"
#define ASK_AGE "Age:\n"
#define SEARCH_ID "Enter child id:\n"
#define CHILD_EXIST "This child is in the Kindergarten\n"
#define CHILD_NOT_FOUND "No such child\n"

void readCity(City* city) {
	FILE* f = fopen(FILE_NAME, READ);
	if (f) {
		readCityFromFile(city, f);
		fclose(f);
	} else {
		printf("%s '%s'\n", FILE_ERROR, FILE_NAME);
	}
}

int menu() {
	int userReq;
	printf("%s", MENU_STR);
	scanf("%d", &userReq);
	return userReq;
}

void saveCity(City* city) {
	FILE* f = fopen(FILE_NAME, WRITE);
	if (f) {
		writeCityToFile(city, f);
		fclose(f);
	} else {
		printf("%s", FILE_ERROR);
	}
}

void showSpecificGardenInCity(City* city) {
	printKindergarten(getKgFromCityByUserInputPrintIfNotFound(city));
}


void cityAddGarden(City* cityToAdd) {
	if (cityToAdd) {
		Kindergarten* newKg = initKindergartenFromUserIfNotExist(
				cityToAdd->kindergartensArr, cityToAdd->numOfKindergartens);
		if (newKg) {
			addKindergartenToCity(cityToAdd, newKg);
		}
	}
}

void addChildToSpecificGardenInCity(City* city) {
	Kindergarten* kgToAdd = getKgFromCityByUserInputPrintIfNotFound(city);
	if (kgToAdd) {
		addChildToKindergartenFromUser(kgToAdd);
	}
}

void birthdayToChild(City* city) {
	Child* child = getChildFromCityByUserInputPrintIfNotFound(city);
	if (child) {
		changeChildAge(child, child->age + 1);
	}
}

int countChova(City* city) {
	int i, count = 0;
	if (city) {
		for (i = 0; i < city->numOfKindergartens; i++) {
			if (city->kindergartensArr[i]->type == CHOVA) {
				count += city->kindergartensArr[i]->numOfChildren;
			}
		}
	}
	return count;
}

Kindergarten* initKindergartenFromUserIfNotExist(Kindergarten** arrToSearchIn,
		int size) {
	char* kgName = getKgNameFromUser(arrToSearchIn, size);
	kindergartenType kgType = getKgTypeFromUser();
	int numOfChildren = getNumOfChildrenFromUser();
	Child** childrenArr = initChildrenArrFromUser(numOfChildren);
	return initKindergarten(kgName, kgType, childrenArr, numOfChildren);
}



Kindergarten* getKgFromCityByUserInputPrintIfNotFound(City* cityToSearch) {
	Kindergarten* res;
	if (cityToSearch) {
		res = getKindergartenFromArrByUserInput(cityToSearch->kindergartensArr,
				cityToSearch->numOfKindergartens);
		if (!res) {
			printf("%s", KG_NOT_EXIST_STR);
		}
	}
	return res;
}

Child* getChildFromCityByUserInputPrintIfNotFound(City* cityToSearchIn) {
	Kindergarten* kgToSearchIn;
	Child* res = NULL;
	kgToSearchIn = getKgFromCityByUserInputPrintIfNotFound(cityToSearchIn);
	if (kgToSearchIn) {
		res = searchChildInArrByUserInput(kgToSearchIn->children,
				kgToSearchIn->numOfChildren);
		if (!res) {
			printf("%s", CHILD_NOT_FOUND);
		}
	}
	return res;
}


void addChildToKindergartenFromUser(Kindergarten* kgToAdd) {
	if (kgToAdd) {
		Child* childToAdd = initChildFromUserIfNotExist(kgToAdd->children,
				kgToAdd->numOfChildren);
		increaseKindergartenNumOfChildren(kgToAdd);
		addChildToKindergartenArr(kgToAdd, childToAdd);
	}
}

char* getKgNameFromUser(Kindergarten** arrToSearchIn, int size) {
	int loopFlag = 1;
	char kgName[KINDERGARTEN_NAME_MAX_LEN];
	while (loopFlag) {
		printf("%s", CREATE_KG_NAME_STR);
		scanf("%s", kgName);
		clearBuffer();
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
		clearBuffer();
		loopFlag = !isValidType(res);
		if (loopFlag) {
			printf("%s", INVALID_TYPE_STR);
		}
	}
	return res;
}

Kindergarten* getKindergartenFromArrByUserInput(Kindergarten** arrToSearch,
		int size) {
	char name[KINDERGARTEN_NAME_MAX_LEN];
	printf("%s", SEARCH_KG_NAME_STR);
	scanf("%s", name);
	return getKindergartenFromArr(arrToSearch, size, name);
}

Child** initChildrenArrFromUser(int numOfChildren) {
	int i;
	Child** childrenArr = initEmptyChildrenArr(numOfChildren);
	if (childrenArr) {
		for (i = 0; i < numOfChildren; i++) {
			childrenArr[i] = initChildFromUserIfNotExist(childrenArr,
					numOfChildren);
		}
	} else {
		printAllocationError();
	}
	return childrenArr;
}

int getNumOfChildrenFromUser() {
	int res;
	printf("%s", CREATE_KG_NUM_OF_CHILDREN_STR);
	scanf("%d", &res);
	clearBuffer();
	return res;
}

Child* initChildFromUserIfNotExist(Child** arrToSearchIn, int size) {
	int age;
	int id = addChildFromUserGetId(arrToSearchIn, size);
	printf("%s", ASK_AGE);
	scanf("%d", &age);
	clearBuffer();
	return initChild(id, age);
}

int addChildFromUserGetId(Child** arrToSearchIn, int size) {
	int loopFlag = 1;
	int id;
	while (loopFlag) {
		id = getChildIdFromUser();
		loopFlag = isChildInArrById(arrToSearchIn, size, id);
		if (loopFlag) {
			printf("%s", CHILD_EXIST);
		}
	}
	return id;
}

int getChildIdFromUser() {
	int id;
	printf("%s", SEARCH_ID);
	scanf("%d", &id);
	clearBuffer();
	return id;
}

Child* searchChildInArrByUserInput(Child** arrToSearchIn, int size) {
	int id;
	id = getChildIdFromUser();
	return getChildFromArr(arrToSearchIn, size, id);
}

