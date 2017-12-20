#include<iostream>
#include<cmath>
using namespace std;

int main() {
	int n;
	cin >> n;
	for(int i = 0; i < n; i++) {
		int count = 0;
		int t;
		cin >> t;
		for(int j = 5; t/j>=1; j *= 5) {
			count += t/j;
		}
		cout << count << endl;
	}
	return 0;
}
