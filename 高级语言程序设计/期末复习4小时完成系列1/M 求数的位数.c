#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main() {

	int x;
	scanf("%9d", &x);
	int count = 1;
	x /= 10;
	while (x) {
		x /= 10;
		count++;
	}
	printf("%d", count);
	
	return 0;
}



