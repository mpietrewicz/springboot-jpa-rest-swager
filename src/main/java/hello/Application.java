package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@SpringBootApplication
@RestController
public class Application {

    @Autowired
    private PersonRepository personRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @GetMapping("/person")
    NewPerson getPerson() {
        return new NewPerson();
    }

    @GetMapping("/hobbits")
    Iterable<Person> getAllHobbits() {
        return personRepository.findAll();
    }

    @GetMapping("/countHobbits")
    long count() {
        return personRepository.count();
    }

    @GetMapping("/findById")
    Optional<Person> findById(@Param("id") long id) {
        return personRepository.findById(id);
    }


}