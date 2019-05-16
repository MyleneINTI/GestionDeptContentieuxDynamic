package com.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adaming.entities.Tribunal;
import com.adaming.service.interfaces.ITribunalService;

@CrossOrigin("*")
@RestController
public class TribunalController {
	
	@Autowired
	ITribunalService tribunalService;
	
	@RequestMapping(value = "tribunaux", method = RequestMethod.GET)
	public List<Tribunal> findAll(){
		return tribunalService.find(Tribunal.class);
	}

}
