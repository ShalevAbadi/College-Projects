#ifndef __CHILD__
#define __CHILD__

typedef unsigned char Byte;

typedef struct
{
	int	 id;
	int  age;
}Child;


void	readChild(FILE* fp, Child* pChild);
void	getChildFromUser(Child* pChild, int id);
void	showChild(const Child* pChild);
void	writeChild(FILE* fp,const Child* pChild);
int		findChildById(Child** pChildList, int count, int id);
void	birthday(Child* pChild);
//void	releaseChild(Child* pChild);


void writeChildrenArrBinary(FILE* fp, Child** arr, int size);
void writeChildBinary(FILE* fp,Child* pChild);
void childFromBinary(FILE* file, Child* res);
#endif
