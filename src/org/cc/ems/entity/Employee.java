package org.cc.ems.entity;

/**
 * 雇员实体
 * 
 * @author CC11001100
 * 
 */
public class Employee implements Comparable {

	private int id; // 编号
	private Post post; // 职位
	private String name; // 姓名
	private String sex; // 性别
	private int age; // 年龄
	private String depary; // 部门
	private int empYear; // 工龄

	@Override
	public String toString() {
		return "Employee [id=" + id + ", post=" + post + ", name=" + name
				+ ", sex=" + sex + ", age=" + age + ", depary=" + depary
				+ ", empYear=" + empYear + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDepary() {
		return depary;
	}

	public void setDepary(String depary) {
		this.depary = depary;
	}

	public int getEmpYear() {
		return empYear;
	}

	public void setEmpYear(int empYear) {
		this.empYear = empYear;
	}

	@Override
	public int compareTo(Object o) {
		Employee t=(Employee) o;
		if(t.id!=this.id){
			return this.id-t.id;
		}else{
			return 0;
		}
	}

}
