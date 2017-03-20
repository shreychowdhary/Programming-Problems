import java.io.*;
import java.util.*;
/*
ID:shrey.c1
LANG:JAVA
TASK:castle
*/
class room{
	boolean visited;
	int[] connections = {-1,1,1,-1};//if no wall set pos of room nearby if wall set 0
	boolean[] walls = new boolean[4]; //0 top 1 right 2 bottom 3 left
	int x,y;
	public int size;
	public int id;
	public room(int wallNum,int xpos, int ypos){
		x = xpos;
		y = ypos;
		if(wallNum%2 != 0){
			walls[3] = true;
			connections[3] = 0;
		}
		if(wallNum >= 8){
			walls[2] = true;
			connections[2] = 0;
		}
		if(walls[2] && wallNum >= 12){
			walls[1] = true;
			connections[1] = 0;
		}
		else if(!walls[2] && wallNum >=4){
			walls[1] = true;
			connections[1] = 0;
		}
		if(walls[2] && walls[1] && wallNum >=14){
			walls[0] = true;
			connections[0] = 0;
		}
		else if(walls[2] && !walls[1] && wallNum >= 10){
			walls[0] = true;
			connections[0] = 0;
		}
		else if(!walls[2] && walls[1] && wallNum >= 6){
			walls[0] = true;
			connections[0] = 0;
		}
		else if(!walls[2] && !walls[1] && wallNum >= 2){
			walls[0] = true;
			connections[0] = 0;
		}
	}
}

public class castle {
	static ArrayList<room> notVisited;
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("castle.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("castle.out")));
		int m,n;
		StringTokenizer st = new StringTokenizer(f.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		notVisited = new ArrayList<room>();
		room[][] rooms = new room[n][m];
		for(int i = 0; i < n; i++){
			st = new StringTokenizer(f.readLine());
			for(int j = 0; j < m; j++){
				rooms[i][j] = new room(Integer.parseInt(st.nextToken()),j,i);
				notVisited.add(rooms[i][j]);
			}
		}
		int roomCount = 0;
		int maxRoom = 0;
		while(notVisited.size()>0){			
			ArrayList<room> temp = new ArrayList<room>();
			int size = flood(notVisited.get(0).y,notVisited.get(0).x,rooms,temp);
			if(size > maxRoom){
				maxRoom = size;
			}
			for(room r : temp){
				r.size = size;
				r.id = roomCount;
			}
			roomCount++;
		}
		out.println(roomCount);
		out.println(maxRoom);
		
		int maxAdd = 0, x = 0 ,y = 0;
		String NE = "";
		
		for(int i = 0; i < n; i++){
			for(int j = m-1; j >= 0; j--){
				if(i < n-1){
					//System.out.println(y + " " + x + " " + i + " "+ j + " " + maxAdd + " " + (rooms[i][j-1].size + rooms[i][j].size));
					controlOne : if(maxAdd <= rooms[i+1][j].size + rooms[i][j].size && rooms[i+1][j].id != rooms[i][j].id){
						if(maxAdd == rooms[i+1][j].size + rooms[i][j].size && j > x){
							break controlOne;
						}
						maxAdd = rooms[i+1][j].size + rooms[i][j].size;
						x = j;
						y = i+1;
						NE = "N";
					}
				}
				controlTwo : if(j > 0){
					if(maxAdd <= rooms[i][j-1].size + rooms[i][j].size && rooms[i][j-1].id != rooms[i][j].id){
						if(maxAdd == rooms[i][j-1].size + rooms[i][j].size && j-1 > x){
							break controlTwo;
						}
						maxAdd = rooms[i][j-1].size + rooms[i][j].size;
						if(j-1 == x && y == i && NE == "N"){
							break controlTwo;
						}
						else{
							NE = "E";
						}
						x = j-1;
						y = i;
						
						
					}
				}
			}
		}
		
		out.println(maxAdd);
		out.println((y + 1)  + " " + (x + 1) + " " + NE);
		out.close();
	}
	
	public static int flood(int ypos,int xpos,room[][] rooms,ArrayList<room> subRooms){
		int value = 1;
		rooms[ypos][xpos].visited = true;
		subRooms.add(rooms[ypos][xpos]);
		notVisited.remove(rooms[ypos][xpos]);
		for(int i = 0; i < 4; i++){
			if(i%2 == 0 && !rooms[ypos+rooms[ypos][xpos].connections[i]][xpos].visited){
				value += flood(ypos+rooms[ypos][xpos].connections[i],xpos,rooms,subRooms);
			}
			else if(i%2 == 1 && !rooms[ypos][xpos+rooms[ypos][xpos].connections[i]].visited){
				value += flood(ypos,xpos+rooms[ypos][xpos].connections[i],rooms,subRooms);
			}
		}
		return value;
	}

}
