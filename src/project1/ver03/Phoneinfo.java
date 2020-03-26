package project1.ver03;

import java.util.Scanner;

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
	//시작 메소드
	public void start() {
		boolean exit=true;
		int selectNum;
		Scanner scan= new Scanner(System.in);
		PhoneBookManager handler = new PhoneBookManager(100);
		while(exit) {
			
			System.out.println("1. 데이터 입력");
			System.out.println("2. 데이터 검색");
			System.out.println("3. 데이터 삭제");
			System.out.println("4. 주소록 출력");
			System.out.println("5. 프로그램 종료");
			System.out.print("선택: ");
			selectNum = scan.nextInt();
			scan.nextLine();
			if(selectNum == 1) {
				handler.dataInput();
			} else if(selectNum == 2) { 
				handler.dataSearch();
			} else if(selectNum == 3) { 
				handler.dataDelete();
			} else if(selectNum == 4) { 
				handler.dataAllShow();
			} else if(selectNum == 5) {
				exit=false;
			} else {
				System.out.println("숫자만 입력해라");
			}			
	
		}
		
	}
	
}

















