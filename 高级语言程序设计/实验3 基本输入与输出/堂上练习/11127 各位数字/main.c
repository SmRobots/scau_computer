#include <stdio.h>

int main() {
	
	int num;
	scanf("%3d", &num);
	int a = num / 100;
	int b = num % 10;
	printf("%d\n", a);
	printf("%d", b);
	return 0;
}
