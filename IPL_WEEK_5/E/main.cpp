#include<iostream>
#include<string>
#include<vector>

using namespace std;

int main() {
	int n;
	cin >> n;
	vector<string> names;
	for(int i = 0; i < n; i++){
		string tmp;
		cin>>tmp;
		cout<<tmp<<endl;
		names.push_back(tmp);
		//names.push_back(tmp);
	}
	cout<<names.size();
	/*int min = 10000;
	for(int i = 0; i < names.size(); i++) {
		int count = 0;
		cout<<names[i];
		for(int j = 0; j < names.size(); j++){
			if(i==j){
				continue;
			}
			string tmp = names[j];
			while(names[i].compare(tmp)!=0){
				char c = tmp[0];
				tmp.erase(0);
				tmp.push_back(c);
				count++;
			}
			cout<<count<<endl;
		}
		if(count < min){
			min = count;
		}
	}
	cout<<min<<endl;*/
	return 0;
}
