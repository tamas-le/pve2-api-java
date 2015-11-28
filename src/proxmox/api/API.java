package proxmox.api;

import java.util.ArrayList;
import java.util.List;

import net.elbandi.pve2api.Pve2Api;
import net.elbandi.pve2api.data.Node;
import net.elbandi.pve2api.data.VmOpenvz;



/**
 * API est la classe permettant d'acc�der aux op�rations de base sur notre Proxmox
 * 
 * @author Aurelien
 * @version 1.0
 */

public class API {

	private static Pve2Api api; 
	private static Node mainNode;

/**
    * Permet d'initialiser la connexion
    * @param login
    *            Votre login
    * @param pw
    * 			Votre mot de passe           
    * @return true si �a s'est bien pass�
    */
	
	public static boolean auth(String login, String pw){
		try {
			api = new Pve2Api("149.202.70.59", login, "pve", pw);
			api.login();
			mainNode = api.getNodeList().get(0);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}


	}
	
	/**
	    * D�marre un container
	    * @param id
	    *            L'id du container         
	    * @return true si �a s'est bien pass�
	    */

	public static boolean demarerContainer(int id){
		try {
			api.startOpenvz(mainNode.getName(), id);
			return true;
		}catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
	/**
	    * Arrete un container
	    * @param id
	    *            L'id du container         
	    * @return true si �a s'est bien pass�
	    */

	public static boolean arreterContainer(int id){
		try {
			api.shutdownOpenvz(mainNode.getName(), id);
			return true;
		}catch (Exception e){
			e.printStackTrace();
			return false;
		}

	}


	/**
	    * Cr�e un container
	    * Attention il faut avoir le template ubuntu-10.04-standard_10.04-4_i386.tar.gz
	    * @param id
	    *            L'id du container         
	    * @return true si �a s'est bien pass�
	    */
	
	public static boolean creerContainer(int id){
		VmOpenvz vm = new VmOpenvz();
		vm.setNode("ns3021939");
		vm.setOstemplate("local:vztmpl/ubuntu-10.04-standard_10.04-4_i386.tar.gz");
		vm.setVmid(id);
		vm.setMemory(512);
		vm.setSwap(512);


		try{
			api.createOpenvz(vm);
			return true;
		} catch (Exception e){
			e.printStackTrace();
			return false;
		}


	}
	
	
	/**
	    * R�cup�re la liste des containers pr�sent dans le datacenter
	    * Attention il faut avoir le template ubuntu-10.04-standard_10.04-4_i386.tar.gz
	    *        
	    * @return la liste en question
	    */
	public static List<VmOpenvz> recupererContainers(){
		try {
			return api.getOpenvzCTs(mainNode.getName());
		} catch (Exception e){
			e.printStackTrace();
			return new ArrayList<VmOpenvz>();
		}
		
	}
	

	
	

}
