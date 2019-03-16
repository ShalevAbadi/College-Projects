/*
 * LinkedList.h
 *
 *  Created on: Jan 10, 2019
 *      Author: shale
 */

#ifndef LINKEDLIST_H_
#define LINKEDLIST_H_

#include "Kindergarten.h"

typedef void* DATA;

typedef struct node
{
    DATA			key;
    struct node*	next;
}NODE;

typedef struct
{
    NODE head;
}LIST;

int initLinkedList(LIST* pList);

NODE* insertToLinkedList(NODE* pNode, DATA Value);

int deleteFromLinkedList(NODE* pNode);

NODE* findInLinkedList(NODE* pNode, DATA Value, int(*equal)(const void*, const void*));

int freeLinkedList(LIST* pList);

int printLinkedList(LIST* pList, void(*print)(const Garden*));

#endif

