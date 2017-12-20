#include<iostream>
#include<string>

using namespace std;

int main() {
	string s;
	cin >> s;
	int groups = 1;
	char prev = 'E';
	for(int i = 0; i < s.length(); i++) {
		if(prev != 'E' && prev !=s[i]) {
			groups++;
		}
		prev = s[i];
	}
	groups--;
	cout << groups; 

	return 0;
}
