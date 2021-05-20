package pl.sztukakodu.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.ColumnMapRowMapper;

import java.util.List;

@SpringBootApplication
public class TestOnlineBookStoreApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TestOnlineBookStoreApplication.class, args);
	}

	private final CatalogService catalogService;

	public TestOnlineBookStoreApplication(CatalogService catalogService) {
		this.catalogService = catalogService;
	}

	@Override
	public void run(String... args) throws Exception {
//		CatalogService service = new CatalogService();
//		List<Book> books = service.findByTitle("Alchemik");
		List<Book> books = catalogService.findByTitle("Alchemik");
		books.forEach(System.out::println);
	}
}
