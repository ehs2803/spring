package com.example.project_practice1.service;

import com.example.project_practice1.domain.Course;
import com.example.project_practice1.domain.CourseRepository;
import com.example.project_practice1.models.CourseRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;

@Service // 스프링에게 이 클래스는 서비스임을 명시
public class CourseService {
    // final: 서비스에게 꼭 필요한 녀석임을 명시
    private final CourseRepository courseRepository;
    // 생성자를 통해, Service 클래스를 만들 때 꼭 Repository를 넣어주도록
    // 스프링에게 알려줌
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    @Transactional
    public Long update(Long id, CourseRequestDto requestDto) {
        Course course1 = courseRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        course1.update(requestDto);
        return course1.getId();
    }
    @DeleteMapping("/api/courses/{id}")
    public Long deleteCourse(@PathVariable Long id) {
        courseRepository.deleteById(id);
        return id;
    }

}

