package co.com.sofka.mongo;

import co.com.sofka.model.person.Person;
import co.com.sofka.mongo.person.PersonDB;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import reactor.core.publisher.Flux;

public interface MongoDBRepository extends ReactiveMongoRepository<PersonDB, String>, ReactiveQueryByExampleExecutor<PersonDB> {

    Flux<PersonDB> findByname(String name);
}
