package project1;

import project1.ver07.MenuSelectException;
import project1.ver07.PhoneBookManager;


public class PhoneBookVer07{

	public static void main(String[] args) throws MenuSelectException {
		PhoneBookManager bookManager =new PhoneBookManager();
		bookManager.printMenu();
	}
}
