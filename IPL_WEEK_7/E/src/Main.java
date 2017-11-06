import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Player[] players = new Player[4];
        for (int i = 0; i < 4; i++) {
            int a = in.nextInt();
            int d = in.nextInt();
            players[i] = new Player(a, d);
        }
        int team1Pos = 0;
        if (players[0].a > players[1].a && players[0].d > players[1].d) {
            team1Pos = -1;
        } else if (players[0].a < players[1].a && players[0].d < players[1].d) {
            team1Pos = -1;
        }
        else if (players[0].a > players[1].a && players[0].d < players[1].d) {
            team1Pos = 0;
        }
        if (players[0].a < players[1].a && players[0].d > players[1].d) {
            team1Pos = 1;
        }

        int team2Pos = 0;
        if (players[2].a > players[3].a && players[2].d < players[3].d) {
            team2Pos = 0;
        } else if (players[2].a < players[3].a && players[2].d > players[3].d) {
            team2Pos = 1;
        }

        int result;
        if(team1Pos == -1) {
            if(players[0].a > players[2].a && players[1].d > players[3].d && players[0].a > players[3].a && players[1].d > players[2].d) {
                result = 1;
            } else if(players[0].a < players[2].a && players[1].d < players[3].d) {
                result = 2;
            } else if(players[0].a < players[3].a && players[1].d < players[2].d) {
                result = 2;
            } else {
                result = -1;
            }
        } else {
            if (players[team1Pos].a > players[team2Pos+2].a && players[(team1Pos + 1) % 2].d > players[(team2Pos + 1) % 2 + 2].d) {
                    result = 1;
            } else if (players[team1Pos].a < players[team2Pos+2].a && players[(team1Pos + 1) % 2].d < players[(team2Pos + 1) % 2 + 2].d) {
                    result = 2;
            } else {
                result = -1;
            }
        }

        if (result == 1) {
            System.out.println("Team 1");
        } else if (result == 2) {
            System.out.println("Team 2");
        } else {
            System.out.println("Draw");
        }

    }
}

class Player {
    public int a;
    public int d;

    public Player(int a, int d) {
        this.a = a;
        this.d = d;
    }
}
