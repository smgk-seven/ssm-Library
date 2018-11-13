package com.smgk.library.bean;

public class Admin {
    private Integer adminId;

    private String adminName;

    private String adminCard;

    private String adminPwd;

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
    }

    public String getAdminCard() {
        return adminCard;
    }

    public void setAdminCard(String adminCard) {
        this.adminCard = adminCard == null ? null : adminCard.trim();
    }

    public String getAdminPwd() {
        return adminPwd;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd == null ? null : adminPwd.trim();
    }

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", adminCard=" + adminCard + ", adminPwd="
				+ adminPwd + "]";
	}
    
    
}