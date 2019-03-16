/*
 * test.c
 *
 *  Created on: Jan 4, 2019
 *      Author: shale
 */

/*#include "test.h"

void printPassSign() {
	printf("V ");
}

void printFailedSign() {
	printf("X ");
}

int runAllTests() {
	return (test_childToBinary() && test_childFromBinary()
			&& test_readKindergatenBinary());
}

int test_readKindergatenBinary() {
	FILE* file = fopen("DataFile.bin", "rb");
	if (!file) {
		printFailedSign();
		printf("KG From binary");
		return 0;
	} else {
		fseek(file, sizeof(int), SEEK_SET);
		Garden* actual = (Garden*) malloc(sizeof(Garden));
		readKindergartenFromBinaryFile(file, actual);
		Garden* expect = (Garden*) malloc(sizeof(Garden));
		expect->childPtrArr = (Child**) malloc(
				sizeof(Child*) * expect->childCount);
		expect->childPtrArr[0] = (Child*) malloc(sizeof(Child));
		expect->name = strdup("Sunshine");
		expect->type = 0;
		expect->childCount = 1;
		expect->childPtrArr[0]->id = 1234;
		expect->childPtrArr[0]->age = 1234;
		int sucsses = compareKgs(expect, actual);
		if (sucsses) {
			printPassSign();
		} else {
			printFailedSign();
		}
		printf("Kindergarten From binary");
		free(actual);
		return sucsses;
	}
}

int compareChildren(Child* child1, Child* child2) {
	return (child1->id == child2->id) && (child1->age == child2->age);
}

int compareChildrenArr(Child** children1, int size1, Child** children2,
		int size2) {
	int i;
	if (size1 != size2) {
		return 0;
	}
	for (i = 0; i < size1; i++) {
		if (!compareChildren(children1[i], children2[i])) {
			return 0;
		}
	}
	return 1;
}

int compareKgs(Garden* kg1, Garden* kg2) {
	return strcmp(kg1->name, kg2->name) && kg1->type == kg2->type
			&& kg1->childCount == kg2->childCount
			&& compareChildrenArr(kg1->childPtrArr, kg1->childCount,
					kg2->childPtrArr, kg2->childCount);
}

int test_childToBinary() {
	printf("asdf");
	Child child = { 0x1F00, 0x1 };
	Byte expected[2];
	expected[0] = (Byte) 0x0;
	expected[1] = (Byte) 0x3F;
	Byte* actual = writeChildBinary(&child);
	int sucsses = expected[0] == actual[0] && expected[1] == actual[1];
	if (sucsses) {
		printPassSign();
	} else {
		printFailedSign();
	}
	printf("Child To Binary ");
	printf("expected: %d got: %d \n", expected[0] + expected[1],
			actual[0] + actual[1]);
	return sucsses;
}

int test_childFromBinary() {
	FILE* file = fopen("DataFile.bin", "rb");
	if (!file) {
		printFailedSign();
		printf("Child From binary");
		return 0;
	} else {
		fseek(file, sizeof(int) * 2 + 10, SEEK_SET);
		Child* actual = (Child*) malloc(sizeof(Child));
		childFromBinary(file, actual);
		Child expect = { 1234, 5 };
		Child*pExpect = &expect;
		int sucsses = pExpect->id == actual->id && pExpect->age == actual->age;
		if (sucsses) {
			printPassSign();
		} else {
			printFailedSign();
		}
		printf("Child From binary");
		printf("expected: { %d , %d } got: { %d , %d } \n", pExpect->id,
				pExpect->age, actual->id, actual->age);
		free(actual);
		return sucsses;
	}
}

int testWorking() {
	printPassSign();
	printf("Tests are working\n");
	return 1;
}
*/
