package com.briup.apps.cms.bean;

public class RolePrivilege {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_role_privilege.id
     *
     * @mbg.generated Tue Nov 19 08:22:08 CST 2019
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_role_privilege.role_id
     *
     * @mbg.generated Tue Nov 19 08:22:08 CST 2019
     */
    private Long roleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_role_privilege.privilege_id
     *
     * @mbg.generated Tue Nov 19 08:22:08 CST 2019
     */
    private Long privilegeId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_role_privilege.id
     *
     * @return the value of cms_role_privilege.id
     *
     * @mbg.generated Tue Nov 19 08:22:08 CST 2019
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_role_privilege.id
     *
     * @param id the value for cms_role_privilege.id
     *
     * @mbg.generated Tue Nov 19 08:22:08 CST 2019
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_role_privilege.role_id
     *
     * @return the value of cms_role_privilege.role_id
     *
     * @mbg.generated Tue Nov 19 08:22:08 CST 2019
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_role_privilege.role_id
     *
     * @param roleId the value for cms_role_privilege.role_id
     *
     * @mbg.generated Tue Nov 19 08:22:08 CST 2019
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_role_privilege.privilege_id
     *
     * @return the value of cms_role_privilege.privilege_id
     *
     * @mbg.generated Tue Nov 19 08:22:08 CST 2019
     */
    public Long getPrivilegeId() {
        return privilegeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_role_privilege.privilege_id
     *
     * @param privilegeId the value for cms_role_privilege.privilege_id
     *
     * @mbg.generated Tue Nov 19 08:22:08 CST 2019
     */
    public void setPrivilegeId(Long privilegeId) {
        this.privilegeId = privilegeId;
    }
}