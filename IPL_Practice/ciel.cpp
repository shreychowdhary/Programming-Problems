#include <iostream>
#include <string>
using namespace std;

int main(){
	int a,b;
	cin >>a>>b;
	string d = to_string(a-b);
	if(d[d.length()-1] != '1'){
		d[d.length()-1] = '1';
	}else{
		d[d.length()-1] = '2';
	}
	cout<<d<<endl;
	return 0;
}
