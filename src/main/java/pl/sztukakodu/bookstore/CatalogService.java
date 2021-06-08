package pl.sztukakodu.bookstore;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class CatalogService {

    private final Map<Long, Book> storage = new ConcurrentHashMap<>();

    public CatalogService() {
        storage.put(1L, new Book(1L, "Alchemik", "Paulo Coelho", 1997));
        storage.put(2L, new Book(2L, "Podręcznik Wojownika Światła", "Paulo Coelho", 2002));
        storage.put(3L, new Book(3L, "Dziady", "Adam Mickiewicz", 1808));
        storage.put(4L, new Book(4L, "Treny", "Jan Kochanowski", 1580));
        storage.put(5L, new Book(5L, "Hamlet", "Wiliam Shakespeare", 1602));
    }

    List<Book> findByTitle(String title) {
        return storage.values()
                .stream()
                .filter(book -> book.title.startsWith(title))
                .collect(Collectors.toList());
    }

}
