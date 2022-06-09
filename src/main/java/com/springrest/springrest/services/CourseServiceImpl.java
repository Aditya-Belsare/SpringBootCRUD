package com.springrest.springrest.services;

import com.springrest.springrest.entities.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

public class CourseServiceImpl implements CourseService{

    List<Course> list;

    public CourseServiceImpl(){
        list = new ArrayList<>();
        list.add(new Course(145, "Java Core Course","THis course contains basics of Java") );
        list.add(new Course(434, "Spring boot course", "Creating REST API using Spring boot"));
    }
    @Override
    public List<Course> getCourses() {
        return list;
    }

    @Override
    public Course getCourse(Long courseId) {
        Course c = null;
        for (Course course:list) {
            if(course.getId() == courseId) {
                c = course;
                break;
            }
        }
        return c;
    }

    @Override
    public Course addCourse(Course course) {
        list.add(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {

        list.forEach(e -> {
            if(e.getId() == course.getId()){
                e.setTitle(course.getTitle());
                e.setDescription(course.getDescription());
            }
        });

//        for (Course course1:list){
//            if (course1.getId() == course.getId()){
//                list.add(course);
//            }
//        }
        return course;
    }

    @Override
    public Course deleteCourse(long parseLong) {
        list=this.list.stream().filter(e->e.getId() != parseLong).collect(Collectors.toList());
        return null;
    }

}
