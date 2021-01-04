#include <stdio.h>

int main() {
	
	double radius;
	scanf("%lf", &radius);
	double area = radius * radius * 3.14159;
	printf("%.2lf", area);
		
	return 0;
}
