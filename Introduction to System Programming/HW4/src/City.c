#include <stdio.h>

#include "City.h"
#include "Kindergarten.h"


void readCity(City* pCity, int useBinaryFormat)
{
	if (pCity->pGardenList != NULL) {
		releaseCity(pCity);
		pCity->count = 0;
	}

	pCity->pGardenList = readAllGardensFromFile(useBinaryFormat ? DATA_FILE_BIN : DATA_FILE, &pCity->count, useBinaryFormat);

	if (pCity->pGardenList == NULL)
		printf("Error reading city information\n");
}

void	showCityGardens(City* pCity)
{
	showAllGardens(pCity->pGardenList, pCity->count);
}

void	showSpecificGardenInCity(City* pCity)
{
	showGardenMenu(pCity->pGardenList, pCity->count);
}

void saveCity(City* pCity, int useBinaryFormat)
{
	writeGardensToFile(pCity->pGardenList, pCity->count, useBinaryFormat ? DATA_FILE_BIN : DATA_FILE, useBinaryFormat);
}

void cityAddGarden(City* pCity)
{
	pCity->pGardenList = addGarden(pCity->pGardenList, &pCity->count);
	if (pCity->pGardenList == NULL)//Allocation error
		printf("Error adding kindergarten\n");
}

void addChildToSpecificGardenInCity(City* pCity)
{
	addChildToGarden(pCity->pGardenList, pCity->count);
}

void	birthdayToChild(City* pCity)
{
	handleBirthdayToChild(pCity->pGardenList, pCity->count);
}

int	countChova(City* pCity)
{
	int i;
	int count = 0;
	for (i = 0; i < pCity->count; i++)
	{
		if (pCity->pGardenList[i]->type == Chova)
			count += pCity->pGardenList[i]->childCount;
	}
	return count;
}

void	releaseCity(City* pCity)
{
	release(pCity->pGardenList, pCity->count);
}
