#include <stdio.h>
#include <stdlib.h>
#include <math.h>


int main() {

	double a, b, temp;
	int n;
	scanf("%d", &n);
	double sum = 0;
	a = 2.0;
	b = 1.0;
	while (n) {
		sum += a / b;
		temp = a + b;
		b = a;
		a = temp;
		n--;
	}
	printf("%.4lf", sum);
	
	return 0;
}



