#include<iostream>
#include<string>
#include<algorithm>

using namespace std;

int main() {
	string s,t;
	cin >> s >> t;
	sort(s.begin(),s.end());
	sort(t.begin(),t.end());
	reverse(t.begin(),t.end());
	bool ans = s < t;
	if (ans) {
		cout << "Yes";
	} else {
		cout << "No";
	}
}
