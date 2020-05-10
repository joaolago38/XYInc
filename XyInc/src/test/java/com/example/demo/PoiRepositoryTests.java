package com.example.demo;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
import com.example.demo.model.Poi;
import com.example.demo.repositoriy.PoiRepository;

/**
 * @authorj joao horacio do lago on 09/05/2020.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class PoiRepositoryTests {
	@Autowired
	private PoiRepository poiRepository;
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void criaNovoPoiData() {
		Poi poi = new Poi(1, "quintada do senhor Jose", 23, 45);
		this.poiRepository.save(poi);
		assertThat(poi.getId()).isEqualTo(1);
		assertThat(poi.getNomeDoPoi()).isEqualTo("quintada do senhor Jose");
		assertThat(poi.getCoordenadaX()).isEqualTo(23);
		assertThat(poi.getCoordenadaY()).isEqualTo(45);
	}

	@Test
	public void deletePoiData() {
		Poi poi = new Poi(2, "quintada do senhor Jose", 23, 45);
		this.poiRepository.save(poi);
		this.poiRepository.delete(poi);
		assertThat(this.poiRepository.findById(poi.getId())).isNotNull();
	}

	@Test
    public void updatePoiDataData() {
    	Poi poi = new Poi(1,"quintada do senhor Jose", 23, 45);
		this.poiRepository.save(poi);
        poi.setNomeDoPoi("quintada do senhor Joaquim Manuel");
        poi.setCoordenadaX(26);
        poi.setCoordenadaY(18);
        this.poiRepository.save(poi);		
        assertThat(poi.getNomeDoPoi()).isEqualTo("quintada do senhor Joaquim Manuel");
        assertThat(poi.getCoordenadaX()).isEqualTo(26);
        assertThat(poi.getCoordenadaY()).isEqualTo(18);
    }

}
