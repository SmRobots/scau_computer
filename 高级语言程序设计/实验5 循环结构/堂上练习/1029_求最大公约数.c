#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main() {
	
	int n,m;
	scanf("%d,%d",&n, &m);
	int temp;
	if (n < m) {
		// 另n为更大的那个值 
		temp = n;
		n = m;
		m = temp;
	}
	// 模数和余数 
	int mod_n = n % m, div_n = n / m;
  // 使用辗转相除法计算最大公约数
	while (mod_n) {
		n = m;
		m = mod_n;
		mod_n = n % m;
		div_n = n / m;
	}
	printf("%d", m);
	
		
	return 0;
}



