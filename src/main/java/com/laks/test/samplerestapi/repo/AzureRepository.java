package com.laks.test.samplerestapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AzureRepository extends JpaRepository<Todo, Long> {
}
