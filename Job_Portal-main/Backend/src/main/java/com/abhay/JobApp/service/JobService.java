package com.abhay.JobApp.service;

import com.abhay.JobApp.model.JobPost;
import com.abhay.JobApp.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JobService {

    List<JobPost> jobs = new ArrayList<>(Arrays.asList(

            new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
                    List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),


            new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React", 3,
                    List.of("HTML", "CSS", "JavaScript", "React")),


            new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
                    List.of("Python", "Machine Learning", "Data Analysis")),


            new JobPost(4, "Network Engineer", "Design and implement computer networks for efficient data communication", 5,
                    List.of("Networking", "Cisco", "Routing", "Switching")),


            new JobPost(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android", 3,
                    List.of("iOS Development", "Android Development", "Mobile App"))
    ));

    @Autowired
    private JobRepo repo;
    public void addJob(JobPost jobpost)
    {
       repo.save(jobpost);
    }


    public List<JobPost> getAllJobs()
    {
        return repo.findAll();
    }


    public JobPost getJob(int postId) {

        return repo.findById(postId).orElse(new JobPost());
    }

    public void updateJob(JobPost jobPost) {
        repo.save(jobPost);
    }

    public void deleteJob(int postId) {
        repo.deleteById(postId);
    }

    public void load() {
        // arrayList to store store JobPost objects
        List<JobPost> jobs =
                new ArrayList<>(List.of(
                        new JobPost(1, "Software Engineer", "Exciting opportunity for a skilled software engineer.", 3, List.of("Java", "Spring", "SQL")),
                        new JobPost(2, "Data Scientist", "Join our data science team and work on cutting-edge projects.", 5, List.of("Python", "Machine Learning", "TensorFlow")),
                        new JobPost(3, "Frontend Developer", "Create amazing user interfaces with our talented frontend team.", 2, List.of("JavaScript", "React", "CSS")),
                        new JobPost(4, "Network Engineer", "Design and maintain our robust network infrastructure.", 4, List.of("Cisco", "Routing", "Firewalls")),
                        new JobPost(5, "UX Designer", "Shape the user experience with your creative design skills.", 3, List.of("UI/UX Design", "Adobe XD", "Prototyping"))

                ));

        repo.saveAll(jobs);

    }

    public List<JobPost> search(String keyword) {

      return repo.findByPostProfileContainingOrPostDescContaining(keyword, keyword);
    }
}
