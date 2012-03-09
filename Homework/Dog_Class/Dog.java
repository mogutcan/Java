public class Dog {

	String name;
	
public  void bark() {
		
		System.out.println(name + " Says Ruff");
		
		
	}
	
	public static void main(String[] args) {
		
		Dog dog1 = new Dog();
		
		dog1.bark();
		
		dog1.name="Bart";
		
		Dog[] mydogs = new Dog[3];
		
		mydogs[0] = new Dog();
		mydogs[1] = new Dog();
		mydogs[2] = dog1;
		
		mydogs[0].name= "Fred";
		
		mydogs[1].name= "Marge";
		
		System.out.print("Last dog name is ");
		System.out.println(mydogs[2].name);
		
		int x = 0;
		
		while (x < mydogs.length) {
			
			mydogs[x].bark();
			
			x = x+1;
			
		}
		
	}
}
