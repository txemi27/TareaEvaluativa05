package eus.bim.dam.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eus.bim.dam.Domain.Comic;

public interface ComicsRepository extends JpaRepository<Comic, Integer>{

}
