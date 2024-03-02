package br.com.webflux.service;

import br.com.webflux.entity.User;
import br.com.webflux.mapper.UserMapper;
import br.com.webflux.model.request.UserRequest;
import br.com.webflux.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    public Mono<User> save(final UserRequest request) {
        return repository.save(mapper.toEntity(request));
    }
}
