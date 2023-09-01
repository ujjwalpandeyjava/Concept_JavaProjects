// Use in Spring and SprinBoot
package com.waysToGetBeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// Cause of this @Configuration annotation the spring will search all the java files in this folder/package to check for the file containing @Configuration annotation and @bean in them.
// Can have multiple java files with @Conifuration annotation
@Configuration
// Tells these folder has to be used for looking files/beans
@ComponentScan(basePackages = "com.waysToGetBeans")
public class Configurations {
	// Simple beam without any initial properties - not-recommended
	@Bean(name = "getExam")
	public Exam getExam() {
		Exam exam = new Exam("CS", "Practical");
		return exam;
	}

	// Bean with initial properties - recommended
	@Autowired
	@Bean(name = "getStudy")
	public Study getStudy() {
		Study study = new Study("CS"); // Constructor
		study.setWhen("Night"); // Setter
		study.setForExam(this.getExam()); // Setter
		return study;
	}
}
