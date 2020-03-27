package project1.ver04;

import java.util.Scanner;

public class PhoneBookManager {

	private Phoneinfo[] phoneinfo;
	private int numP;
	public PhoneBookManager(int num) {
		phoneinfo=new Phoneinfo[num];
		numP=0;
	}

	//시작 메소드
		public void printMenu() {
			boolean exit=true;
			int selectNum;
			Scanner scan= new Scanner(System.in);
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
					dataInput();
				} else if(selectNum == 2) { 
					dataSearch();
				} else if(selectNum == 3) { 
					dataDelete();
				} else if(selectNum == 4) { 
					dataAllShow();
				} else if(selectNum == 5) {
					exit=false;
				} else {
					System.out.println("숫자만 입력해라");
				}			
		
			}
			
		}

	//데이터 저장
	public void dataInput() {
		String iname;
		String iphoneNumber;
		String icomName;
		String imajor;
		int igrade;
		int choNum;

		Scanner scan =new Scanner(System.in);
		System.out.println("1.일반  2.동창  3.회사");
		choNum = scan.nextInt();

		if(choNum==1) {
			System.out.println("이름: ");
			iname=scan.nextLine();
			scan.nextLine();
			System.out.println("전화번호:");
			iphoneNumber=scan.nextLine();

			Phoneinfo phoneinfo1 =new Phoneinfo(iname, iphoneNumber);
			phoneinfo[numP++] = phoneinfo1;

		} else if(choNum==2) {
			System.out.println("이름: ");
			iname=scan.nextLine();
			scan.nextLine();
			System.out.println("전화번호: ");
			iphoneNumber=scan.nextLine();

			System.out.println("전공: ");
			imajor=scan.nextLine();

			System.out.println("학년: ");
			igrade=scan.nextInt();

			PhoneSchoolInfo schoolInfo=new PhoneSchoolInfo(iname, iphoneNumber, imajor, igrade);
			phoneinfo[numP++]= schoolInfo;
			
			
		} else if(choNum==3) {
			System.out.println("이름: ");
			iname=scan.nextLine();
			scan.nextLine();

			System.out.println("전화번호: ");
			iphoneNumber=scan.nextLine();

			System.out.println("회사명: ");
			icomName=scan.nextLine();

			PhoneCompanyInfo companyInfo =new PhoneCompanyInfo(iname, iphoneNumber, icomName);
			phoneinfo[numP++]= companyInfo;

		} else {
			System.out.println("숫자만이라고");
		}

	}

	//데이터 검색
	public void dataSearch() {
		Scanner scan= new Scanner(System.in);
		System.out.println("검색할 이름: ");
		String  searchName = scan.nextLine();
		for(int i=0 ;i<numP;i++) {
			if(searchName.compareTo(phoneinfo[i].name)==0) {
				phoneinfo[i].showPhoneInfo();
				System.out.println("검색 완료");
			}
		}
	}

	//데이터 삭제
	public void dataDelete() {
		Scanner scan = new  Scanner(System.in);
		System.out.println("삭제할 이름을 입력하세요");
		String deletName=scan.nextLine();

		int deleteIndex=-1;
		for(int i=0; i<numP ;i++) {
			if(deletName.compareTo(phoneinfo[i].name)==0) {
				phoneinfo[i]=null;

				deleteIndex=i;

				numP--;
			}
		}
		if(deleteIndex==-1) {
			System.out.println("삭제된 데이터가 없습니다");
		}else {
			for(int i=deleteIndex; i<numP; i++) {
				phoneinfo[i]=phoneinfo[i+1];
			}
			System.out.println("삭제완료");
		}
	}
	//전체출력
	public void dataAllShow() {
		for(int i=0;i<numP;i++) {
			phoneinfo[i].showPhoneInfo();
			System.out.println("------------------------");
		}
	}
}



















