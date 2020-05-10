package com.example.demo.endpoint;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Poi;
import com.example.demo.repositoriy.PoiRepository;
/**
 * @authorj joao horacio do lago on 09/05/2020.
 */
@RestController
@RequestMapping("v1")
public class PoiEndpoint {

	private final PoiRepository poiDao;

	public PoiEndpoint(PoiRepository poiDao) {

		this.poiDao = poiDao;
	}
    
    @GetMapping("/poi")
    public List<Poi> findAllPoi() {
    	 return poiDao.findAll();
    }
    
    @GetMapping(path = "/poiProximidade")
    @ResponseBody
    public List<Poi> poiProximidade(@RequestParam List<Integer> values){
        return poiDao.buscaComProximidade(values, values, values);
    }
    
	@PostMapping(path = "/poi")
	public ResponseEntity<?> save(@RequestBody Poi poi) {
		return new ResponseEntity<>(poiDao.save(poi), HttpStatus.CREATED);
	}

}
