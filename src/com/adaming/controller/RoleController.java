package com.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adaming.entities.Role;
import com.adaming.entities.Utilisateur;
import com.adaming.service.interfaces.IRoleService;

@Controller
public class RoleController {
	
	@Autowired
	IRoleService roleService;
	
	@RequestMapping(value = "roles", method = RequestMethod.GET)
	public List<Role> findAll() {
		return roleService.find(Role.class);
	}
	
	@RequestMapping(value = "roles/{id}", method = RequestMethod.GET)
	public Role findOne(@PathVariable("id") Long id) {
		return roleService.getById(Role.class, id);
	}
	
	@RequestMapping(value="roles", method = RequestMethod.POST)
	public Role saveRole (@RequestBody Role role)  {
		Role role1 = new Role();
		role1.setLibelle(role.getLibelle());
		roleService.create(role1);
		return role1;
	}
	
	@RequestMapping(value="roles/{id}", method = RequestMethod.DELETE)
	public void deleteRole(@PathVariable("id") Long id) {
		Role role1 = new Role();
		role1 = roleService.getById(Role.class, id);
		roleService.delete(role1);
	}
	
	@RequestMapping(value = "roles/{id}", method = RequestMethod.PUT)
	public Role updateRole (@PathVariable("id") Long id, @RequestBody Role role) {
		Role currentRole = roleService.getById(Role.class, id);
		currentRole.setLibelle(role.getLibelle());
		roleService.create(currentRole);
		return currentRole;
	}


}
