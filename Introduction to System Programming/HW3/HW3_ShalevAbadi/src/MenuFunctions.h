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
void readCity(City* city);
void showCityGardens(City* city);
void showSpecificGardenInCity(City* city);
void saveCity(City* city);
void cityAddGarden(City* city);
void addChildToSpecificGardenInCity(City* city);
void birthdayToChild(City* city);
int countChova(City* city);
void ReleaseCity(City* city);

#endif /* MENUFUNCTIONS_H_ */
