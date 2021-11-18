package co.edu.unbosque.taller5.jpa.repositories;

import co.edu.unbosque.taller5.jpa.entities.Pet;
import co.edu.unbosque.taller5.jpa.entities.Visit;

import java.util.List;
import java.util.Optional;

public interface VisitRepository {

    Optional<Visit> save(Visit visit);

    List<Visit> findAll();

    public Optional<Pet> findPetId(Integer petId);
}
