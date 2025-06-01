package com.srt.accounts.repo;

import com.srt.accounts.entities.CabDriver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CabDriverRepo extends JpaRepository<CabDriver, Long> {
}
