package javaProject;

import java.util.*;

public class ClassDTO {

	private int classNum;
	private String classTitle;
	private String classProf;
	private int classPersonnel;
	private int nowPersonnel;
//	private String stuname[];
	private List <String> stuname;
	
	//�쁽�옱 �닔媛뺤씤�썝
	public int getClassNum() {
		return classNum;
	}
	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}
	public String getClassTitle() {
		return classTitle;
	}
	public void setClassTitle(String classTitle) {
		this.classTitle = classTitle;
	}
	public String getClassProf() {
		return classProf;
	}
	public void setClassProf(String classProf) {
		this.classProf = classProf;
	}
	public int getClassPersonnel() {
		return classPersonnel;
	}
	public void setClassPersonnel(int classPersonnel) {
		this.classPersonnel = classPersonnel;
	}
	public int getNowPersonnel() {
		return nowPersonnel;
	}
	public void setNowPersonnel(int nowPersonnel) {
		this.nowPersonnel = nowPersonnel;
	}
	/**
	 * @param classNum
	 * @param classTitle
	 * @param classProf
	 * @param classPersonnel
	 * @param nowPersonnel
	 */

	ClassDTO(){
		
	}
	public ClassDTO(int classNum, String classTitle, String classProf, int classPersonnel, int nowPersonnel
			) {
		
		this.classNum = classNum;
		this.classTitle = classTitle;
		this.classProf = classProf;
		this.classPersonnel = classPersonnel;
		this.nowPersonnel = nowPersonnel;
	//	this.stuname = new String[classPersonnel];
		this.stuname=new ArrayList<> ();
	}

//	@Override
//	public String toString() {
//		return "ClassDTO [classNum=" + classNum + ", classTitle=" + classTitle + ", classProf=" + classProf
//				+ ", classPersonnel=" + classPersonnel + ", nowPersonnel=" + nowPersonnel + ", stuname=" + stuname
//				+ "]";
//	}
	//arraylist
	public List<String> getStuname() {
		return stuname;
	}
	
	public String getStunameArr(int i) {
		return stuname.get(i);
	}
	
	public void setStuname(String stuname) {
		this.stuname.add(stuname);
	}
	
	public void StunameRemove(int i) {
		stuname.remove(i);
		
	}
	
	

	//public String getStuname()
	
//	배열
//	public String[] getStuname() {
//		return stuname;
//	}
//	public void setStuname(String[] stuname) {
//		this.stuname = stuname;
//	}

	
	
	public String toString() {
		return "과목 리스트 [과목 넘버 : " + classNum + "	과목명 : " + classTitle + "	담당 교수 : " + classProf
				+ "	정원 수 : " + classPersonnel + "	현재 수강 인원 : " + nowPersonnel + "	수강 인원" + stuname
				+ "]";
	}
	


	
}
