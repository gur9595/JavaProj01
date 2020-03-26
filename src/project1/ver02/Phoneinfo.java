package project1.ver02;

import java.util.Scanner;

public class Phoneinfo {
	//멤버변수
	String name;
	String phoneNumber;
	String birthday;
	
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
	//정보 입력용 메소드
	public void insert() {
		boolean exit=true;
		int selectNum;
		
		Scanner scan= new Scanner(System.in);
		
		while(exit) {
			
			System.out.println("**********매뉴를 선택 하세요**********");
			System.out.println("1. 데이터 입력");
			System.out.println("2. 프로그램 종료");
			System.out.print("선택: ");
			selectNum = scan.nextInt();
			scan.nextLine();
			
			if(selectNum == 1) {
				
				System.out.println("이름: ");
				name=scan.nextLine();
				
				System.out.print("전화번호: \n");
				phoneNumber = scan.nextLine();
				
				System.out.print("생년월일: \n");
				birthday = scan.nextLine();
				
				System.out.println("**입력된 정보**");
				showPhoneInfo();
				
			} else if(selectNum == 2) {
				exit=false;
			}
			
		}
		
	}
	
}

















