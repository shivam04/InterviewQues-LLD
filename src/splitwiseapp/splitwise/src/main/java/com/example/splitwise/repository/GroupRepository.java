package com.example.splitwise.repository;

import com.example.splitwise.model.SplitGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<SplitGroup, Long> {
}
