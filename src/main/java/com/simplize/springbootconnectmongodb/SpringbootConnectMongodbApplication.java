package com.simplize.springbootconnectmongodb;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.simplize.springbootconnectmongodb.model.Address;
import com.simplize.springbootconnectmongodb.model.Gender;
import com.simplize.springbootconnectmongodb.model.Student;
import com.simplize.springbootconnectmongodb.repository.StudentRepository;

@SpringBootApplication
public class SpringbootConnectMongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootConnectMongodbApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(StudentRepository studentRepository, MongoTemplate mongoTemplate) {
		return args -> {
			Address address = new Address("England", "London", "NE9");
			String email = "jahmed@gmail.com";
			Student student = new Student("Jamila", "Ahmed", email, Gender.FEMALE, address,
					List.of("Computer Science", "Maths"), BigDecimal.TEN, LocalDateTime.now());

			studentRepository.findStudentByEmail(email).ifPresentOrElse(s -> {
				System.out.println((student + " already exists"));
			}, () -> {
				System.out.println(("Inserting student " + student));
				studentRepository.insert(student);
			});
		};
	}

}
