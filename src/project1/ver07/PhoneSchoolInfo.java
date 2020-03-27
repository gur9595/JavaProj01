package project1.ver07;

public class PhoneSchoolInfo extends Phoneinfo{
	String major;
	int grade;
	public PhoneSchoolInfo(String name, String phoneNumber
			,String major,int grade) {
		super(name, phoneNumber);
		this.major=major;
		this.grade=grade;
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
		return "이름 : "+name+"\n전화번호 : "+phoneNumber+"\n전공 : "+major+"\n학년 : "+grade;
	}
}
