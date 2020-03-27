package project1.ver07;

public class PhoneCompanyInfo extends Phoneinfo{
	String comName;
	public PhoneCompanyInfo(String name, String phoneNumber, String comName) {
		super(name, phoneNumber);
		this.comName=comName;
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
		return "이름 : "+name+"\n전화번호 : "+phoneNumber+"\n회사명 : "+comName;
	}
}
