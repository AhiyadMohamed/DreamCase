package fr.inventiv.mahiyad.dreamcase.data.repositories;

import fr.inventiv.mahiyad.dreamcase.data.entities.Case;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaseRepository extends JpaRepository<Case,Long> {
}
