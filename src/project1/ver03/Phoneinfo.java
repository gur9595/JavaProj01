package project1.ver03;


import project1.PhoneBookVer03;

public class Phoneinfo {
	//멤버변수
	String name;
	String phoneNumber;
	String birthday;
	PhoneBookVer03 bookVer03 = new PhoneBookVer03();
	
	public Phoneinfo(String name, String phoneNumber, String birthday) {

		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
	}

	//정보 출력용 메소드
	public void showPhoneInfo() {
		System.out.println("이름 : " + name);
		System.out.println("전화번호 : " + phoneNumber);
		if(birthday ==null) {
			System.out.println("생년월일 입력되지 않음");
		}else {
			System.out.println("생년월일 : " + birthday);
		}
	}
	
	
}

















