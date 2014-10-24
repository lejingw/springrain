package org.springrain.system.entity;

import java.util.List;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import org.springrain.frame.annotation.WhereSQL;
import org.springrain.frame.entity.BaseEntity;
/**
 * TODO 在此加入类描述
 * @copyright {@link 9iu.org}
 * @author springrain<Auto generate>
 * @version  2013-07-06 16:02:59
 * @see org.springrain.system.entity.Role
 */
@Table(name="t_role")
public class Role  extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	//alias
	/*
	public static final String TABLE_ALIAS = "Role";
	public static final String ALIAS_ID = "角色ID";
	public static final String ALIAS_NAME = "角色名称";
	public static final String ALIAS_PERMISSIONS = "权限";
	public static final String ALIAS_PID = "所属部门";
	public static final String ALIAS_REMARK = "备注";
	public static final String ALIAS_STATE = "状态(0:禁用2:启用)";
    */
	//date formats
	
	//columns START
	/**
	 * 角色ID
	 */
	private java.lang.String id;
	/**
	 * 角色名称
	 */
	private java.lang.String name;
	/** 
	 * 角色编码，用于生成权限框架的惟一标识权限
	 */
	private java.lang.String code;
	/**
	 * 所属部门
	 */
	private java.lang.String pid;
	/**
	 * 备注
	 */
	private java.lang.String remark;
	/**
	 * 状态(0:禁用1:启用)
	 */
	private java.lang.String state;
	//columns END 数据库字段结束
	
	private List<Menu> menus;
	
	//concstructor

	public Role(){
	}

	public Role(
		java.lang.String id
	){
		this.id = id;
	}

	//get and set
	public void setId(java.lang.String value) {
		this.id = value;
	}
	
	@Id
     @WhereSQL(sql="id=:Role_id")
	public java.lang.String getId() {
		return this.id;
	}
	public void setName(java.lang.String value) {
		this.name = value;
	}
	
     @WhereSQL(sql="name=:Role_name")
	public java.lang.String getName() {
		return this.name;
	}

	public void setPid(java.lang.String value) {
		this.pid = value;
	}
	
     @WhereSQL(sql="pid=:Role_pid")
	public java.lang.String getPid() {
		return this.pid;
	}
	public void setRemark(java.lang.String value) {
		this.remark = value;
	}
	
     @WhereSQL(sql="remark=:Role_remark")
	public java.lang.String getRemark() {
		return this.remark;
	}
	public void setState(String value) {
		this.state = value;
	}
	
     @WhereSQL(sql="state=:Role_state")
	public String getState() {
		return this.state;
	}
	
	public String toString() {
		return new StringBuffer()
			.append("角色ID[").append(getId()).append("],")
			.append("角色名称[").append(getName()).append("],")
			.append("权限编码[").append(getCode()).append("],")
			.append("所属部门[").append(getPid()).append("],")
			.append("备注[").append(getRemark()).append("],")
			.append("状态(0:禁用1:启用)[").append(getState()).append("],")
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Role == false) return false;
		if(this == obj) return true;
		Role other = (Role)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}

	@Transient
	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public java.lang.String getCode() {
		return code;
	}

	public void setCode(java.lang.String code) {
		this.code = code;
	}
}

	
