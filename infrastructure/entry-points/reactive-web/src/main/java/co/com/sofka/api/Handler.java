package co.com.sofka.api;

import co.com.sofka.model.person.Person;
import co.com.sofka.usecase.person.PersonUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {

    private final PersonUseCase personUseCase;

    public Mono<ServerResponse> listenPostUseCasePerson(ServerRequest serverRequest){

        Mono<Person> personMono = serverRequest.bodyToMono(Person.class);

        return personMono.flatMap(person -> personUseCase.execute(person))
                .flatMap(person -> ServerResponse.ok().body(Mono.just(person), Person.class));
    }


    public Mono<ServerResponse> listenGetUseCasePerson(ServerRequest serverRequest){

        return ServerResponse.ok().body(personUseCase.execute2(), String.class);
    }

    public Mono<ServerResponse> listenGetAllPerson(ServerRequest serverRequest){
        return ServerResponse.ok().body(personUseCase.getAllPerson(), Person.class);
    }

    public Mono<ServerResponse> listenGetPersonByName(ServerRequest serverRequest){
        return ServerResponse.ok().body(personUseCase.getAllPerson(), Person.class);
    }

    /*public Mono<ServerResponse> listenGETUseCase(ServerRequest serverRequest) {
        // usecase.logic();
        return ServerResponse.ok().body("", String.class);
    }

    public Mono<ServerResponse> listenGETOtherUseCase(ServerRequest serverRequest) {
        // useCase2.logic();
        return ServerResponse.ok().body("", String.class);
    }

    public Mono<ServerResponse> listenPOSTUseCase(ServerRequest serverRequest) {
        // usecase.logic();
        return ServerResponse.ok().body("", String.class);
    }*/
}
