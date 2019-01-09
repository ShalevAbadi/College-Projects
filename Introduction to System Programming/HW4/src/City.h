#ifndef __CITY__
#define __CITY__

#include "Kindergarten.h"

#define DATA_FILE "DataFile.txt"
#define DATA_FILE_BIN "DataFile.bin"

typedef struct
{
	Garden** pGardenList;
	int count;
}City;


void	readCity(City* pCity, int useBinaryFormat);
void	showCityGardens(City* pCity);
void	showSpecificGardenInCity(City* pCity);
void	saveCity(City* pCity, int useBinaryFormat);
void	cityAddGarden(City* pCity);
void	addChildToSpecificGardenInCity(City* pCity);
void	birthdayToChild(City* pCity);
int		countChova(City* pCity);
void	releaseCity(City* pCity);

void sortCityKindergartensByName(City* cityToSort);
void sortCityKindergartenKidsByID(City* cityToSort);
void sortCityKindergartensByTypeAndChildrenCount(City* cityToSort);

#endif
