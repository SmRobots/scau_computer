#include <stdio.h>
#include <string.h>

int main() {
	
	
	int n;
	scanf("%d", &n);
	
	double sum = 0, item = 100.0;
	while (n) {
		sum += 2 * item;
		item /= 2.0;
		n--;
	}
  // 第一次下落只有100米的距离
	sum -= 100;
	printf("%.3lf %.3lf", sum, item);
	return 0;
}
