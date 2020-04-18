package com.lagou.edu.controller;

import com.lagou.edu.pojo.Resume;
import com.lagou.edu.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/resume")
public class ResumeController {
    @Autowired
    private ResumeService resumeService;

    @RequestMapping("/queryResumes")
    public String queryAll(Model model) {

        List<Resume> resumes = resumeService.queryResumeList();
        model.addAttribute("resumes",resumes);

        return "main";
    }

    @RequestMapping("/editPage/{id}")
    public String editPage(@PathVariable Long id, Model model){
        Resume resume = resumeService.queryById(id);
        model.addAttribute("theResume",resume);
        return "edit";
    }

    @RequestMapping("/editSave")
    public String editSave(@ModelAttribute("theResume") Resume resume){
            resumeService.saveResume(resume);
        return "redirect:/resume/queryResumes";
    }

    @RequestMapping("/delete/{id}")
    public String deleteResume(@PathVariable Long id){
        resumeService.deleteResume(id);
        return "redirect:/resume/queryResumes";
    }

    @RequestMapping("/addPage")
    public String addPage(){
        return "add";
    }

    @RequestMapping("/addResume")
    public String addResume(Resume resume){
        resumeService.addResume(resume);
        return "redirect:/resume/queryResumes";
    }
}
