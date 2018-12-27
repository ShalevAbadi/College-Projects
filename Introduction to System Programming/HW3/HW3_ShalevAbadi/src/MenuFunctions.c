/*
 * MenuFunctions.c
 *
 *  Created on: Dec 27, 2018
 *      Author: shale
 */

#include <stdio.h>
#include "MenuFunctions.h"
#define FILE_NAME "DataFile.txt"
#define FILE_ERROR "Cannot Open File"
#define READ "r"
#define WRITE "w"
#define MENU_STR "==========================\nSelect:\n\n           1. Read City information from file.\n           2. Show all Kindergartens.\n           3. Show a specific Kindergarten.\n           4. Save City information to file.\n           5. Add a Kindergarten.\n           6. Add a Child.\n           7. Birthday to a Child\n           8. Count Hova children\n           0. Exit\n"

void readCity(City* city) {
	FILE* f = fopen(FILE_NAME, READ);
	if (f) {
		City* newCity = readCityFromFile(f);
		*city = *newCity;
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

