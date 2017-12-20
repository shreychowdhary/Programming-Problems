#include<iostream>
#include<vector>
using namespace std;

int main() {
	int n,m;
	cin >> n >> m;
	bool b[m];

	for(int i = 0; i < m; i++) {
		b[i] = false;
	}
	for(int i = 0; i < n; i++) {
		int l;
		cin >> l;
		for(int j = 0; j < l; j++) {
			int t; 
			cin >> t;
			b[t-1] = true;
		}
	}

	for(int i = 0; i < m; i++) {
		if(b[i] == false) {
			cout << "NO";
			return 0;
		}
	}

	cout << "YES";
	return 0;
}

