package calorias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

@SpringBootApplication
public class CaloriasApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaloriasApplication.class, args);
	}

}
