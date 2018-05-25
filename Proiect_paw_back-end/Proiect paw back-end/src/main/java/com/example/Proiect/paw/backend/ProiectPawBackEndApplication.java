package com.example.Proiect.paw.backend;

import com.example.Proiect.paw.backend.model.Categorie;
import com.example.Proiect.paw.backend.model.Produs;
import com.example.Proiect.paw.backend.repository.ProdusRepository;
import com.example.Proiect.paw.backend.service.ProdusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ProiectPawBackEndApplication extends SpringBootServletInitializer {



	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ProiectPawBackEndApplication.class);
	}


	public static void main(String[] args) {
		SpringApplication.run(ProiectPawBackEndApplication.class, args);
	}
}
