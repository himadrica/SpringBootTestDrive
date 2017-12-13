package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.TeamDao;
import com.example.demo.domain.Team;

/*
 * Difference between RestController and Controller is that if you use RestController
 * you don't have to use @ResponseBody annotation at method level. It will consider
 * everything as rest method.
 */

@RestController
public class HelloRestController {

	@Autowired
	TeamDao teamDao;

	@RequestMapping("/rest")
	public List<Team> sayHelloToRest() {
		return teamDao.findAll();
	}
	
	@RequestMapping("/team/{name}")
	public Team findTeamByName(@PathVariable String name) {
		return teamDao.findByName(name);
	}
}
