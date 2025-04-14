package tn.esprit.gestion_negociation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.gestion_negociation.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}