/*
 * test.h
 *
 *  Created on: Jan 4, 2019
 *      Author: shale

#ifndef TEST_H_
#define TEST_H_

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "General.h"
#include "Kindergarten.h"
#include "child.h"

void printPassSign();
void printFailedSign();
int compareChildren(Child* child1, Child* child2);
int compareChildrenArr(Child** children1, int size1, Child** children2, int size2);
int compareKgs(Garden* kg1, Garden* kg2);
int test_readKindergatenBinary();
int test_childFromBinary();
int test_childToBinary();
int runAllTests();
int testWorking();

#endif /* TEST_H_ */

