package controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pojo.Exam;
import pojo.Study;

@Configuration
public class JavaConfig2 {
	// simple beam without any property to initalise
	@Bean(name = "getWhen")
	public Exam getExam() {
		Exam exam = new Exam();
		return exam;
	}

	// Bean with constructor and setter.
	@Bean(name = "getStudy")
	public Study getStudy() {
		Study study = new Study();
		study.setWhatTo("Computer Science");
		// or Study study = new Study("CS"); //Old way
		study.setWhen(getExam());
		// or Study study = new Study("Probability", getExam()); //Old way
		return study;
	}
}