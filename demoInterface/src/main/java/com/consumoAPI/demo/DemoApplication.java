package com.consumoAPI.demo;

import com.consumoAPI.demo.model.Pokemon;
import com.consumoAPI.demo.service.APIPokemon;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@EnableAutoConfiguration
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		/**
		List<Pokemon> pokemons = APIPokemon.getPokemons();
		for (Pokemon pokemon : pokemons) {
			System.out.println(pokemon);
		}
		**/
	}

}
