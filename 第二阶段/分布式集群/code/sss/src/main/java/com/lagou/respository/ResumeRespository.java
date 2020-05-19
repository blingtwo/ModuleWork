package com.lagou.respository;

import com.lagou.pojo.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeRespository extends JpaRepository<Resume,Integer> {
}
