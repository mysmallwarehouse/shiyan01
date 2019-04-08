package com.wys.javabean;

public class Company {
	int companyId; // ��ҵ��ʶ
	String companyName;// ��˾������
	String companyArea;// ��˾��ַ
	String companySize; // ��˾�Ĺ�ģ
	String companyType; // ��˾������
	String companybrief;// ��˾���
	int companyState; // ��Ƹ״̬ �� 1.��Ƹ�� 2.����ͣ 3.�ѽ���
	int companySort;// �������
	int companyViewnum;// �����
	String companyPic;// ����ͼƬ
	
	

	public Company( String companyName, String companyArea, String companySize, String companyType,
			String companybrief, int companyState, int companySort, int companyViewnum, String companyPic) {
		super();
		
		this.companyName = companyName;
		this.companyArea = companyArea;
		this.companySize = companySize;
		this.companyType = companyType;
		this.companybrief = companybrief;
		this.companyState = companyState;
		this.companySort = companySort;
		this.companyViewnum = companyViewnum;
		this.companyPic = companyPic;
	}

	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyArea() {
		return companyArea;
	}

	public void setCompanyArea(String companyArea) {
		this.companyArea = companyArea;
	}

	public String getCompanySize() {
		return companySize;
	}

	public void setCompanySize(String companySize) {
		this.companySize = companySize;
	}

	public String getCompanyType() {
		return companyType;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	public String getCompanybrief() {
		return companybrief;
	}

	public void setCompanybrief(String companybrief) {
		this.companybrief = companybrief;
	}

	public int getCompanyState() {
		return companyState;
	}

	public void setCompanyState(int companyState) {
		this.companyState = companyState;
	}

	public int getCompanySort() {
		return companySort;
	}

	public void setCompanySort(int companySort) {
		this.companySort = companySort;
	}

	public int getCompanyViewnum() {
		return companyViewnum;
	}

	public void setCompanyViewnum(int companyViewnum) {
		this.companyViewnum = companyViewnum;
	}

	public String getCompanyPic() {
		return companyPic;
	}

	public void setCompanyPic(String companyPic) {
		this.companyPic = companyPic;
	}

}
