package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog

        //assigned blog:
        Blog blog = this.blogRepository2.findById(blogId).get();

        //create image
        Image image = new Image();
        image.setDescription(description);
        image.setDimensions(dimensions);
        image.setBlog(blog);

        //save the image and blog: save parent(i.e blog)
        blog = this.blogRepository2.save(blog);
        image = this.imageRepository2.save(image);

        return image;

    }

    public void deleteImage(Integer id){
        //get image by id
        Image image = this.imageRepository2.findById(id).get();

        //assigned blog:
        Blog blog = image.getBlog();

        List<Image> imageList = blog.getImageList();
        imageList.remove(image);

        this.imageRepository2.deleteById(id);
        this.blogRepository2.save(blog);

    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        Image image = this.imageRepository2.findById(id).get();

        //given screen dimension:
        String[] givenDimension = screenDimensions.split("X");
        int length = Integer.parseInt(givenDimension[0]);
        int width = Integer.parseInt(givenDimension[1]);
        int screenArea = length * width;

        //image dimension:
        String[] imageDimension = image.getDimensions().split("X");
        int imgLength = Integer.parseInt(imageDimension[0]);
        int imgWidth = Integer.parseInt(imageDimension[1]);
        int imageArea = imgWidth * imgLength;

        return screenArea/imageArea;
    }
}
