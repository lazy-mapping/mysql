package mysql_web.domain;

/**
 * 领域对象 对应数据库和表单页面
 * 
 * @author cxf
 * 
 */
public class User {
	/*
	 * 对应数据库
	 */
	private String username;
	private String password;
	private int age;
	private String gender;
	/*
	 * 对应表单
	 * * 登录：用户名和密码
	 * * 注册：用户名、密码、确认密码、年龄、性别、验证码
	 */
	private String repassword;//确认密码
	private String verifyCode;//验证码

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
	public String toString() {
		return "User [username=" + username 
				+ ", password=" + password
				+ ", age=" + age 
				+ ", gender=" + gender 
				+ ", repassword="+ repassword 
				+ ", verifyCode=" + verifyCode + "]";
	}
}
