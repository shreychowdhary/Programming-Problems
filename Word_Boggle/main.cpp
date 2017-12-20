#include<iostream>
#include<string>
#include<vector>
#include<map>
#include<set>

using namespace std;

struct TrieNode {
	map<char, TrieNode *> children;

	bool isEndWord;
};

void insert(TrieNode *curNode, string key) {
	if(key.length() == 0) {
		return;
	}
	
	if (curNode->children.count(key[0]) == 0) {
		curNode->children.insert(pair<char,TrieNode*>(key[0],new TrieNode));
	}

	if (key.length() == 1) {
		curNode->children[key[0]]->isEndWord = true;
		return;
	} else {
		insert(curNode->children[key[0]],key.substr(1));
	}
}

void freeMemory(TrieNode *curNode) {
	for(map<char, TrieNode*>::iterator it = curNode->children.begin(); it != curNode->children.end(); it++) {
			freeMemory(it->second);
	}
	delete curNode;
}

void search(TrieNode *curNode, int x, int y, string key, vector< vector<char> > grid, set<string> &result) {
	if (grid[x][y] == -1) {
		return;
	}

	if (curNode->isEndWord) {
		result.insert(key+grid[x][y]);
	}

	char c = grid[x][y];
	grid[x][y] = -1;

	if (x-1 >= 0) {
		if(curNode->children.count(grid[x-1][y]) > 0) {
			search(curNode->children[grid[x-1][y]], x-1, y, key+c, grid, result);	
		}
		if (y-1 >= 0 && curNode->children.count(grid[x-1][y-1]) > 0) {
			search(curNode->children[grid[x-1][y-1]], x-1, y-1, key+c, grid, result);
		}
		if (y+1 < grid[0].size() && curNode->children.count(grid[x-1][y+1]) > 0) {
			search(curNode->children[grid[x-1][y+1]], x-1, y+1, key+c, grid, result);	
		}
	}
	if (x+1 < grid.size()) {
		if(curNode->children.count(grid[x+1][y]) > 0) {
			search(curNode->children[grid[x+1][y]], x+1, y, key+c, grid, result);	
		}
		if (y-1 >= 0 && curNode->children.count(grid[x+1][y-1]) > 0)  {
			search(curNode->children[grid[x+1][y-1]], x+1, y-1, key+c, grid, result);
		}
		if (y+1 < grid[0].size() && curNode->children.count(grid[x+1][y+1]) > 0)  {
			search(curNode->children[grid[x+1][y+1]], x+1, y+1, key+c, grid, result);	
		}
	}
	if (y-1 >= 0 && curNode->children.count(grid[x][y-1]) > 0)  {
		search(curNode->children[grid[x][y-1]], x, y-1, key+c, grid, result);	
	}
	if (y+1 < grid[0].size() && curNode->children.count(grid[x][y+1]) > 0) {
		search(curNode->children[grid[x][y+1]], x, y+1, key+c, grid, result);	
	}
}

void printNodes(TrieNode* curNode) {
	for(map<char,TrieNode*>::iterator it = curNode->children.begin(); it!= curNode->children.end(); it++) {
		cout<<it->first<<endl;
		printNodes(it->second);
	}
}

int main() {
	int numTests;
	cin >> numTests;
	for (int i = 0; i < numTests; i++) {
		TrieNode *root = new TrieNode;
		int numWords;
		cin >> numWords;
		for (int i = 0; i < numWords; i++) {
			string tmp;
			cin >> tmp;
			insert(root, tmp);
		}
		int xSize,ySize;
		cin >> xSize >> ySize;
		
		vector< vector<char> > grid;

		for (int i = 0; i < xSize; i++) {
			vector<char> row(ySize);
			for (int j = 0; j < ySize; j++) {
				char c;
				cin >> c;
				row[j] = c;
			}
			grid.push_back(row);
		}
		set<string> results;

		for (int i = 0; i < xSize; i++) {
			for (int j = 0; j < ySize; j++) {
				if (root->children.count(grid[i][j]) > 0) {
					search(root->children[grid[i][j]], i, j, "", grid, results);
				}
			}
		}

		if(results.size() == 0) {
			cout << "-1";
		}

		for (set<string>::iterator it = results.begin(); it != results.end(); it++) {
			if(it != results.begin()) {
				cout << " ";
			}
			cout << *it;
		}
		cout<<endl;
		freeMemory(root); root = NULL;
	}

	return 0; 
}
