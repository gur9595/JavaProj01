package project1;

import project1.ver06.PhoneBookManager;
import project1.ver07.MenuSelectException;


public class PhoneBookVer06{

	public static void main(String[] args){
		PhoneBookManager bookManager =new PhoneBookManager(100);
		try {
			bookManager.printMenu();
		} catch (MenuSelectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
