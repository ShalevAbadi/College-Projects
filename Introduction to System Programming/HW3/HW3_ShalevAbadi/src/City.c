/*
 * City.c
 *
 *  Created on: Dec 26, 2018
 *      Author: shale
 */

#include <stdio.h>
#include "City.h"
#include "Kindergarten.h"

#define KG_NOT_EXIST_STR "no such kindergarten\n"
#define SEARCH_KG_NAME_STR "Give me kindergarten name:\n"
#define CHILD_NOT_FOUND "No such child\n"

City* readCityFromFile(FILE* src) {
	City* newCity = (City*) malloc(sizeof(City));
	fscanf(src, "%d", &(newCity->numOfKindergartens));
	newCity->kindergartensArr = readKindergartensArrFromFile(
			newCity->numOfKindergartens, src);
	return newCity;
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

void cityAddGarden(City* cityToAdd) {
	Kindergarten* newKg = initKindergartenFromUserIfNotExist(
			cityToAdd->kindergartensArr, cityToAdd->numOfKindergartens);
	if (newKg) {
		addKindergartenToCity(cityToAdd, newKg);
	}
}

void writeCityToFile(City* cityToWrite, FILE* dst) {
	fprintf(dst, "%d\n", cityToWrite->numOfKindergartens);
	writeKindergartenArrToFile(cityToWrite->kindergartensArr,
			cityToWrite->numOfKindergartens, dst);
}

void showCityGartens(City* cityToPrint) {
	printKindergartensArr(cityToPrint->kindergartensArr,
			cityToPrint->numOfKindergartens);
}

void addKindergartenToCity(City* dstCity, Kindergarten* kgToAdd) {
	increaseCityKindergartens(dstCity);
	addKindergartenToCityArr(dstCity, kgToAdd);
}

void increaseCityKindergartens(City* dstCity) {
	dstCity->numOfKindergartens++;
	dstCity->kindergartensArr = realloc(dstCity->kindergartensArr,
			dstCity->numOfKindergartens);
}

void addKindergartenToCityArr(City* dstCity, Kindergarten* kgToAdd) {
	dstCity->kindergartensArr[dstCity->numOfKindergartens - 1] = kgToAdd;
}

Kindergarten* getKindergartenFromCity(City* cityToCheck, char* kgToSearch) {
	return getKindergartenFromArr(cityToCheck->kindergartensArr,
			cityToCheck->numOfKindergartens, kgToSearch);
}

void releaseCity(City* cityToRelease) {
	releaseKindergartenArr(cityToRelease->kindergartensArr,
			cityToRelease->numOfKindergartens);
	free(cityToRelease);
}
