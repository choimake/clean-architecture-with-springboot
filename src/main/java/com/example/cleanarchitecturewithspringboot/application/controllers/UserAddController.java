package com.example.cleanarchitecturewithspringboot.application.controllers;

import com.example.cleanarchitecturewithspringboot.application.requests.user.add.UserAddRequest;
import domain.user.IUserFactory;
import domain.user.IUserRepository;
import domain.user.impl.UserFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import presenter.user.add.IUserAddPresenter;
import presenter.user.add.UserAddViewModel;
import presenter.user.add.impl.UserAddPresenter;
import repositories.user.UserRepositoryInMemory;
import usecases.user.add.UserAddInput;
import usecases.user.add.impl.UserAddInteractor;

import java.time.LocalDateTime;

@RestController
@RequestMapping(path = "/v1/user/add")
public class UserAddController {

    private final IUserFactory userFactory = new UserFactory();
    private final IUserRepository userRepository = new UserRepositoryInMemory();
    private final IUserAddPresenter presenter = new UserAddPresenter();

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserAddViewModel exec(@RequestBody UserAddRequest request) {
        var input = new UserAddInput(request.getName());
        var useCase = new UserAddInteractor(this.userFactory, this.userRepository);
        var output = useCase.create(input);
        return this.presenter.handle(output, LocalDateTime.now());
    }

}
