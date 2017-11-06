#include<iostream>
using namespace std;

int main() {
	int n,k,t;
	cin >> n >> k >> t;
	int sum = 0;
	int val = (int)(n * k * (t/100.0));
	for(int i = 0; i < n; i++) {
		if(val < k){
			cout << val << " ";
			val = 0;
		}
		else {
			cout << k << " ";
			val -= k;
		}
	}
	return 0;
}
