/*
 * LinkedList.c
 *
 *  Created on: Jan 10, 2019
 *      Author: shale
 */

#include <stdio.h>
#include <stdlib.h>
#include "General.h"
#include "LinkedList.h"

int initLinkedList(LIST* listToInit) {
	if (listToInit == NULL) {
		return 0;
	}
	listToInit->head.next = NULL;
	return 1;
}

NODE* insertToLinkedList(NODE* nodeToInsertAfter, DATA valueToInsert) {
	NODE* tempNode;

	if (!nodeToInsertAfter) {
		return NULL;
	}

	tempNode = (NODE*) malloc(sizeof(NODE));

	if (!checkAllocation(tempNode)) {
		return NULL;
	}
	tempNode->key = valueToInsert;
	tempNode->next = nodeToInsertAfter->next;
	nodeToInsertAfter->next = tempNode;
	return tempNode;
}

int deleteFromLinkedList(NODE* nodeToDelete) {
	NODE* tmp;

	if (!nodeToDelete || !(tmp = nodeToDelete->next)) {
		return 0;
	}

	nodeToDelete->next = tmp->next;
	free(tmp);
	return 1;
}

NODE* findInLinkedList(NODE* startNode, DATA valueToFind,
		int (*equal)(const void*, const void*)) {
	NODE* tmpNode;

	if (!startNode) {
		return NULL;
	}
	tmpNode = startNode;

	while ((tmpNode != NULL) && (equal(tmpNode->key, valueToFind) != 1)) {
		tmpNode = tmpNode->next;
	}
	return tmpNode;
}

int freeLinkedList(LIST* listToFree) {
	NODE *tmp;

	if (!listToFree) {
		return 0;
	}
	for (tmp = &(listToFree->head); deleteFromLinkedList(tmp);)
		;
	return 1;
}

int printLinkedList(LIST* listToPrint, void (*print)(const Garden*)) {
	NODE *tmp;
	int c = 0;
	if (!listToPrint) {
		return 0;
	}
	printf("\n");
	for (tmp = (NODE*) listToPrint; tmp; tmp = tmp->next, c++) {
		print(tmp->key);
		printf("\n\t|\n\t|\n\tV\n");
	}
	printf("\tNULL\n");
	return c;
}
