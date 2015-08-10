package com.htcursos.rest;

import com.htcursos.model.Course;
import com.htcursos.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Virmerson Bento dos Santos on 10/08/15.
 */

@Controller
@RequestMapping("/courses/")
public class CourseRest {
    @Autowired
    CourseRepository courseRepository;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<Course> getCourseList() {
        return (List<Course>) courseRepository.findAll();
    }


    @RequestMapping (value = "/insert", method = {RequestMethod.POST})
    @ResponseStatus(HttpStatus.OK)
    public void insert(@RequestBody Course course){
        courseRepository.save(course);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete (@PathVariable("id") Long id){
        courseRepository.delete(id);
    }

   @RequestMapping(value = "/update", method = RequestMethod.PUT)
   @ResponseStatus(HttpStatus.OK)
    public void update (@RequestBody Course course){
        courseRepository.save(course);
    }

}