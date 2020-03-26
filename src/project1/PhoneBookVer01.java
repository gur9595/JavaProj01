package project1;

import project1.ver01.Phoneinfo;

public class PhoneBookVer01 {

	public static void main(String[] args) {
		Phoneinfo p1= new Phoneinfo("토니스타크", "010-1111-1111","70-01-01");
		
		Phoneinfo p2= new Phoneinfo("브루스매너", "010-2222-2222");
		
		p1.showPhoneInfo();
		p2.showPhoneInfo();//셍년월일 입력되지 않음
	}

}
