package com.lagou.edu.service;

import com.lagou.edu.pojo.Resume;

import java.util.List;

public interface ResumeService {

    List<Resume> queryResumeList();

    Resume queryById(Long id);

    public void saveResume(Resume resume);

    public void deleteResume(Long id);

    public void addResume(Resume resume);
}
