package co.com.sofka.model.person.gateways;

import co.com.sofka.model.person.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonRepository {

    Mono<Person> create(Person person);
    Flux<Person> findAll();
    Flux<Person> findByName(String name);
}
