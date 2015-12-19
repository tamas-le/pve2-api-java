package cookbook;

import net.elbandi.pve2api.Pve2Api;

public class Recipe1 {
	public static void main(String[] args) {

		//Pve2Api api = new Pve2Api("localhost", "root", "pam", "admin");
		Pve2Api api = new Pve2Api("localhost","user1","pve","user1");

		try{
			api.login();
			System.out.println("You're in !");

		} catch(Exception e) {
			System.out.println("Something went wrong");
		}

	}

}
