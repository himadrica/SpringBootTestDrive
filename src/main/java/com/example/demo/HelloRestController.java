package com.example.demo;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Player;
import com.example.demo.domain.Team;

/*
 * Difference between RestController and Controller is that if you use RestController
 * you don't have to use @ResponseBody annotation at method level. It will consider
 * everything as rest method.
 */

@RestController
public class HelloRestController {

	private Team team;

	@PostConstruct
	public void init() {
		Set<Player> players = new HashSet<Player>();
		players.add(new Player("Abhik Talukder", "Striker"));
		players.add(new Player("Arithra Talukder", "Striker"));

		team = new Team("Toronto", "Blue Jays", "Jay", players);
	}

	@RequestMapping("/rest")
	public Team sayHelloToRest(){
		return team;
	}
}
