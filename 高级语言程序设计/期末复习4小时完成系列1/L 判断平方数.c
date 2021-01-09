#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main() {

	int x;
	scanf("%d", &x);
	int temp = (int)sqrt(x);
	if (temp * temp == x) {
		printf("Y");
	} else {
		printf("N"); 
	}
	
	
	return 0;
}



