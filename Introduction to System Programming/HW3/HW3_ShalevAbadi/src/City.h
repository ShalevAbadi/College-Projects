/*
 * City.h
 *
 *  Created on: Dec 26, 2018
 *      Author: shale
 */

#ifndef CITY_H_
#define CITY_H_
#include "Kindergarten.h"

typedef struct {
	Kindergarten** kindergartensArr;
	int numOfKindergartens;
} City;

void readCityFromFile(City* cityToRead, FILE* src);
void writeCityToFile(City* cityToWrite, FILE* dst);
void showCityGartens(City* cityToPrint);
void increaseCityKindergartens(City* dstCity);
void addKindergartenToCity(City* dstCity, Kindergarten* kgToAdd);
void addKindergartenToCityArr(City* dstCity, Kindergarten* kgToAdd);
Kindergarten* getKindergartenFromCity(City* cityToCheck, char* kgToSearch);
void releaseCity(City* cityToRelease);

#endif /* CITY_H_ */
