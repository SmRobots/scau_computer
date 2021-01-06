#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main() {
	
	int x;
	scanf("%d", &x);
	if (x < 0 || x > 100) {
		printf("error");
	}
	if (x >= 90 && x <= 100) {
		printf("A");
	}
	if (x >= 80 && x < 89) {
		printf("B");
	}
	if (x >= 70 && x < 79) {
		printf("C");
	}
	if (x >= 60 && x < 69) {
		printf("D");
	}
	if (x >= 0 && x < 60) {
		printf("E");
	}
	
	return 0;
}



