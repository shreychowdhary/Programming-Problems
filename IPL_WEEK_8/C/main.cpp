#include<iostream>
#include<string>

using namespace std;

int main () {
	int n;
	cin >> n;
	string alc[11] = {"ABSINTH", "BEER", "BRANDY", "CHAMPAGNE", "GIN", "RUM", "SAKE", "TEQUILA", "VODKA", "WHISKEY", "WINE"};
	int count = 0;
	for(int i = 0; i < 11; i++ ){
		string s;
		cin >> s;
		if (s[0] >= '0' && s[0] <= '9') {
			for(int j = 0; j < 11; j++ ){
				if(s == alc[i]) {
					count++;
				}
			}
		} else {
			int age = stoi(s);
			if(age < 18) {
				count++;
			}
		}

	}
	cout << count;

}
