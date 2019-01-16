#include <stdio.h>
#include <stdlib.h>
#include "General.h"
#include "City.h"

void readCity(City* pCity, int useBinaryFormat) {
	if (pCity->pGardenList != NULL) {
		releaseCity(pCity);
		pCity->count = 0;
	}

	pCity->pGardenList = readAllGardensFromFile(
			useBinaryFormat ? DATA_FILE_BIN : DATA_FILE, &pCity->count,
			useBinaryFormat);

	if (pCity->pGardenList == NULL)
		printf("Error reading city information\n");
}

void showCityGardens(City* pCity) {
	showAllGardens(pCity->pGardenList, pCity->count);
}

void showSpecificGardenInCity(City* pCity) {
	showGardenMenu(pCity->pGardenList, pCity->count);
}

void saveCity(City* pCity, int useBinaryFormat) {
	writeGardensToFile(pCity->pGardenList, pCity->count,
			useBinaryFormat ? DATA_FILE_BIN : DATA_FILE, useBinaryFormat);
}

void cityAddGarden(City* pCity) {
	pCity->pGardenList = addGarden(pCity->pGardenList, &pCity->count);
	if (pCity->pGardenList == NULL) //Allocation error
		printf("Error adding kindergarten\n");
}

void addChildToSpecificGardenInCity(City* pCity) {
	addChildToGarden(pCity->pGardenList, pCity->count);
}

void birthdayToChild(City* pCity) {
	handleBirthdayToChild(pCity->pGardenList, pCity->count);
}

int countChova(City* pCity) {
	int i;
	int count = 0;
	for (i = 0; i < pCity->count; i++) {
		if (pCity->pGardenList[i]->type == Chova)
			count += pCity->pGardenList[i]->childCount;
	}
	return count;
}

void sortCityKindergartensByName(City* cityToSort) {
	sortKindergartensArrByName(cityToSort->pGardenList, cityToSort->count);
}

void sortCityKindergartenKidsByID(City* cityToSort) {
	sortKindergatensArrChildren(cityToSort->pGardenList, cityToSort->count);
}

void sortCityKindergartensByTypeAndChildrenCount(City* cityToSort) {
	sortKindergartenArrByTypeAndChildrenCount(cityToSort->pGardenList,
			cityToSort->count);
}

void releaseCity(City* pCity) {
	release(pCity->pGardenList, pCity->count);
}

void kindergartenLinkedList(City* pCity) {
	GardenType kindergartenType;
	LIST* pList = (LIST*)malloc(sizeof(LIST));
	if (checkAllocation(pList)) {
		printf("%s", KG_LINKED_LIST_STR);
		scanf("%u", &kindergartenType);
		*pList = initKindergartenListByType(pCity, kindergartenType);
		showKindergartenList((LIST*) pList->head.next);
		freeLinkedList(pList);
	}
}

LIST initKindergartenListByType(City* pCity, int type) {
	int i;
	LIST kindergartenList;
	NODE* pNode;
	initLinkedList(&kindergartenList);
	pNode = &kindergartenList.head;
	for (i = 0; i < pCity->count; i++) {
		if (pCity->pGardenList[i]->type == type) {
			pNode = insertToLinkedList(pNode, pCity->pGardenList[i]);
		}
	}
	return kindergartenList;
}

void showKindergartenList(LIST* pList)
{
    printLinkedList(pList, showGarden);
}
