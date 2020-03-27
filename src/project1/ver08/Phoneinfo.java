package project1.ver08;

import project1.PhoneBookVer03;

public class Phoneinfo implements MenuItem {
	//멤버변수
	String name;
	String phoneNumber;

	public Phoneinfo(String name, String phoneNumber) {

		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	@Override
	public boolean equals(Object obj) {
		Phoneinfo phoneinfo = (Phoneinfo)obj;
		if(phoneinfo.name.equals(this.name)) {
			return true;
		}
		else {
			return false;
		}
	}
	@Override
	public int hashCode() {
		int hc1= name.hashCode();
		int hc2= phoneNumber.hashCode();
		int result= hc1+hc2;
		return result;
	}
	@Override
	public String toString() {
		return "이름 : "+name+"\n전화번호 : "+phoneNumber;
	}

}

















