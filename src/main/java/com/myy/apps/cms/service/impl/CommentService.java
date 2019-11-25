package com.myy.apps.cms.service.impl;

import com.myy.apps.cms.bean.Comment;
import com.myy.apps.cms.bean.CommentExample;
import com.myy.apps.cms.dao.CommentMapper;
import com.myy.apps.cms.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("commentService")
public class CommentService implements ICommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Override
    public List<Comment> findAll() {
        CommentExample example = new CommentExample();
        example.createCriteria();
        List<Comment> comments = commentMapper.selectByExample(example);
        return comments;
    }
}
