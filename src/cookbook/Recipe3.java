package cookbook;



import java.util.List;
import java.util.Scanner;

import net.elbandi.pve2api.Pve2Api;
import net.elbandi.pve2api.data.VmOpenvz;

public class Recipe3 {

	public static void main(String[] args) {

		Pve2Api api = new Pve2Api("localhost", "root", "pam", "admin");

		try{
			api.login();
			System.out.println("You're in !");
			Scanner in = new Scanner(System.in);
			
			boolean again=true;
			while(again){
				System.out.println("[0] Exit");
				List <VmOpenvz> list = api.getOpenvzCTs("aurel");
				for(VmOpenvz vm: list){
					String running = !vm.isRunning()?"Start":"Stop";
					System.out.println("["+vm.getVmid()+"] "+running+" this container");
				}
				int num = in.nextInt();
				System.out.println(""+num);
				if (num == 0){
					again =false;
				}else {
					for(VmOpenvz vm :list){
						if (vm.getVmid()==num){
							if (!vm.isRunning()){
								api.startOpenvz("aurel", num);
							} else {
								api.shutdownOpenvz("aurel", num);
							}
						}
					}
				}

				
			}

		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Something went wrong");
		}

	}


}
