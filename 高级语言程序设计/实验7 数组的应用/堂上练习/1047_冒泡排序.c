#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main() {

	int a[10], i, j, t;
	for(i=0; i<10; i++)
		scanf("%d", a + i) ;
	for(i = 0; i < 10 - 1; i++) { // i < n - 1
		for(j=0; j< 10 - i - 1; j++)  // j < n - i - 1
			if (a[j] > a[j + 1]) {
				t = a[j];
				a[j] = a[j + 1];
				a[j + 1] = t; 
			}
	}
	for(i=0; i<10; i++)
		printf("%d ",a[i]);

	return 0;
}



