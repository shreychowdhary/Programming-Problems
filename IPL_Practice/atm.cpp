#include <iostream>
#include<cstdio>
using namespace std;

int main(){
	int w;
	float b;
	cin >> w >> b;
	if(b-w >= .5 && w%5 == 0){
		printf("%.2f\n",b-w-.5);
	}else{
		printf("%.2f\n",b);
	}
}
