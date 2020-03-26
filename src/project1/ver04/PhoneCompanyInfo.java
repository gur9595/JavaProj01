package project1.ver04;

public class PhoneCompanyInfo extends Phoneinfo{
	String comName;
	public PhoneCompanyInfo(String name, String phoneNumber, String comName) {
		super(name, phoneNumber);
		this.comName=comName;
	}
	
	@Override
	public void showPhoneInfo() {
		showPhoneInfo();
		System.out.println("회사명: "+comName);
	}
	
}
