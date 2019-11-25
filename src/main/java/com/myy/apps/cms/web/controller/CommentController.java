package com.myy.apps.cms.web.controller;

import com.myy.apps.cms.bean.Comment;
import com.myy.apps.cms.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private ICommentService commentService;
    @GetMapping(value = "findAll")
    public List<Comment> findAll(){
        return commentService.findAll();
    }
}
