package com.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adaming.entities.Tribunal;
import com.adaming.service.interfaces.ITribunalService;

@Controller
public class TribunalController {
	
	@Autowired
	ITribunalService tribunalService;
	
	@RequestMapping(value = "tribunaux", method = RequestMethod.GET)
	public List<Tribunal> findAll(){
		return tribunalService.find(Tribunal.class);
	}

}
