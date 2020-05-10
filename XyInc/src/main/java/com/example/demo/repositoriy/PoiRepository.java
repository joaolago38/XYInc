package com.example.demo.repositoriy;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.example.demo.model.Poi;

public interface PoiRepository extends JpaRepository<Poi, Integer> {
	
	@Query("SELECT u.nomeDoPoi,u.coordenadaX,u.coordenadaY FROM Poi u WHERE  ((u.coordenadaX - ?1) + (u.coordenadaY - ?2)) <= ?3")
	public List<Poi> buscaComProximidade(@Param("coordenadaX") List<Integer> values, @Param("coordenadaX") List<Integer> values2, @Param("max")List<Integer> values3);

}
