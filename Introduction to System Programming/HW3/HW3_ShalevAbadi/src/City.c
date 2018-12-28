/*
 * City.c
 *
 *  Created on: Dec 26, 2018
 *      Author: shale
 */

#include <stdio.h>
#include "City.h"
#include "Utilities.h"

void readCityFromFile(City* cityToRead, FILE* src) {
	if (cityToRead) {
		releaseKindergartenArr(cityToRead->kindergartensArr,
				cityToRead->numOfKindergartens);
		fscanf(src, "%d", &(cityToRead->numOfKindergartens));
		cityToRead->kindergartensArr = readKindergartensArrFromFile(
				cityToRead->numOfKindergartens, src);
	}
}

void writeCityToFile(City* cityToWrite, FILE* dst) {
	if (dst && cityToWrite) {
		fprintf(dst, "%d\n", cityToWrite->numOfKindergartens);
		writeKindergartenArrToFile(cityToWrite->kindergartensArr,
				cityToWrite->numOfKindergartens, dst);
	}
}

void showCityGartens(City* cityToPrint) {
	if (cityToPrint) {
		printKindergartensArr(cityToPrint->kindergartensArr,
				cityToPrint->numOfKindergartens);
	}
}

void addKindergartenToCity(City* dstCity, Kindergarten* kgToAdd) {
	if (dstCity && kgToAdd) {
		increaseCityKindergartens(dstCity);
		addKindergartenToCityArr(dstCity, kgToAdd);
	}
}

void increaseCityKindergartens(City* originCity) {
	if (originCity) {
		originCity->numOfKindergartens++;
		originCity->kindergartensArr = realloc(originCity->kindergartensArr,
				sizeof(Kindergarten*) * originCity->numOfKindergartens);
		if (!originCity->kindergartensArr) {
			printAllocationError();
		}
	}
}

void addKindergartenToCityArr(City* dstCity, Kindergarten* kgToAdd) {
	if (dstCity && kgToAdd) {
		dstCity->kindergartensArr[dstCity->numOfKindergartens - 1] = kgToAdd;
	}
}

Kindergarten* getKindergartenFromCity(City* cityToCheck, char* kgToSearch) {
	Kindergarten* res = NULL;
	if (cityToCheck && kgToSearch) {
		res = getKindergartenFromArr(cityToCheck->kindergartensArr,
				cityToCheck->numOfKindergartens, kgToSearch);
	}
	return res;
}

void releaseCity(City* cityToRelease) {
	if (cityToRelease) {
		releaseKindergartenArr(cityToRelease->kindergartensArr,
				cityToRelease->numOfKindergartens);
		free(cityToRelease);
	}
}
