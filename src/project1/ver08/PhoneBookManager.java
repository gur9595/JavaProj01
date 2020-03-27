package project1.ver08;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class PhoneBookManager implements SubMenuItem,MenuItem{

	HashSet<Phoneinfo> phoneSet = new HashSet<Phoneinfo>();

	public void printMenu() throws MenuSelectException{
		boolean exit=true;
		int selectNum;
		Scanner scan= new Scanner(System.in);
		while(true) {
			try {
				System.out.println("1. 데이터 입력");
				System.out.println("2. 데이터 검색");
				System.out.println("3. 데이터 삭제");
				System.out.println("4. 주소록 출력");
				System.out.println("5. 프로그램 종료");
				System.out.print("선택: ");
				selectNum = scan.nextInt();

				if(selectNum<1||selectNum>5) {
					MenuSelectException menuSelectException =new MenuSelectException();
					throw menuSelectException;
				}
				switch(selectNum) {
				case MenuItem.INPUNT:
					dataInput();
					break;
				case MenuItem.SEARCH:
					dataSearch();
					break;
				case MenuItem.DELETE:
					dataDelete();
					break;
				case MenuItem.ALLSHOW:
					dataAllShow();
					break;
				case MenuItem.EXIT:
					System.out.println("프로그램을 종료합니다.");
					return;
				}
			}catch (InputMismatchException e) {
				System.out.println("문자말고 1~5숫자만 입력하세요");
				scan.nextLine();
			} catch (NullPointerException e) {
				System.out.println("데이터가 없습니다.");
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
		scan.nextLine();
		
		if(choNum==NOMARL) {
			System.out.println("이름: ");
			iname=scan.nextLine();
			checking(iname);
			
			System.out.println("전화번호:");
			iphoneNumber=scan.nextLine();

			Phoneinfo phoneinfo1 =new Phoneinfo(iname, iphoneNumber);
			phoneSet.add(phoneinfo1);
			System.out.println("[중복저장전 객체수]: "+phoneSet.size());

		} else if(choNum==SCHOOL) {
			System.out.println("이름: ");
			iname=scan.nextLine();
			checking(iname);
			
			System.out.println("전화번호: ");
			iphoneNumber=scan.nextLine();

			System.out.println("전공: ");
			imajor=scan.nextLine();

			System.out.println("학년: ");
			igrade=scan.nextInt();

			PhoneSchoolInfo schoolInfo=new PhoneSchoolInfo(iname, iphoneNumber, imajor, igrade);
			phoneSet.add(schoolInfo);
			System.out.println("[중복저장전 객체수]: "+phoneSet.size());

		} else if(choNum==COMPANY) {
			System.out.println("이름: ");
			iname=scan.nextLine();
			checking(iname);

			System.out.println("전화번호: ");
			iphoneNumber=scan.nextLine();

			System.out.println("회사명: ");
			icomName=scan.nextLine();

			PhoneCompanyInfo companyInfo =new PhoneCompanyInfo(iname, iphoneNumber, icomName);
			phoneSet.add(companyInfo);
			System.out.println("[중복저장전 객체수]: "+phoneSet.size());


		} else {
			System.out.println("숫자만이라고");
		}

	}

	//데이터 검색
	public void dataSearch() {
		boolean aaa = false;
		Scanner scan= new Scanner(System.in);

		System.out.println("검색할 이름: ");
		String  searchName = scan.nextLine();


		Iterator<Phoneinfo> itr = phoneSet.iterator();
		while(itr.hasNext()) {
			Phoneinfo phoneinfo = itr.next();

			if(searchName.equals(phoneinfo.name)) {
				System.out.println(phoneinfo);
				aaa=true;
				System.out.println("검색완료");
			}
		}
		if(aaa== false) {
			NullPointerException nullPointerException = new NullPointerException();

			throw nullPointerException;
		}


	}

	//데이터 삭제
	public void dataDelete() {
		Scanner scan = new  Scanner(System.in);
		System.out.println("삭제할 이름을 입력하세요");
		String deletName=scan.nextLine();

		int deleteIndex=-1;

		Iterator<Phoneinfo> itr = phoneSet.iterator();
		while(itr.hasNext()) {
			Phoneinfo phoneinfo = itr.next();
			if(deletName.equals(phoneinfo.name)) {
				itr.remove();
				System.out.println("삭제완료");
			}

			if(deleteIndex==-1) {
				System.out.println("삭제된 데이터가 없습니다");
			}
		}


	}

	//전체출력
	public void dataAllShow() {
		for(Phoneinfo phone : phoneSet) {
			System.out.println(phone.toString());

			System.out.println("------------------------");
		}
	}

	public void checking(String iname) {
		
		int num = 0;
		Scanner scan =new Scanner(System.in);
		Iterator<Phoneinfo> itr= phoneSet.iterator();
		
		while (itr.hasNext()) {
			Phoneinfo phoneinfo = itr.next();
			if(iname.equals(phoneinfo.name)) {
				System.out.println("이름이 중복이야~ 1.덮쓰  2.돌아가기");
				num= scan.nextInt();
				if(num==1) {
					System.out.println("덮쓰 완료");
				}else if(num==2) {
					dataInput();
				}
			}

		}
	}
}



















