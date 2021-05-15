package com.dio.marcimex.cidadesAPI.countries.repository;

import com.dio.marcimex.cidadesAPI.countries.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
