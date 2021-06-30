package com.rockcor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import javax.management.StringValueExp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rockcor.model.Libro;

@SpringBootApplication
public class Application {

	public static Logger LOG = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		ordenarDeFormaImperativa();
		ordenarDeFormaDeclarativa();
		calcularPromedio();
		filtersAndPredicates();
	}

	public static void ordenarDeFormaImperativa() {
		List<String> list = new ArrayList<String>();

		list.add("Lilly");
		list.add("Ricardo");
		list.add("Arya");
		list.add("Gandalf");

		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});

		for (String nombres : list) {
			LOG.warn(nombres);
		}
	}

	public static void ordenarDeFormaDeclarativa() {
		List<String> list = new ArrayList<String>();

		list.add("Lilly");
		list.add("Ricardo");
		list.add("Arya");
		list.add("Gandalf");

		// Lambda = (Parametros) operador (Expresion)
		// (String p1, String p2) -> (p1.compareTo(p2))
		// Collections.sort(list, (String p1, String p2) -> (p1.compareTo(p2)));
		Collections.sort(list, (p1, p2) -> {
			return p1.compareTo(p2);
		});

		for (String nombres : list) {
			LOG.info(nombres);
		}
	}

	public static void calcularPromedio() {

		// IOperable operacion = (double x, double y) -> (x+y)/2;
		IOperable operacion = (x, y) -> {
			return (x + y) / 2;
		};

		LOG.info("" + operacion.calcularPromedio(10, 5));
	}

	static Predicate<Libro> getGender(String gender) {

		return (Libro l) -> {
			return l.getGender().equals(gender);
		};
	}

	/**
	 * Create a List of Books
	 * 
	 * @return
	 */
	public static List<Libro> getBooks() {

		Libro l1 = new Libro("El Señor de los anillos", "Fantasìa", 1100);
		Libro l2 = new Libro("Nacidos de la bruma", "Fantasìa", 1120);
		Libro l3 = new Libro("Anna de Tejas Verdes", "Historica", 300);
		Libro l4 = new Libro("El  diario de Ana Frank", "Historica", 200);
		Libro l5 = new Libro("Harry Potter y el Prisionero de Azkaban", "Fantasìa", 900);
		Libro l6 = new Libro("Crónica de una muerte anunciada", "Realismo", 350);

		return Arrays.asList(l1, l2, l3, l4, l5, l6);

	}

	/**
	 * Sample of filters and predicates
	 */
	public static void filtersAndPredicates() {

		List<Libro> books = getBooks();

		books.stream().filter(libro -> libro.getPages() >= 1000).map(libro -> libro.getName())
				.forEach(System.out::println);
	}

}
