package br.com.webflux.service;

import br.com.webflux.entity.User;
import br.com.webflux.mapper.UserMapper;
import br.com.webflux.model.request.UserRequest;
import br.com.webflux.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    public Mono<User> save(final UserRequest request) {
        return repository.save(mapper.toEntity(request));
    }

    public Mono<User> findById(final String id) {
        return repository.findById(id);
    }

    public Flux<User> findAll() { return repository.findAll(); }

    public Mono<User> update(final String id, final UserRequest request) {
        return findById(id)
                .map(entity -> mapper.toEntity(request, entity))
                .flatMap(repository::save);
    }

    public Mono<User> delete(final String id) {
        return repository.findAndRemove(id);
    }
}
