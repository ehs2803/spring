package com.example.project_practice1;

import com.example.project_practice1.domain.Course;
import com.example.project_practice1.domain.CourseRepository;
import com.example.project_practice1.service.CourseService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@EnableJpaAuditing
@SpringBootApplication
public class ProjectPractice1Application {

	public static void main(String[] args) {
		SpringApplication.run(ProjectPractice1Application.class, args);

	}

	@Bean
	public CommandLineRunner demo(CourseRepository repository, CourseService courseService) {
		return (args) -> {
			Course course1 = new Course("test1","testor1");
			repository.save(course1);

			List<Course> courseList = repository.findAll();
			for(int i=0;i<courseList.size();i++){
				System.out.println(courseList.get(i));
				Course course = courseList.get(i);
				System.out.println(course.getId());
				System.out.println(course.getTitle());
				System.out.println(course.getTutor());
			}

			Course course = repository.findById(1L).orElseThrow(
					() -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
			);

			Course new_course = new Course("Spring", "tutor2");
			//courseService.update(1L, new_course);
			courseList = repository.findAll();
			for (int i=0; i<courseList.size(); i++) {
				Course course2 = courseList.get(i);
				System.out.println(course2.getId());
				System.out.println(course2.getTitle());
				System.out.println(course2.getTutor());
			}


			//repository.deleteAll();
		};
	}
}
