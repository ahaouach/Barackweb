package org.sid;

import org.sid.dao.BarriqueRepository;
import org.sid.dao.BarriqueRepositoryImpl;
import org.sid.dao.EntrepotRepository;
import org.sid.dao.EtiquetteRepository;
import org.sid.dao.RackRepository;
import org.sid.entities.Barrique;
import org.sid.entities.Entrepot;
import org.sid.entities.Etiquette;
import org.sid.entities.Rack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

@SpringBootApplication

@ComponentScan("org.sid") // to scan packages mentioned*/
@EnableJpaRepositories("org.sid.dao")
public class BarackwebApplication implements CommandLineRunner {
	@Autowired
	private BarriqueRepository barriqueRepository;
	@Autowired
	private RackRepository rackRepository;
	@Autowired
	private EntrepotRepository entrepotRepository;
    @Autowired
    private EtiquetteRepository etiquetteRepository;
    
    
	public static void main(String[] args) {
		SpringApplication.run(BarackwebApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	//rackRepository.addRack(new Rack(1, "gauche", 20, 30, 30, "2019/02/03"), 1);
		entrepotRepository.RechercherEntrepot(2);
		barriqueRepository.AlerteMaturite(); 
	//	etiquetteRepository.save(new Etiquette("", "", true));
		
		barriqueRepository.getBarriques();
		etiquetteRepository.findAll().forEach(r -> {
			System.out.println("la nouvelle etiquette " + r.getIdEtiquette());

		});
		//entrepotRepository.save(new Entrepot("aaa", 3000, "2019/02/01", true));
		entrepotRepository.findAll().forEach(r -> {
			System.out.println("le nouveau entrepot " + r.getIdEntrepot());

		});
	
		
	//	barriqueRepository.addBarrique(new Barrique("aaa", 12, 12, "b", "2019/02/01", "2022/02/01", "2019/01/29", true),
			//	1, 8);
	//	barriqueRepository.addBarrique(new Barrique("azel", 20, 20, "A", dateFabricaVin, dateMaturaVin, dateOperation, etat), IdEtiquette, IdRack)
		// barriqueRepository.save(new Barrique("aaa", 12, 12, "b", "2019/02/01",
		// "2022/02/01", "2019/01/29", true));
	
		
			// barriqueRepository.save(new Barrique("aaa", 12, 12, "b", "2019/02/01",
			// "2019/01/01", "2019/01/29", true));
			// rackRepository.save(new Rack(10, "droit", 6, 50, 20, "2019/02/01"));
			// barriqueRepository.save(new Barrique("aaa", 12, 12, "b", "2019/02/01",
			// "2022/02/01", "2019/01/29", true));
		

		
		rackRepository.findAll().forEach(r -> {
			System.out.println("le nouveau rack" + r.getIdRack());

		});
		
	//	barriqueRepository.findAll().forEach(c -> {
		//	System.out.println("Barrique selectionnées sont : " + c.getIdBarique());
		//});
	}

}
