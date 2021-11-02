package co.com.sofka.mongo;

import co.com.sofka.model.person.Person;
import co.com.sofka.model.person.gateways.PersonRepository;
import co.com.sofka.mongo.helper.AdapterOperations;
import co.com.sofka.mongo.person.PersonDB;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class MongoRepositoryAdapter extends AdapterOperations<Person, PersonDB, String, MongoDBRepository>
    implements PersonRepository
// implements ModelRepository from domain
{

    public MongoRepositoryAdapter(MongoDBRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Person.class));
    }

    @Override
    public Mono<Person> create(Person person) {
        PersonDB personDB = PersonDB.builder()
                .name(person.getName())
                .age(person.getAge())
                .build();

        /*return Mono.just(person)
                .map(this::toData)
                .flatMap(repository::save);*/
        return repository.save(personDB).map(this::toEntity);
        //return Mono.just(person);
    }
}
