#include <stdio.h>
#include <string.h>
#include <math.h>

int main() {
	
	double a;
	scanf("%lf", &a);
	double x1 = a / 2.0;
	double x2 = 1.0 / 2 * (x1 + a / x1);
	while (fabs(x1 - x2) > 1e-5) {
		x1 = x2;
		x2 = 1.0 / 2 *(x1 + a / x1);
	}
	printf("%.4lf", x1);
	return 0;
}
