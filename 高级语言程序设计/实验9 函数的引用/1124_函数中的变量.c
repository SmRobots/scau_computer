#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>

int f1(int x)
{ 	
// 声明为静态变量的值可以看成是全局作用域
    static int z=3,y=0;
  	y++;
  	z++;
  	return(x+y+z);
}

int main() {

	int a=1,k;
  	for(k=0;k<3;k++) printf("%4d",f1(a));
	//printf("   6   8  10");
	return 0;
}



