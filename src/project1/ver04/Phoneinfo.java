package project1.ver04;


import project1.PhoneBookVer03;

public class Phoneinfo {
	//멤버변수
	String name;
	String phoneNumber;
	PhoneBookVer03 bookVer03 = new PhoneBookVer03();
	
	public Phoneinfo(String name, String phoneNumber) {

		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	//정보 출력용 메소드
	public void showPhoneInfo() {
		System.out.println("이름 : " + name);
		System.out.println("전화번호 : " + phoneNumber);
		
	}
	
}

















