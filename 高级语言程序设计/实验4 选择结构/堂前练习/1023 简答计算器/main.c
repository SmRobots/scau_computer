#include <stdio.h>
#include <stdlib.h>

int main() {
	
	float a, b, c;
	char op;
	scanf("%f%c%f", &a, &op, &b);
	switch(op) {
		case '+':
			c = a + b;
			break;
		case '-':
			c = a - b;
			break;
		case '*':
			c = a * b;
			break;
		case '/':
			c = a / b;
			break;
		default:
			printf("error");
			exit(0);
	}
	printf("result=%.2f", c);
	
	return 0;
}
