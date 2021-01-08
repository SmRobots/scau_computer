#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>

void swap(int *p1, int *p2) {
	int temp;
	temp=*p1;
	*p1=*p2;
	*p2=temp;
}

int main() {

	int a,b;
	int *pa,*pb;
	scanf("%d%d", &a, &b);
	pa=&a;
	pb=&b;
	if(a<b) swap(pa, pb);
	printf("%d %d\n",a,b);

	return 0;
}



