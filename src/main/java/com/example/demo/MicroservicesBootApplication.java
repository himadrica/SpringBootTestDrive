package com.example.demo;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dao.TeamDao;
import com.example.demo.domain.Player;
import com.example.demo.domain.Team;

@SpringBootApplication
public class MicroservicesBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesBootApplication.class, args);
	}
	
	@PostConstruct
	public void init() {
		Set<Player> players = new HashSet<Player>();
		players.add(new Player("Abhik Talukder", "Striker"));
		players.add(new Player("Arithra Talukder", "Striker"));

		Team team = new Team("Toronto", "Blue", "Jay", players);
		teamDao.save(team);
	}
	
	@Autowired
	TeamDao teamDao;
}
