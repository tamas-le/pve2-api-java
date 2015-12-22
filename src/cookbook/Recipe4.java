package cookbook;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import net.elbandi.pve2api.Pve2Api;
import net.elbandi.pve2api.data.VmOpenvz;

public class Recipe4 {
	public static void main(String[] args) {


		Pve2Api api = new Pve2Api("localhost", "root", "pam", "admin");

		try{
			api.login();
			System.out.println("You're in !");
			new Timer().schedule(new TimerTask() {
				
				@Override
				public void run() {
					try {
						List <VmOpenvz> list = api.getOpenvzCTs("aurel");
						for (VmOpenvz vm:list){
							System.out.println(vm);
						}
					} catch (Exception e){
						e.printStackTrace();
					}
					
					
				}
			}, 10000, 30000);
			

		} catch(Exception e) {
			System.out.println("Something went wrong");
		}

	}

}
