#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main() {
	
	
	int n;
	scanf("%d", &n);
	double sum = 0;
	// a 表示分子，b表示分母 
	double a = 2, b = 1, temp;
	int count = 1;
	while (count <= n) {
		sum += a / b;
		temp = a;
		a = a + b;
		b = temp;
		count++;
	}
	printf("%.4lf", sum); 
	return 0;
}
