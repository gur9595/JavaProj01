package project1.ver06;

public class MenuSelectException  extends Exception{
	public MenuSelectException() {
		PhoneBookManager bookManager =new PhoneBookManager(100);
		System.out.println("1~5사이의 숫자만입력하세용");
		try {
			bookManager.printMenu();
		} catch (MenuSelectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
