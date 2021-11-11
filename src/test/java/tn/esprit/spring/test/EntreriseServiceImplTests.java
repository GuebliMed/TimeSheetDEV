package tn.esprit.spring.test;


	import static org.assertj.core.api.Assertions.assertThat;
	import static org.junit.Assert.*;

	import java.util.List;

	import org.apache.logging.log4j.LogManager;
	import org.apache.logging.log4j.Logger;
	import org.junit.Test;
	import org.junit.runner.RunWith;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.context.SpringBootTest;
	import org.springframework.test.context.ContextConfiguration;
	import org.springframework.test.context.junit4.SpringRunner;

	import tn.esprit.spring.TimesheetSpringBootCoreDataJpaMvcRest1Application;
	import tn.esprit.spring.entities.Entreprise;
	import tn.esprit.spring.repository.EntrepriseRepository;
	import tn.esprit.spring.services.IEntrepriseService;

	@ContextConfiguration(classes = TimesheetSpringBootCoreDataJpaMvcRest1Application.class)
	@RunWith(SpringRunner.class)
	@SpringBootTest(classes = EntreriseServiceImplTests.class)
	public class EntreriseServiceImplTests {
		
		private static final long DEFAULT_TIMEOUT = 10000;
		private static final Logger l = LogManager.getLogger(EntreriseServiceImplTests.class);

		@Autowired
		IEntrepriseService es;
		
		@Autowired
		 EntrepriseRepository er;
		
		//test de la methode ajout
		@Test(timeout = DEFAULT_TIMEOUT)
		public void testaddentreprise() {
			Entreprise entreprise = new Entreprise("Sondos Entrepsie","Raison Social");
		es.ajouterEntreprise(entreprise);
		assertNotNull(entreprise.getId());
		l.info("Entreprise added successfuly ");
		er.deleteById(entreprise.getId());
		}
		

		
		//test du nombre des lignes dans la base il doit etre sup à 0
		@Test
		public void testListEntreprises() {
		List<Entreprise> e = (List<Entreprise>) er.findAll();
		assertThat(e).size().isGreaterThan(0);
		}
		
		//test de la methode count "le retour de la methode ne doit pas etre null".
		@Test
		public void testcountEmploye() {
		long nbrEm = er.count();
		assertNotNull(nbrEm);
		}
		
		//test que le nom n'est pas null
//		@Test
//		public void testNomEnttreprise(){
//			Entreprise e = er.findByName("sondos Entrepsie");
//			assertNotNull(e.getName());
//		}
		
		// test du suppression de l'entreprise
		@Test(timeout = 5000)
		public void testDeleteEmploye() {
		es.deleteEntrepriseById(2);
		l.info("deleted successfuly" );
		}

	}