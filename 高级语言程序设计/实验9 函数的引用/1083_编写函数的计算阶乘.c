#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>

// fn = n * (n - 1) * (n - 2) * ... * 1
long long fanc(int n) {
	if (n == 1) {
		return 1;
	}
	return n * fanc(n - 1);
}

int main() {

	int n;
    scanf("%d", &n);
    printf("%ld", fanc(n));
	
	return 0;
}



