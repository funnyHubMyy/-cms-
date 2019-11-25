package com.myy.apps.cms.vm;

import com.myy.apps.cms.bean.Privilege;

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
