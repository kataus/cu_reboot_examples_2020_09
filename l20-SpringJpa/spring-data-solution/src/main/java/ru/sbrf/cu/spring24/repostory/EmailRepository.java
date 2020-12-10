package ru.sbrf.cu.spring24.repostory;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sbrf.cu.spring24.domain.Email;

import java.util.List;

public interface EmailRepository extends JpaRepository<Email, Integer> {

    List<Email> findAll();
}
