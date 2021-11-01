package javaProject;

public class LoginPS {

	private String ID; 
	private String pw;
	private int a;
	
	LoginPS(){
		
	}

	/**
	 * @param iD
	 * @param pw
	 * @param a
	 */
	public LoginPS(String iD, String pw, int a) {
		ID = iD;
		this.pw = pw;
		this.a = a;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	@Override
	public String toString() {
		return "LoginPS [ID=" + ID + ", pw=" + pw + ", a=" + a + "]";
	}
	
	
	

}
