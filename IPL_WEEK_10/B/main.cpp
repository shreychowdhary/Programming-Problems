#include<iostream>
#include<string>

using namespace std;

int main() {
	string s;
	cin >> s;
	string ans = "";
	for (int i = 0; i < s.length(); i++) {
		s[i] = tolower(s[i]);
		if(s[i] != 'a' && s[i] != 'o' && s[i] != 'y' && s[i] != 'e' && s[i] != 'u' && s[i] != 'i') {
			ans += ".";
			ans += s[i];
		}
	}
	cout << ans;
}
