package com.abhay.JobApp.controller;

import com.abhay.JobApp.model.JobPost;
import com.abhay.JobApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {

    @Autowired
    private JobService service;

    @GetMapping("jobPosts")
    public List<JobPost> getAllJobs(){

        return  service.getAllJobs();
    }

    @GetMapping("jobPost/{postId}")
    public JobPost getJod(@PathVariable("postId") int postId){

        return service.getJob(postId);
    }

    @GetMapping("jobPosts/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword){
      return service.search(keyword);


    }

    @PostMapping("jobPost")
    public JobPost addJob(@RequestBody JobPost jobPost){
       service.addJob(jobPost);
       return service.getJob(jobPost.getPostId());

    }

    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost){
        service.updateJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }


    @DeleteMapping("jobPost/{postId}")
    public String delete(@PathVariable("postId") int postId){
        service.deleteJob(postId);
        return "Deleted";

    }

    @GetMapping("load")
    public String loadData() {
        service.load();
        return "success";
    }

}
