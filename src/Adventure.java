/*
* Adventure.java
* Author: Sanjit Muthineni
* Submission Date: 11/08/19
* Purpose: A brief paragraph description of the * program. What does it do? How does it do it?
* It is an Interactive Fiction game where the objective is to find the chest.
* Statement of Academic Honesty:
* The following code represents my own work. I have neither
* received nor given inappropriate assistance. I have not copied * or modified code from any source other than the course webpage * or the course textbook. I recognize that any unauthorized
* assistance or plagiarism will be handled in accordance with
* the University of Georgia's Academic Honesty Policy and the
* policies of this course. I recognize that my work is based
* on a programming project created by the Department of
* Computer Science at the University of Georgia. Any publishing * of source code for this project is strictly prohibited without * written consent from the Department of Computer Science.
*/
import java.util.Scanner;
public class Adventure {

	public static void main(String[] args) {
		//creating a player object
		Player player = new Player();
		
		boolean isLiving = true;
		boolean lockedChest = true;
		String input = "";
		Room currentRoom;
		
		//setting coordinates to (0,0)
		player.setX(0);
		player.setY(0);
		//creating a map object
		Map map = new Map();
		
		boolean move = false;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Welcome to UGA Adventures: Episode I");
		System.out.println("The Adventure of the Cave of Redundancy Adventure");
		System.out.println("By: Sanjit Muthineni");
		System.out.println();
		
		
		while(isLiving == true && lockedChest == true) {
			
			move = false;
			currentRoom = map.getRoom(player.getX(),player.getY());
			
			if(currentRoom.isDark() == false) {
				System.out.println(currentRoom.getDescription());
			}
			
			while (move == false) {
				
				input = scan.nextLine();

				
				//Get Lamp Command
				if (input.equalsIgnoreCase("Get Lamp")){
					if(currentRoom.getLamp() == null) {
						System.out.println("No lamp present");
					}
					else {
						player.setLamp(currentRoom.getLamp());//transferring lamp to the player from room
						currentRoom.clearLamp();
						System.out.println("Ok");
					}
				}
				
				//Light Lamp Command
				else if(input.equalsIgnoreCase("Light Lamp")) {
					if(player.getLamp() == null) { //checking to see if the player object has the lamp
						System.out.println("You don't have the lamp to light");
					}
					else {
						(player.getLamp()).onLamp(); //getting the lamp from the player and turning it on
						System.out.println("Ok");
					}
				}
				
				//North Command
				else if(input.equalsIgnoreCase("North")) {
					if((currentRoom.isDark() == true) && (player.getLamp() == null || player.getLamp().getLampState() == false)) {
						System.out.println("You have stumbled into a passing grue, and have been eaten");
						isLiving = false;
					}
					if(currentRoom.canGoNorth() == true) {
						player.setX(player.getX() - 1);
						move = true; //setting true so it will kick out and print the description
						currentRoom = map.getRoom(player.getX(), player.getY()); //setting the currentRoom to the new x and y values
						if((currentRoom.isDark() == true) && (player.getLamp() == null || player.getLamp().getLampState() == false)) {
							System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
						}						
					}
					if(currentRoom.canGoNorth() == false) {
						System.out.println("Can't go that way");
					}
				}
				
				//South Command
				else if(input.equalsIgnoreCase("South")) {
					if((currentRoom.isDark() == true) && (player.getLamp() == null || player.getLamp().getLampState() == false)) {
						System.out.println("You have stumbled into a passing grue, and have been eaten");
						isLiving = false;
					}
					if(currentRoom.canGoSouth() == true) {
						player.setX(player.getX() + 1);
						move = true;
						currentRoom = map.getRoom(player.getX(), player.getY());
						if((currentRoom.isDark() == true) && (player.getLamp() == null || player.getLamp().getLampState() == false)) {
							System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
						}						
					}
					if(currentRoom.canGoSouth() == false) {
						System.out.println("Can't go that way");
					}
				}
				
				//East Command
				else if(input.equalsIgnoreCase("East")) {
					if((currentRoom.isDark() == true) && (player.getLamp() == null || player.getLamp().getLampState() == false)) {
						System.out.println("You have stumbled into a passing grue, and have been eaten");
						isLiving = false;
					}
					if(currentRoom.canGoEast() == true) {
						player.setY(player.getY() + 1);
						move = true;
						currentRoom = map.getRoom(player.getX(), player.getY());
						if((currentRoom.isDark() == true) && (player.getLamp() == null || player.getLamp().getLampState() == false)) {
							System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
						}				
					}
					if(currentRoom.canGoEast() == false) {
						System.out.println("Can't go that way");
					}
				}
				
				//West Command
				else if(input.equalsIgnoreCase("West")) {
					if((currentRoom.isDark() == true) && (player.getLamp() == null || player.getLamp().getLampState() == false)) {
						System.out.println("You have stumbled into a passing grue, and have been eaten");
						isLiving = false;
					}
					if(currentRoom.canGoWest() == true) {
						player.setY(player.getY() - 1);
						move = true;
						currentRoom = map.getRoom(player.getX(), player.getY());
						if((currentRoom.isDark() == true) && (player.getLamp() == null || player.getLamp().getLampState() == false)) {
							System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
						}				
					}
					if(currentRoom.canGoWest() == false) {
						System.out.println("Can't go that way");
					}
				}
				
				//Look Command
				else if(input.equalsIgnoreCase("Look")) {
					String exits = "Exits are: ";
					if((currentRoom.isDark() == true) && (player.getLamp() == null || player.getLamp().getLampState() == false)) {
						System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
					}
					else {
						System.out.println(map.getRoom(player.getX(), player.getY()).getDescription());
						//identifying individual object in the room
						if(currentRoom.getLamp() != null) {
							System.out.println("There is an old oil lamp here that was made long ago");
						}
						if(currentRoom.getKey() != null) {
							System.out.println("You see the outline of a key on a dusty shelf that's covered in dust");
						}
						if(currentRoom.getChest() != null) {
							System.out.println("There is a large, wooden, massive, oaken chest here with the word “CHEST” carved into it");
						}
						if(currentRoom.canGoNorth() == true) { //where ever it is true will be the directions the player can go
							exits += "north ";
						}
						if(currentRoom.canGoSouth() == true) {
							exits += "south ";
						}
						if(currentRoom.canGoEast() == true) {
							exits += "east ";
						}
						if(currentRoom.canGoWest() == true) {
							exits += "west";
						}
						System.out.println(exits);
					}
				}
				
				//Get Key Command
				else if(input.equalsIgnoreCase("Get Key")) { //same set up as the Get Lamp command
					if(currentRoom.getKey() == null) {
						System.out.println("No key present");
					}
					else {
						player.setKey(currentRoom.getKey()); //transferring the key to the player
						currentRoom.clearKey(); //setting the key in the currentRoom to null
						System.out.println("Ok");
					}				
				}
				
				//Open Chest Command
				else if(input.equalsIgnoreCase("Open Chest")) {
					if(currentRoom.getChest() == null) {
						System.out.println("No chest present");
					}
					else {
						if((currentRoom.getChest()).isLocked() == true) {
							System.out.println("The chest is locked");
						}
						else {
							System.out.println((currentRoom.getChest()).getContents());
							System.exit(0);
						}
					}
				}
				
				//Unlock Chest Command
				else if(input.equalsIgnoreCase("Unlock Chest")) {
					if(currentRoom.getChest() == null) {
						System.out.println("No chest to unlock");
					}
					else {
						if(player.getKey() == null) {
							System.out.println("Need a key to do any unlocking!");
						}
						else {
							(player.getKey()).use(currentRoom.getChest());
							System.out.println("Ok");
							lockedChest = false;
						}
					}
				}
				
				//Any other command
				else {
					System.out.println("I'm sorry I don't know how to do that");
				}				
			}			
		}		
	}
}
