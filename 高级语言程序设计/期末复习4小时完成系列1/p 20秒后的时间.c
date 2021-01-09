#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main() {

	int h, m, s;
	scanf("%d:%d:%d", &h, &m, &s);
	s += 20;
	m += s / 60;
	s %= 60;
	h += m / 60;
	m %= 60;
	h %= 24;
	printf("%0.2d:%0.2d:%0.2d", h,m,s);
	
	return 0;
}



