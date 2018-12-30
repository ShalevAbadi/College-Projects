/*
 * Kindergarten.h
 *
 *  Created on: Dec 26, 2018
 *      Author: shale
 */

#ifndef KINDERGARTEN_H_
#define KINDERGARTEN_H_

#include <stdio.h>
#include <string.h>
#include "Child.h"

#define KINDERGARTEN_NAME_MAX_LEN 100

#define NUM_OF_ENUM_TYPES 3
typedef enum {
	CHOVA, TROM_CHOVA, TROM_TROM_CHOVA
} kindergartenType;

typedef struct {
	char* name;
	kindergartenType type;
	Child** children;
	int numOfChildren;
} Kindergarten;

Kindergarten* initKindergarten(char* kgName, kindergartenType kgType,
		Child** childrenArr, int kgNumOfChildren);
int isValidType(kindergartenType check);
void increaseKindergartenNumOfChildren(Kindergarten* dstKg);
void addChildToKindergartenArr(Kindergarten* dstKg, Child* childToAdd);
int isKindergartenInArr(Kindergarten** arrToSearch, int size,
		char* kgToSearchName);
Kindergarten* getKindergartenFromArr(Kindergarten** arrToSearch, int size,
		char* kgToSearchName);
int isEqualNames(char* name1, char* name2);
Kindergarten** readKindergartensArrFromFile(int size, FILE* src);
Kindergarten* readKindergartenFromFile(FILE* src);
char* readKindergartenNameFromFile(FILE* src);
void printKindergartensArr(Kindergarten** kgArr, int size);
void printKindergarten(Kindergarten* kgToPrint);
void writeKindergartenArrToFile(Kindergarten** arrToWrite, int size, FILE* dst);
void writeKindergartenToFile(Kindergarten* kgToWrite, FILE* dst);
void releaseKindergartenArr(Kindergarten** arrToFree, int size);
void releaseKindergarten(Kindergarten* kgToRelease);

#endif /* KINDERGARTEN_H_ */
