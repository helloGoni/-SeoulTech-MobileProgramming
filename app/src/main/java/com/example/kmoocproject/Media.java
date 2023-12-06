package com.example.kmoocproject;

import java.util.LinkedHashMap;
import java.util.Map;
//import javax.annotation.Generated;

//@Generated("jsonschema2pojo")
public class Media {

    private CourseImage courseImage;
    private CourseVideo courseVideo;
    private Image image;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public CourseImage getCourseImage() {
        return courseImage;
    }

    public void setCourseImage(CourseImage courseImage) {
        this.courseImage = courseImage;
    }

    public CourseVideo getCourseVideo() {
        return courseVideo;
    }

    public void setCourseVideo(CourseVideo courseVideo) {
        this.courseVideo = courseVideo;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
