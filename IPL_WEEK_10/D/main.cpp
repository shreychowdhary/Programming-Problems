#include<iostream>
#include<stdlib.h>

using namespace std;

int main() {
	int n,x;
	cin >> n >> x;
	int sum = 0;
	for (int i = 0; i < n; i++) {
		int tmp;
		cin >> tmp;
		sum += tmp;
	}
	cout << (abs(sum)/x + (sum%x != 0 ? 1 : 0));
}
