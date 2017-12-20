#include<iostream>
#include<string>
using namespace std;

int main() {
	string s;
	cin >> s;
	int numSmall = 0;
	int numDig = 0;
	int numBig = 0;
	
	for(int i = 0; i < s.length(); i++) {
		if( 'a' <= s[i] && 'z' >= s[i]) {
			numSmall++;
		}
		else if('A' <= s[i] && 'Z' >= s[i]) {
			numBig++;
		} 
		else if('0' <= s[i] && '9' >= s[i]) {
			numDig++;
		}
	}

	if(s.length() >= 5 && numSmall > 0 && numDig > 0 && numBig>0) {
		cout <<"Correct"<<endl;
	} 
	else {
		cout << "Too weak"<<endl;
	}

	return 0;
}
