package project1;

import project1.ver06.MenuSelectException;
import project1.ver06.PhoneBookManager;


public class PhoneBookVer06{

	public static void main(String[] args) throws MenuSelectException {
		PhoneBookManager bookManager =new PhoneBookManager(100);
		bookManager.printMenu();
	}

}
