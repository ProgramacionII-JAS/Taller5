package co.edu.unbosque.taller5.jpa.repositories;

import co.edu.unbosque.taller5.jpa.entities.Official;

import java.util.List;
import java.util.Optional;

public interface OfficialRepository {

    Optional<Official> create(Official off);

    Optional<Official> findByOwnerId(String officialId);

    List<Official> findAll();

    Optional<Official> updateName(String name, String username);

    Optional<Official> updateEmail(String email, String username);
}
