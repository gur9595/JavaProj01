package project1;

import project1.ver08.MenuSelectException;
import project1.ver08.PhoneBookManager;


public class PhoneBookVer08{

	public static void main(String[] args) throws MenuSelectException {
		PhoneBookManager bookManager =new PhoneBookManager();
		bookManager.printMenu();
	}
}
