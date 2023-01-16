package com.example.mngkw_springboot;

import com.example.mngkw_springboot.entity.Camps;
import com.example.mngkw_springboot.repository.CampsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MngkwSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MngkwSpringbootApplication.class, args);
	}

//	@Bean
//	@Autowired
//	CommandLineRunner runner (CampsRepository repository){
//		return args -> {
//			Camps camps = new Camps(
//					"Obóz Herosów",
//					"16"
//			);
//			repository.insert(camps);
//		};
//
//	};

}
