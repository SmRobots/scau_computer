#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main() {
	
	int n;
	scanf("%d", &n);
	// 打印上面四行 
	for (int i = 1; i <= n; i++) {
		for (int j = n - i; j >= 1; j--) {
			printf(" ");
		}
		int j;
		for (j = 1; j <= i; j++) {
			printf("%d", j);
		}
		// j从最大值开始-2，-2是因为最后多加了1 
		for (j = j - 2; j >= 1; j--) {
			printf("%d", j);
		}
		printf("\n");
	} 
	// 打印下面三行 
	for (int i = 1; i < n; i++) {
		for (int j = 1; j <= i; j++) {
			printf(" ");
		}
		int j;
		for (j = 1; j <= n - i; j++) {
			printf("%d", j);
		}
		for (j = j - 2; j >= 1; j--) {
			printf("%d", j);
		}
		printf("\n");
		
	}
	
	
	
	return 0;
}



