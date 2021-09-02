package com.simsim.voteMatch.repository;

import com.simsim.voteMatch.model.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Long> {
}