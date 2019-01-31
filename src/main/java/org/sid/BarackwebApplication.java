package org.sid;

import org.sid.dao.BarriqueRepository;
import org.sid.dao.BarriqueRepositoryImpl;
import org.sid.dao.RackRepository;
import org.sid.entities.Barrique;
import org.sid.entities.Rack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@SpringBootApplication


/*@ComponentScan("org.sid") //to scan packages mentioned*/
@EnableJpaRepositories("org.sid.dao")
public class BarackwebApplication implements CommandLineRunner{
	@Autowired
private BarriqueRepository barriqueRepository ; 
@Autowired
private RackRepository rackRepository ; 


	public static void main(String[] args) {
		SpringApplication.run(BarackwebApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//barriqueRepository.AlerteMaturite();
		//barriqueRepository.addBarrique(new Barrique("aaa", 12, 12, "b", "2019/02/01", "2022/02/01", "2019/01/29", true), 1, 1);
		//barriqueRepository.save(new Barrique("aaa", 12, 12, "b", "2019/02/01", "2022/02/01", "2019/01/29", true));
		//barriqueRepository.save(new Barrique("aaa", 12, 12, "b", "2019/02/01", "2019/01/01", "2019/01/29", true));
		//rackRepository.save(new Rack(10, "droit", 6, 50, 20, "2019/02/01"));
		 // barriqueRepository.save(new Barrique("aaa", 12, 12, "b", "2019/02/01", "2022/02/01", "2019/01/29", true));
		rackRepository.findAll().forEach(r->{
			System.out.println("le nouveau rack"+r.getIdRack());
			
		});
		
		barriqueRepository.findAll().forEach(c->{
			System.out.println("Barrique selectionnées sont : "+c.getIdBarique());
			
		});
	}

}

