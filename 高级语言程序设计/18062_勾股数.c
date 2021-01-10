#include <stdio.h>
#include <string.h>
#include <math.h>

int main() {
	
	int n;
	scanf("%d", &n);
	
	for (int i = 3; i <= n; i++) {
		for (int j = i; j <= n; j++) {
			for (int k = j; k <= n; k++) {
				if (i * i + j * j == k * k) {
					printf("%d %d %d\n", i, j, k);
				}
			}
		}
	}
	
	return 0;
}
