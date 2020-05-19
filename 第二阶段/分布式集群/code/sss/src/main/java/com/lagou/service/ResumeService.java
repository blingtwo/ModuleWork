package com.lagou.service;

import com.lagou.pojo.Resume;
import com.lagou.respository.ResumeRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResumeService {

    @Autowired
    ResumeRespository resumeRespository;


    public List<Resume> queryResumeList(){
        return resumeRespository.findAll();
    }

    public Resume queryById(Integer id){
        Optional<Resume> optional = resumeRespository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    public void saveResume(Resume resume){
        resumeRespository.save(resume);
        return;
    }

    public void deleteResume(Integer id){
        resumeRespository.deleteById(id);
        return;
    }

    public void addResume(Resume resume){
        resumeRespository.save(resume);
    }
}
