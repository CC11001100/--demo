package org.cc.ems.entity;

/**
 * 职位
 * 
 * @author CC11001100
 * 
 */
public class Post {

	private int id; // 职位编号
	private String name; // 职位名称
	private String desc; // 职责描述

	@Override
	public String toString() {
		return "Post [id=" + id + ", name=" + name + ", desc=" + desc + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
