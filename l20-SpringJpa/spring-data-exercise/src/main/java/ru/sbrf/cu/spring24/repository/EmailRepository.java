package ru.sbrf.cu.spring24.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import ru.sbrf.cu.spring24.domain.Email;

@Service
public interface EmailRepository extends PagingAndSortingRepository<Email, Long> {

}
