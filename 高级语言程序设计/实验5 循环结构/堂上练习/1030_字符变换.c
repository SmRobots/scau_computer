#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main() {
	
	char str[80];
	gets(str);
	int i = 0;
	while (str[i] !='\0') {
		if (str[i] >= 'A' && str[i] <= 'Z') {
			str[i] += 32;
		}
		i++;
	}
	printf("%s", str);
	
	return 0;
}
