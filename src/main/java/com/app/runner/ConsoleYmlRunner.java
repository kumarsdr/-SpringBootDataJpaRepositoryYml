package com.app.runner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.app.model.Product;
import com.app.repo.ProductRepository;
@Component
public class ConsoleYmlRunner implements CommandLineRunner {
	
	@Autowired
	private ProductRepository repo;
	
	public void run(String... args) throws Exception {
		
		repo.save(new Product(51,"Q",6.1));
		repo.save(new Product(52,"R",6.2));
		repo.save(new Product(53,"S",6.3));
		
		repo.save(new Product(54,"T",6.4));
		repo.save(new Product(55,"U",6.5));
		repo.save(new Product(56,"V",6.6));
		
		repo.save(new Product(57,"W",6.7));
		repo.save(new Product(58,"X",6.8));
		repo.save(new Product(59,"Y",6.9));
		repo.save(new Product(60,"Z",7.0));
		
		
		/*
		 * //(i)findAll()---- FETCH ALL RECORD IN DATABASES List<Product>
		 * list=repo.findAll(); list.forEach(System.out::println);
		 */
		  

		 //(ii)findAll(Sort)--------FIND ORDER-----//---1--ex---2--ex
		  //repo.findAll(Sort.by(Direction.DESC,"prodCode")).forEach(System.out::println);;
		  

		//repo.findAll(Sort.by("prodCost")).forEach(System.out::println);;//---2---ex

		//(iii)findAll(pageable)----- Pagination PageRequest 
		
		/*
		 * PageRequest p=PageRequest.of(1,3);
		 * repo.findAll(p).forEach(System.out::println);
		 */

		//(iv)(01)Example findAll(Example) method

		/*Product p=new Product();
		p.setProdCost(4.2);
		Example<Product> ex=Example.of(p);*/

		//(02)With Sorting

		/*Product p=new Product();
		p.setProdCost(4.2);
		Example<Product> ex=Example.of(p);
		repo.findAll(ex,Sort.by(Direction.DESC,"prodCode")).forEach(System.out::println);;*/


		//(03)With pagination
		/*
		 * Product p=new Product(); p.setProdCost(4.2); Example<Product>
		 * ex=Example.of(p);
		 * repo.findAll(ex,PageRequest.of(1,3)).forEach(System.out::println);;
		 */


		//(V)findAllById() in caluse

		repo.findAllById(Arrays.asList(51,52,53,54)).forEach(System.out::println);

	}

}
