package javaProject;

public class StudentDTO {
	
	private String stuName;
	private String stuPhoneNum;
	private int stuYear;
	private String stuID;
	private String stuPassword;

	StudentDTO(){
		
	}
	
	public StudentDTO(String stuName, String stuPhoneNum, int stuYear, String stuID, String stuPassword) {		
		this.stuName = stuName;
		this.stuPhoneNum = stuPhoneNum;
		this.stuYear = stuYear;
		this.stuID = stuID;
		this.stuPassword = stuPassword;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuPhoneNum() {
		return stuPhoneNum;
	}

	public void setStuPhoneNum(String stuPhoneNum) {
		this.stuPhoneNum = stuPhoneNum;
	}

	public int getStuYear() {
		return stuYear;
	}

	public void setStuYear(int stuYear) {
		this.stuYear = stuYear;
	}

	public String getStuID() {
		return stuID;
	}

	public void setStuID(String stuID) {
		this.stuID = stuID;
	}

	public String getStuPassword() {
		return stuPassword;
	}

	public void setStuPassword(String stuPassword) {
		this.stuPassword = stuPassword;
	}

	@Override
//	public String toString() {
//		return "StudentDTO [stuName=" + stuName + ", stuPhoneNum=" + stuPhoneNum + ", stuYear=" + stuYear + ", stuID="
//				+ stuID + ", stuPassword=" + stuPassword + "]";
//	}

	public String toString() {
		return "학생 리스트 [학생 이름 : " + stuName + "	학생 전화번호 : " + stuPhoneNum + "	학번 : " + stuYear + "]";
	}
	
	
}
