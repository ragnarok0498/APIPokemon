package com.consumoAPI.demo.repository;

import com.consumoAPI.demo.model.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    public List<Pokemon> listarAllPokemon();
}
