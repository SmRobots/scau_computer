#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main() {
	
	int x;
	scanf("%d", &x);
	int sqrt_x = (int)sqrt(x);
	if (sqrt_x * sqrt_x == x) {
		printf("Y");
	} else {
		printf("N");
	}
	
	return 0;
}
