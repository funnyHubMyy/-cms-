package com.myy.apps.cms.bean.extend;

import com.myy.apps.cms.bean.Role;
import com.myy.apps.cms.bean.User;

import java.util.List;


public class UserExtend extends User {
    private List<Role> roles;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
