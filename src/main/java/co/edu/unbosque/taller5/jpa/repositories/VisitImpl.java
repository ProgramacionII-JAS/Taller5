package co.edu.unbosque.taller5.jpa.repositories;

import co.edu.unbosque.taller5.jpa.entities.Pet;
import co.edu.unbosque.taller5.jpa.entities.Visit;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class VisitImpl implements VisitRepository{

    private EntityManager entityManager;

    public VisitImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Visit> save(Visit visit) {
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(visit);
            entityManager.getTransaction().commit();
            return Optional.of(visit);
        }catch(Exception e){
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public List<Visit> findAll() {
        return entityManager.createQuery("from Visit ").getResultList();
    }

    @Override
    public Optional<Pet> findPetId(Integer petId) {
        Pet pet = entityManager.createQuery("SELECT o FROM Pet o WHERE o.petId = :petId", Pet.class)
                .setParameter("petId", petId).getSingleResult();
        return pet != null ? Optional.of(pet) : Optional.empty();
    }
}
