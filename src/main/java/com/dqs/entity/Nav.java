package com.dqs.entity;

public class Nav {
	private Integer id;
	private String name;
	private String href;
	private String icon;
	private Integer level;
	private Integer parentId;
	private Integer role_id;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Integer getRole_id() {
		return role_id;
	}
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	@Override
	public String toString() {
		return "Nav [id=" + id + ", name=" + name + ", href=" + href + ", icon=" + icon + ", level=" + level
				+ ", parentId=" + parentId + ", role_id=" + role_id + "]";
	}
	public Nav(Integer id, String name, String href, String icon, Integer level, Integer parentId, Integer role_id) {
		super();
		this.id = id;
		this.name = name;
		this.href = href;
		this.icon = icon;
		this.level = level;
		this.parentId = parentId;
		this.role_id = role_id;
	}
	public Nav() {
		super();
		// TODO Auto-generated constructor stub
	}
}
