package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.Image;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BlogService {

    @Autowired
    BlogRepository blogRepository1;

    @Autowired
    UserRepository userRepository1;

    public Blog createAndReturnBlog(Integer userId, String title, String content) {
        //create a blog at the current time
        User user = this.userRepository1.findById(userId).get();

        if( user == null )return null;

        //blog
        Blog blog = new Blog();
        blog.setContent(content);
        blog.setTitle(title);
        blog.setUser(user);
        blog = this.blogRepository1.save(blog);

        //relational mapping of blog:
        List<Blog> blogList = user.getBlogList();
        blogList.add(blog);
        user = this.userRepository1.save(user);

        //return saved blog:
        return blog;
    }

    public void deleteBlog(int blogId){
        //delete blog and corresponding images
        Blog blog = this.blogRepository1.findById(blogId).get();

        if( blog == null )return;

        //get assigned user:
        User user = blog.getUser();
        List<Blog> blogList = user.getBlogList();
        blogList.remove(blog);
        this.userRepository1.save(user);

        //assigned images:
        this.blogRepository1.deleteById(blog.getId());
    }
}
