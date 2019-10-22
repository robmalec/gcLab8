package co.grandcircus;

import java.util.Scanner;

public class Lab8 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String cont = "yes";
		
		String[] Students = {"Christopher Nolan", "Stanley Kubrick", "David Lynch", "David Fincher", "Stephen Spielberg", "Sofia Coppola", "Ridley Scott", "Denis Vileneuve", "Vince Gilligan", "Katheryn Bigelow"};
		String[] Hometowns = {"Midland, MI", "Bay City, MI", "Saginaw, MI", "Flint, MI", "Ann Arbor, MI", "Detroit, MI", "Owosso, MI", "Hollywood, MI", "Ypsilanti, MI", "Ferndale, MI"};
		String[] FavFoods = {"Hamburgers", "Hot dogs", "Fruit salad", "Ice cream sundays", "Gummy bears", "Deep fried nachos", "Candied oreos", "Chocolate covered chicken and waffles", "Tamales", "Egg rolls"};
		
		boolean exists = false;
		
		// While loop
		while (cont.equals("yes")) {
			
			int id = -1;
			exists = false;
			String fullName = "";
			String firstName = "";
			String prompt = "Welcome to our Java class.  Which student would you like to learn more about? (enter a number 1-" + Students.length + ")";

			while (!exists) {
				id = Validator.getInt(scan, prompt);
				id--;
				
				try {
					fullName = Students[id];
					firstName = fullName.split(" ")[0];
					exists = true;
				}
				catch (IndexOutOfBoundsException e) {
					prompt = "That student doesn't exist.  Please try again.";
				}
			}
			
			System.out.println();

			boolean doCont = true;
			String next = "";
			
			
			prompt = "Student " + (id + 1) + " is " + fullName +".  What would you like to know about " 
					+ firstName
					+ "?  (Enter \"Hometown\" or \"Favorite food\")";
			
			while (doCont) {
				next = Validator.getString(scan, prompt);
				try {
					switch (next) {
					case "Hometown":
						System.out.println(firstName + " is from " + Hometowns[id] + ".  Would you like to know more? (Enter \"yes\" or \"no\"):");
						doCont = getContinue(scan);
						
						break;
					case "Favorite food":
						System.out.println(firstName + "'s favorite food is " + FavFoods[id] + ".  Would you like to know more? (Enter \"yes\" or \"no\"):");
						doCont = getContinue(scan);
						
						break;
						default:
							prompt = "That data does not exist.  Please try again. (Enter \"Hometown\" or \"Favorite food\")";
							break;
					}
				}
				catch (IllegalArgumentException e) {
					prompt = e.getMessage();
					doCont = true;
				}
				
			}

			// Logic should stop here if it doesn't need to be included in loop
			System.out.println("Would you like to learn about a different student? (yes/no)");
			cont = scan.next();
		}

		// Indication that the program has ended
		System.out.println("Goodbye.");
		scan.close();
	}
	
	static boolean getContinue(Scanner scan) throws IllegalArgumentException {
		boolean goodInput = false;
		char input = ' ';
		while (!goodInput) {
			input = scan.next().charAt(0);
			scan.nextLine();
			switch (input) {
			case 'y':
			case 'n':
				goodInput = true;
				break;
				default:
					throw new IllegalArgumentException("Invalid response provided.  What would you like to know?  (Enter \"Hometown\" or \"Favorite food\")");
			}
		}
		return (input == 'y');
	}
}
