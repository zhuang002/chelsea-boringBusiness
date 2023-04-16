import java.util.Scanner;

public class Main {

	static boolean[][] map = new boolean[200][401];
	static Coord current;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i=0;i<map.length;i++) {
			for (int j=0;j<map[0].length;j++) {
				map[i][j] = false;
			}
		}
		current = new Coord(-1,200);
		
		fill('d', 3);
		fill('r', 3);
		fill('d', 2);
		fill('r',2);
		fill('u', 2);
		fill('r', 2);
		fill('d', 4);
		fill('l', 8);
		fill('u', 2);
		
		Scanner sc = new Scanner(System.in);
		char dir = sc.next().charAt(0);
		int step = sc.nextInt();
		
		while (dir!='q') {
			if (fill(dir,step))
				System.out.println((current.col-200)+" "+ (-(current.row+1)) +" safe");
			else {
				System.out.println((current.col-200)+" "+ (-(current.row+1)) +" DANGER");
				break;
			}
			dir = sc.next().charAt(0);
			step = sc.nextInt();
		}
		
		
	}
	private static boolean fill(char dir, int step) {
		// TODO Auto-generated method stub
		int deltaRow=0;
		int deltaCol=0;
		switch (dir) {
			case 'u':
				deltaRow=-1;
				deltaCol=0;
				break;
			case 'd':
				deltaRow=1;
				deltaCol=0;
				break;
			case 'l':
				deltaRow=0;
				deltaCol=-1;
				break;
			case 'r':
				deltaRow=0;
				deltaCol=1;
				break;
			default:
				break;
		}
		boolean safe = true;
		for (int i=0;i<step;i++) {
			current.row += deltaRow;
			current.col += deltaCol;
			if (map[current.row][current.col] == true) {
				safe = false;
			}
			map[current.row][current.col] = true;
		}
		return safe;
	}

}

class Coord {
	int row;
	int col;
	public Coord(int r, int c) {
		row = r;
		col = c;
	}
}
