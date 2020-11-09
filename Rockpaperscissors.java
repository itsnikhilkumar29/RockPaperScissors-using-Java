import java.util.*;
import java.io.Console;
class Rockpaperscissors{
	public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(System.in);
		Console console=System.console();
		System.out.println("Game is about to begin.....");
		Thread.sleep(1000);
		System.out.println("How many rounds do you want to play???");
		int n=sc.nextInt();

		System.out.print("Enter player 1 name: ");
		String s1=sc.next();
		System.out.print("Enter player 2 name: ");
		String s2=sc.next();

		player p1=new player(s1);
		player p2=new player(s2);
		// game starts here..
		for(int i=0;i<n;i++){
			System.out.print(p1.name+" > ");
			String ss1=new String(console.readPassword());
			while(Rockpaper.valid_input(s1)==false){
				System.out.println("Error input :( Please give a valid input from these (rock,paper,scissors)...");
				String temp=new String(console.readPassword());
				s1=temp;
			}
			System.out.print(p2.name+" > ");
			String ss2=new String(console.readPassword());
			while(Rockpaper.valid_input(s2)==false){
				System.out.println("Error input :(  Please give a valid input from these (rock,paper,scissors)...");
				String temp=new String(console.readPassword());
				s2=temp;
			}
			int[] arr=Rockpaper.get_numeric(s1,s2);
			int result=Rockpaper.validate(arr[0],arr[1]);
			if (result==1)
				p1.score+=1;
			if (result==2)
				p2.score+=1;
			System.out.println("-------------------");
		}

		System.out.println("The Winner is...\n");
		Thread.sleep(2000);
		if (p1.score>p2.score){
			System.out.println(p1.name);
		}
		else if(p2.score>p1.score){
			System.out.println(p2.name);
		}
		else{
			System.out.println("Oops!!  Draw Match");
		}
		System.out.println("Player scores:\n\nPlayer 1:"+p1.score+"\n"+"Player 2:"+p2.score);
	}
}
class player{
	String name;
	int score;
	player(String name){
		this.name=name;
	}
}
class Rockpaper{
	int score;
	static int[] r1=new int[]{-1,2,1},r2=new int[]{1,-1,2},r3=new int[]{2,1,-1};
	static int[][] rules=new int[][]{r1,r2,r3};
	Rockpaper(){
		score=0;
	}
	static int validate(int p1,int p2){
		return rules[p1][p2];
	}
	static int[] get_numeric(String p1,String p2){
		HashMap<String,Integer> getnum=new HashMap<String,Integer>();
		getnum.put("rock",0);
		getnum.put("paper",1);
		getnum.put("scissors",2);
		int[] arr=new int[]{getnum.get(p1.toLowerCase()),getnum.get(p2.toLowerCase())};
		return arr;
	}
	static boolean valid_input(String s){
		List<String> l=new ArrayList<String>();
		l.add("rock");l.add("paper");l.add("scissors");
		if (l.contains(s.toLowerCase()))return true;
		return false;
	}
}