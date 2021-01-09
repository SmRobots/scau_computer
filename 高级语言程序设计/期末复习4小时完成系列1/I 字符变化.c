#include <stdio.h>
#include <stdlib.h>
#include <math.h>


int main() {

	char str[81];
	gets(str);
	for (int i = 0; str[i] != '\0'; i++) {
		if (str[i] >= 'A' && str[i] <= 'Z') {
			str[i] += 32;
		}
	}
	printf("%s", str);
	
	return 0;
}



