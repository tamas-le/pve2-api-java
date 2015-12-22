package cookbook;

import net.elbandi.pve2api.Pve2Api;
import net.elbandi.pve2api.data.Node;
import net.elbandi.pve2api.data.VmOpenvz;

public class Recipe2 {
	public static void main(String[] args) {

		Pve2Api api = new Pve2Api("localhost", "root", "pam", "admin");

		try{
			api.login();
			System.out.println("You're in !");
			Node node = api.getNode("aurel");
			VmOpenvz vm = new VmOpenvz();
			vm.setMemory(512);
			vm.setSwap(512);
			vm.setNode(node.getName());
			vm.setOstemplate("local:vztmpl/ubuntu-10.04-standard_10.04-4_i386.tar.gz");
			
			
			for (int i=3;i<10;i++){
				vm.setVmid(100+i);
				vm.setName("aurel.ct"+i);
				api.createOpenvz(vm);
			}
			
			//api.deleteOpenvz(node.getName(), 100);

		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Something went wrong");
		}

	}

}
