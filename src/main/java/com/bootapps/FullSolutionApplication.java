package com.bootapps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.external"})
//@EntityScan(basePackages= {"com.model"})
//@EnableJpaRepositories(basePackages = {"com.repos"})
public class FullSolutionApplication {

	public static void main(String[] args) {
		SpringApplication.run(FullSolutionApplication.class, args);
	}

}

/*

in case if your are using packages that are not fallinng
under com.bootapps

the application context will not be able to scan
stereotyped and configuration classes and hence
autowiring and other feature will fail

but it is not a rule to follow the package hierarchy
always

if we have other packages ,still we can make it works
by adding more config through annotation

DATAJPA

		we would create entity classes (that represents tables)
		repository (that represend db repository)
		
		you dont need to add any extra config if theses entities and repositories
		fall under com.bootapps and its subpackages
		
		if not we need to configure it explicitly
		

*/