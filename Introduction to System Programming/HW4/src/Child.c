#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "Child.h"
#include "General.h"


/**************************************************/
/*             Read a Child from a file           */
/**************************************************/
void readChild(FILE* fp, Child* pChild)
{
	//Child ID
	fscanf(fp, "%d", &pChild->id);
	fscanf(fp, "%d", &pChild->age);
}


/**************************************************/
/*            show a Child				           */
/**************************************************/
void showChild(const Child* pChild)
{
	printf("\nID:%d  ", pChild->id);
	printf("Age:%d  ", pChild->age);
}


/**************************************************/
void getChildFromUser(Child* pChild, int id)
/**************************************************/
/**************************************************/
{
	pChild->id = id;
	
	puts("\nAge:\t");
	scanf("%d", &pChild->age);
}


/**************************************************/
/*Write a Child to the open file				*/
/**************************************************/
void writeChild(FILE* fp,const Child* pChild)
{
	fprintf(fp,"%d %d\n",pChild->id, pChild->age);
}

//linear search
int	findChildById(Child** pChildList, int count, int id)
{
	int i;
	for (i = 0; i < count; i++)
	{
		if (pChildList[i]->id == id)
			return i;
	}
	return -1;
}

void birthday(Child* pChild)
{
	pChild->age++;
}

//void	releaseChild(Child* pChild)
//{
//	//nothing to release
//}
