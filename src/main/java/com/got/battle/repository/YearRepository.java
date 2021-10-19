package com.got.battle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.got.battle.model.Year;

public interface YearRepository extends JpaRepository<Year, Long> {

	Year findByYear(String year);

}
