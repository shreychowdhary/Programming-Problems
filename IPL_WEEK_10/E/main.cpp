#include<iostream>
#include<map>

using namespace std;

int main() {
	int n,k;
	cin >> n >> k;
	map<int,int> vals;
	for (int i = 0; i < n; i++) {
		int a,b;
		cin >> a >> b;
		if (vals.count(a) == 0) {
			vals.insert(pair<int,int>(a,b));
		} else {
			vals[a] = vals[a] + b;
		}
	}
	int sum = 0;
	for (map<int,int>::iterator it = vals.begin(); it != vals.end(); ++it) {
		sum += it->second;
		if (sum  >= k) {
			cout << it->first;
			return 0;
		}
	}
}
