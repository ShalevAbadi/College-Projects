/*
 * MenuFunctions.h
 *
 *  Created on: Dec 27, 2018
 *      Author: shale
 */

#ifndef MENUFUNCTIONS_H_
#define MENUFUNCTIONS_H_
#include "City.h"

void readCity(City* city);
int menu();
void saveCity(City* city);
void showSpecificGardenInCity(City* city);
void cityAddGarden(City* cityToAdd);
void addChildToSpecificGardenInCity(City* city);
void birthdayToChild(City* city);
int countChova(City* city);
Kindergarten* initKindergartenFromUserIfNotExist(Kindergarten** arrToSearchIn,
		int size);
Kindergarten* getKgFromCityByUserInputPrintIfNotFound(City* cityToSearch);
Child* getChildFromCityByUserInputPrintIfNotFound(City* cityToSearchIn);
void addChildToKindergartenFromUser(Kindergarten* kgToAdd);
char* getKgNameFromUser(Kindergarten** arrToSearchIn, int size);
kindergartenType getKgTypeFromUser();
Kindergarten* getKindergartenFromArrByUserInput(Kindergarten** arrToSearch,
		int size);
Child** initChildrenArrFromUser(int numOfChildren);
int getNumOfChildrenFromUser();
Child* initChildFromUserIfNotExist(Child** arrToSearchIn, int size);
int addChildFromUserGetId(Child** arrToSearchIn, int size);
int getChildIdFromUser();
Child* searchChildInArrByUserInput(Child** arrToSearchIn, int size);

#endif /* MENUFUNCTIONS_H_ */
