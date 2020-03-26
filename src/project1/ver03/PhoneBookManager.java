package project1.ver03;

import java.util.Scanner;

public class PhoneBookManager {
	
	private Phoneinfo[] phoneinfo;
	private int numP;
	
	public PhoneBookManager(int num) {
		phoneinfo=new Phoneinfo[num];
		numP=0;
	}
	
	
	//데이터 저장
	public void dataInput() {
		String iname;
		String iphoneNumber;
		String ibirthday;
		Scanner scan =new Scanner(System.in);
		
		System.out.println("이름: ");
		iname=scan.nextLine();
		System.out.println("전화번호");
		iphoneNumber=scan.nextLine();
		System.out.println("생일");
		ibirthday=scan.nextLine();
		
		Phoneinfo phoneinfo1 =new Phoneinfo(iname, iphoneNumber, ibirthday);
		phoneinfo[numP++] = phoneinfo1;
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



















