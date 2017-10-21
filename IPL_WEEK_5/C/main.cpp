#include<iostream>
#include<string>
using namespace std;

int main() {
	string a,b;
	cin >> a >> b;
	int aint = stoi(a);
	int bint = stoi(b);
	string c = to_string(aint + bint);
	string aAlt = "";
	string bAlt = "";
	string cAlt = "";
	for(int i = 0; i < a.length(); i++){
		if(a[i] != '0'){
			aAlt.push_back(a[i]);
		}
	}


	for(int i = 0; i < b.length(); i++){
		if(b[i] != '0'){
			bAlt.push_back(b[i]);
		}
	}

	for(int i = 0; i < c.length(); i++){
		if(c[i] != '0'){
			cAlt.push_back(c[i]);
		}
	}
	int one = stoi(aAlt);
	int two = stoi(bAlt);
	int three = stoi(cAlt);
	//cout << one << " " << two << " " <<three<<endl;
	if(one + two == three) {
		cout<<"YES"<<endl;
	}
	else {
		cout<<"NO"<<endl;
	}
	return 0;
}
