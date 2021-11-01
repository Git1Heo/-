package javaProject;

public class ProfessorDTO {


	private String proName;
	private String proPhoneNum;
	private String proID;
	private String proPassword;
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public String getProPhoneNum() {
		return proPhoneNum;
	}
	public void setProPhoneNum(String proPhoneNum) {
		this.proPhoneNum = proPhoneNum;
	}
	public String getProID() {
		return proID;
	}
	public void setProID(String proID) {
		this.proID = proID;
	}
	public String getProPassword() {
		return proPassword;
	}
	public void setProPassword(String proPassword) {
		this.proPassword = proPassword;
	}
	/**
	 * @param proName
	 * @param proPhoneNum
	 * @param proID
	 * @param proPassword
	 */
	public ProfessorDTO(String proName, String proPhoneNum, String proID, String proPassword) {
		this.proName = proName;
		this.proPhoneNum = proPhoneNum;
		this.proID = proID;
		this.proPassword = proPassword;
	}
	@Override
//	public String toString() {
//		return "ProfessorDTO [proName=" + proName + ", proPhoneNum=" + proPhoneNum + ", proID=" + proID
//				+ ", proPassword=" + proPassword + "]";
//	}

	public String toString() {
		return "교수 리스트 [교수 이름 : " + proName + "	교수 전화번호 : " + proPhoneNum +  "]";
	}
	
	
}
