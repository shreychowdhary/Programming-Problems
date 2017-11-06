#include<iostream>
using namespace std;

int main() {
	int n;
	cin >> n;
	int val = 0;
	for(int i = 1; ;i++) {
		val = (i * (i+1))/2;
		if(val > n) {
			cout << "NO";
			break;
		} else if(val == n) {
			cout << "YES";
			break;
		}
	}

	return 0;
}
