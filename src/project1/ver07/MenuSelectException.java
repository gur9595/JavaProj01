package project1.ver07;

public class MenuSelectException  extends Exception{
	public MenuSelectException() {
		try {
			PhoneBookManager bookManager = new PhoneBookManager();
			System.out.println("1~5사이의 숫자만입력하세용");
			bookManager.printMenu();
		} catch (MenuSelectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
