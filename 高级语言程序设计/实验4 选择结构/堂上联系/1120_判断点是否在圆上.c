#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main() {
	
	double x, y;
	scanf("%lf,%lf", &x, &y);
	double distance = sqrt(pow(x, 2) + pow(y, 2));
	if (fabs(distance - 1) <= 0.001) {
		printf("Y");
	} else {
		printf("N");
	}
	
	return 0;
}
