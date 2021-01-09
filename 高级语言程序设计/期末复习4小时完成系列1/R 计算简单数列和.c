#include <stdio.h>
#include <stdlib.h>
#include <math.h>


int main() {

	int n;
	scanf("%d", &n);
	long long sum = n + n * (n - 1);
	printf("%ld", sum);
	return 0;
}



