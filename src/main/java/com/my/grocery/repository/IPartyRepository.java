package com.my.grocery.repository;

import com.my.grocery.model.Party;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPartyRepository extends JpaRepository<Party,Long> {
}
