package com.consumoAPI.demo.controller;

import com.consumoAPI.demo.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class PokemonController {

    @Autowired
    private PokemonService pokemonService;
    @GetMapping("/")
    public String listarPokemons(Model modelo){
        modelo.addAttribute("pokemons", pokemonService.listarAllPokemon());
        return "index";
    }
}
