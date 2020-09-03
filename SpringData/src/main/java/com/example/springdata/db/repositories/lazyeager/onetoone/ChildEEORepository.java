package com.example.springdata.db.repositories.lazyeager.onetoone;

import com.example.springdata.db.entities.lazyeager.onetoone.ChildEEO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildEEORepository extends JpaRepository<ChildEEO, Long> {
}
