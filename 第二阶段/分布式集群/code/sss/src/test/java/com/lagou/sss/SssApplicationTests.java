package com.lagou.sss;

import com.lagou.pojo.Resume;
import com.lagou.respository.ResumeRespository;
import com.lagou.service.ResumeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SssApplicationTests {

    @Autowired
    ResumeService resumeService;

    @Test
    public void findAll() {
        List<Resume> all = resumeService.queryResumeList();
        for (Resume resume : all) {
            System.out.println(resume);
        }

        Resume resume = resumeService.queryById(1);
        System.out.println("--->"+resume);
    }

}
