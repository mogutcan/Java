public class GuessGame{
	
	Player p1;
	Player p2;
	Player p3;
	
	PlayerInformation p1_i;
	PlayerInformation p2_i;
	PlayerInformation p3_i;


	
	public void StartGame(){
		
		p1 = new Player();
		p2 = new Player();
		p3 = new Player();
		
		p1_i =new PlayerInformation();
		p2_i =new PlayerInformation();
		p3_i =new PlayerInformation();
		
		p1_i.name = "Java";
		p1_i.age = 24;
		
		p2_i.name = "Oracle";
		p2_i.age = 19;
		
		p3_i.name = "Sun";
		p3_i.age = 21;
		
		
		int guessp1 = 0;
		int guessp2 = 0;
		int guessp3 = 0;
		
		boolean p1isRight = false;
		boolean p2isRight = false;
		boolean p3isRight = false;
		
		
		int targetNumber = (int)(10* Math.random());
		
		System.out.println("I'm thinking a number between 0 and 9 ");
		
		while (true){
			
			System.out.println("Number to guess is " +targetNumber);
			
			
			
			p1.guess();
			p2.guess();
			p3.guess();
			
			guessp1 = p1.number;
			
			
			
			int remain1 = Math.abs(guessp1 - targetNumber);
			int remain2 = Math.abs(guessp2 - targetNumber);
			int remain3 = Math.abs(guessp3 - targetNumber);
			
		
			
			
			System.out.println("Player one guessed " +guessp1);
			
			if ( (remain1 < 3 ) &&  (remain1 != targetNumber) )
				System.out.println("So Close !!!");
			
			
			System.out.println("Who is Player one ? ");
			
			p1_i.says();
			
			System.out.println("His name is " +p1_i.name);
			System.out.println("Age : " +p1_i.age);
			
			
			
			guessp2 = p2.number;
			
			System.out.println("Player two guessed " +guessp2);
			
			if (remain2 < 3 && remain2 != targetNumber)
				System.out.println("So Close !!!");
			
			System.out.println("Who is Player two ? ");
			
			p2_i.says();
			
			System.out.println("His name is " +p2_i.name);
			System.out.println("Age : " +p2_i.age);
			
			guessp3 = p3.number;
			
			System.out.println("Player three guessed " +guessp3);
			
			if (remain3 < 3 && remain3 != targetNumber)
				System.out.println("So Close !!!");
			
			System.out.println("Who is Player three ? ");
			
			p3_i.says();
			
			System.out.println("His name is " +p3_i.name);
			System.out.println("Age : " +p3_i.age);
			
			
			if (guessp1 == targetNumber){
				p1isRight=true;
			}
			
			if (guessp2 == targetNumber){
				p2isRight = true;
				
			}
			
			if (guessp3 == targetNumber){
				p3isRight = true;
				
			}
			
			if (p1isRight || p2isRight || p3isRight) {
				
				System.out.print("We have a winner!");
				
				System.out.println("Player one got it right ? " +p1isRight);
				System.out.println("Player two got it right ? " +p2isRight);
				System.out.println("Player three got it right ? " +p3isRight);
				System.out.println("Game is over");
				break;
			}
			else {
				
				System.out.println("Players have will try again");
			}
			
		}
	}
	
}
