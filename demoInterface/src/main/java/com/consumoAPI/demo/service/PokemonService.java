package com.consumoAPI.demo.service;

import com.consumoAPI.demo.model.Pokemon;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PokemonService {
    public List<Pokemon> listarAllPokemon();
}
