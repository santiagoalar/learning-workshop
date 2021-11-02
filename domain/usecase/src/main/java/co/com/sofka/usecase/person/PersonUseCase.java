package co.com.sofka.usecase.person;

import co.com.sofka.model.person.Person;
import co.com.sofka.model.person.gateways.PersonRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class PersonUseCase {

    private final PersonRepository personRepository;

    public Mono<Person> execute(Person person){
        return personRepository.create(person);
        //return Mono.just(person);
    }

    public Mono<String> execute2(){
        return Mono.just("Hola mundo");
    }
}
