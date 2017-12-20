#include<iostream>
#include<string>
#include<vector>
#include<utility>

using namespace std;

int turn(int face, int dir) {
	return (((face+dir)%4)+4)%4;
}

bool dfs(vector<int> segments, int index, int sum, int val) {
	if(index == segments.size()) {
		return sum == val;
	}
	return dfs(segments,index+1,sum+segments[index],val) || dfs(segments,index+1,sum-segments[index],val);
}

int main() {
	string s;
	cin >> s;
	int x,y;
	cin >> x >> y;
	vector<int> x_segments;
	vector<int> y_segments;
	int count = 0;
	bool face_x = true;

	for(int i = 0; i < s.length(); i++) {
		if(s[i] == 'T') {
			if(face_x){
				x_segments.push_back(count);
			} else {
				y_segments.push_back(count);
			}
			face_x = !face_x;
			count = 0;
		} else {
			count++;
		}
	}
	if(face_x){
		x_segments.push_back(count);
	} else {
		y_segments.push_back(count);
	}
	
	bool ans = dfs(x_segments,0,0,x) && dfs(y_segments,0,0,y);
	if(ans) {
		cout << "Yes";
	} else {
		cout << "No";
	}
}
