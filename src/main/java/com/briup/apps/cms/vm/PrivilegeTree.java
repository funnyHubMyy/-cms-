package com.briup.apps.cms.vm;

import com.briup.apps.cms.bean.Privilege;

import java.util.List;

public class PrivilegeTree extends Privilege {
    private List<Privilege> children;

    public List<Privilege> getChildren() {
        return children;
    }

    public void setChildren(List<Privilege> children) {
        this.children = children;
    }
}
