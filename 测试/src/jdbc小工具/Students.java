package jdbc小工具;

public class Students {
	private int sid;
	private String sname;
	private int age;
	private String gender;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	//toString方法，返回该对象的 字符串表示形式
	public String toString() {
		return "Stu [sid=" + sid + ", sname=" + sname + ", age=" + age
				+ ", gender=" + gender + "]";
	}
	public Students() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Students(int sid, String sname, int age, String gender) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.age = age;
		this.gender = gender;
	}
	
}
