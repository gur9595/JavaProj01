package project1.ver09;

import java.sql.SQLException;
import java.util.Scanner;

public class PhoneBookManager {

	//시작 메소드
	public void printMenu() {
		int selectNum;
		Scanner scan= new Scanner(System.in);

		while(true) {

			System.out.println("1. 데이터 입력");
			System.out.println("2. 데이터 검색");
			System.out.println("3. 데이터 삭제");
			System.out.println("4. 주소록 출력");
			System.out.println("5. 프로그램 종료");
			System.out.print("선택: ");
			selectNum = scan.nextInt();

			switch(selectNum) {
			case 1:
				dataInput();
				break;
			case 2:
				dataSearch();
				break;
			case 3:
				dataDelete();
				break;
			case 4:
				dataAllShow();
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		} 

	}

	//데이터 저장
	public void dataInput() {		
		String iname;
		String iphoneNumber;
		String ibirthday;

		Scanner scan =new Scanner(System.in);

		IConnectImpl connectImpl =new IConnectImpl();
		connectImpl.connect("kosmo", "1234");

		try {
			String query ="INSERT into phonebook_tb values (?, ?, ?)";
			connectImpl.psmt = connectImpl.con.prepareStatement(query);

			System.out.println("이름 : ");
			iname= scan.nextLine();

			System.out.println("전화번호 : ");
			iphoneNumber= scan.nextLine();

			System.out.println("생일 : ");
			ibirthday =scan.nextLine();

			connectImpl.psmt.setString(1, iname);
			connectImpl.psmt.setString(2, iphoneNumber);
			connectImpl.psmt.setString(3, ibirthday);

			int affected = connectImpl.psmt.executeUpdate();
			System.out.println(affected + "행이 입력되었습니다.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectImpl.close();
		}

	}

	//데이터 검색
	public void dataSearch() {
		IConnectImpl connectImpl =new IConnectImpl();
		connectImpl.connect("kosmo", "1234");

		Scanner scan= new Scanner(System.in);		
		String name;

		try {

			System.out.println("찾는 이름을 입력 하세요 : ");
			name= scan.nextLine();
			connectImpl.stmt =connectImpl.con.createStatement();

			String query="select * from phonebook_tb where iname like '"+name+"'";

			connectImpl.rs =connectImpl.stmt.executeQuery(query);



			while (connectImpl.rs.next()) {
				connectImpl.psmt = connectImpl.con.prepareStatement(query);

				String iname= connectImpl.rs.getString(1);
				String iphoneNumber= connectImpl.rs.getString(2);
				String ibirthday= connectImpl.rs.getString(3);

				System.out.printf("이름 : %s \n",iname);
				System.out.printf("전화번호 : %s \n",iphoneNumber);
				System.out.printf("생일 : %s \n",ibirthday);

			}
			connectImpl.psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connectImpl.close();
		}
	}

	//데이터 삭제
	public void dataDelete() {
		IConnectImpl connectImpl =new IConnectImpl();
		connectImpl.connect("kosmo", "1234");
		Scanner scan= new Scanner(System.in);
		String name;
		try {
			String query = "delete from phonebook_tb where iname=?";
			connectImpl.psmt = connectImpl.con.prepareStatement(query);
			System.out.println("삭제할 아이디를 입력하세요: ");
			name =scan.nextLine();
			connectImpl.psmt.setString(1,name);
			
			connectImpl.psmt.executeUpdate();
			System.out.println("삭제되었습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connectImpl.close();
		}
		
	}
	//전체출력
	public void dataAllShow() {
		IConnectImpl connectImpl =new IConnectImpl();
		connectImpl.connect("kosmo", "1234");
		try {
			String query="select * from phonebook_tb";
			connectImpl.psmt = connectImpl.con.prepareStatement(query);
			connectImpl.rs = connectImpl.psmt.executeQuery();
			
			while (connectImpl.rs.next()) {
				String iname = connectImpl.rs.getString(1);
				String iphoneNumber = connectImpl.rs.getString(1);
				String ibirthday = connectImpl.rs.getString(1);
				
				System.out.printf("이름: %s \n",iname);
				System.out.printf("전화번호: %s \n",iphoneNumber);
				System.out.printf("생일: %s \n",ibirthday);
				System.out.println("-------------------------------");
			}
			connectImpl.psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connectImpl.close();
		}
	}

}

















