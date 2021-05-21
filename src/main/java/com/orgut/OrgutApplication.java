package com.orgut;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.orgut.entities.Andress;
import com.orgut.entities.City;
import com.orgut.entities.Communities;
import com.orgut.entities.Person;
import com.orgut.entities.State;
import com.orgut.entities.Testimonials;
import com.orgut.repositories.AndressRepository;
import com.orgut.repositories.CityRepository;
import com.orgut.repositories.CommunitiesRepository;
import com.orgut.repositories.PersonRepository;
import com.orgut.repositories.StateRepository;
import com.orgut.repositories.TestimonialsRepository;

@SpringBootApplication
public class OrgutApplication implements CommandLineRunner{

	@Autowired
	private StateRepository stateRepository;
	
	@Autowired
	private CityRepository cityRepositories;
	
	@Autowired
	private CommunitiesRepository communitiesRepositories;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private TestimonialsRepository testimonialsRepository;
	
	@Autowired
	private AndressRepository andressRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(OrgutApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		State st1 = new State(null, "Santa Catarina");
		State st2 = new State(null, "Parana");
		State st3 = new State(null, "Sao Paulo");
		
		stateRepository.saveAll(Arrays.asList(st1, st2, st3));
		
		City c1 = new City(null, "Araranguá", st1);
		City c2 = new City(null, "Criciuma", st1);
		City c3 = new City(null, "Curitiba", st2);
		City c4 = new City(null, "São Paulo", st3);
		City c5 = new City(null, "Santos", st3);
		
		cityRepositories.saveAll(Arrays.asList(c1,c2,c3,c4,c5));
		
		Communities cm1 = new Communities(null, "Java Brasil", "Comunidade dedicada a programadores java");
		Communities cm2 = new Communities(null, "Fãs do ator Leonardo da Vinci", "Comunidade dedicada aos fãs desse grande ator");
		Communities cm3 = new Communities(null, "Nunca Andei de Nave Espacial", "Eu nunca andei de nave espacial, e você?");
		Communities cm4 = new Communities(null, "eu odeio acordar cedo", "Comunidade feita para todos que acham que o dia começa só depois do meio dia");
		communitiesRepositories.saveAll(Arrays.asList(cm1, cm2, cm3, cm4));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Person douglas = new Person(null, "Douglas", "Papai do Eric", sdf.parse("23/09/1991"), "1 filho (Eric)", "douglas@gmail.com", "Series e Games");
		Person flavia = new Person(null,"Flavia", "Esposa do Douglas, Mãe do Eric", sdf.parse("09/02/1994"), "1 filho (Eric)", "flavia@gmail.com", "series e novelas");
		Person eric = new Person(null,"Eric", "Filho do Douglas", sdf.parse("09/09/2020"), "não", "eric@gmail.com", "brincar, chorar e dormir");	

		personRepository.saveAll(Arrays.asList(douglas, flavia, eric));
		
		cm1.getPersons().addAll(Arrays.asList(douglas));
		cm2.getPersons().addAll(Arrays.asList(douglas,flavia));
		cm3.getPersons().addAll(Arrays.asList(douglas,flavia,eric));
		cm4.getPersons().addAll(Arrays.asList(flavia));	
		communitiesRepositories.saveAll(Arrays.asList(cm1, cm2, cm3, cm4));
		
		douglas.getCommunities().addAll(Arrays.asList(cm1,cm2,cm3));
		flavia.getCommunities().addAll(Arrays.asList(cm2,cm3,cm4));
		eric.getCommunities().addAll(Arrays.asList(cm3));
		personRepository.saveAll(Arrays.asList(douglas, flavia, eric));
		
				
		Testimonials tm1 = new Testimonials(null, "meu marido", flavia, douglas);
		Testimonials tm2 = new Testimonials(null, "meu Filho", flavia, eric);
		Testimonials tm3 = new Testimonials(null, "Meu Papai", eric, douglas);
		
		testimonialsRepository.saveAll(Arrays.asList(tm1, tm2, tm3));
		
		Andress ad1 = new Andress(null, "Rua laranja", "10", "centro", "88900-000", c1, douglas);
		Andress ad2 = new Andress(null, "Rua azul", "20", "centro", "88900-111", c2, flavia);
		Andress ad3 = new Andress(null, "Rua vermelha", "30", "centro", "88900-222", c3, eric);
		Andress ad4 = new Andress(null, "Rua cinza", "40", "centro", "88900-333", c4, eric);
		
		andressRepository.saveAll(Arrays.asList(ad1, ad2, ad3, ad4));
		
		douglas.getAndress().addAll(Arrays.asList(ad1));
		flavia.getAndress().addAll(Arrays.asList(ad2));
		eric.getAndress().addAll(Arrays.asList(ad3,ad4));
		personRepository.saveAll(Arrays.asList(douglas, flavia, eric));
		
	}

}
