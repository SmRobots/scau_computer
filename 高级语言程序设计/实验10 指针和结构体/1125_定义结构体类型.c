#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>

struct student{
	char name[10];
	char sex;
	int num;
	float score;
};

int main() {

	struct  student stu;
    gets(stu.name);
    scanf("%c",  &stu.sex);
    scanf("%d",  &stu.num);
    scanf("%f",  &stu.score);
    printf("%s\n", stu.name);
    printf("%c\n", stu.sex);
    printf("%d\n", stu.num);
    printf("%f\n", stu.score);

	return 0;
}



