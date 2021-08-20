package usecases.user.add.impl;

import domain.user.IUser;
import domain.user.IUserRepository;
import domain.user.IUserFactory;
import usecases.user.add.IUserAddUseCase;
import usecases.user.add.UserAddInput;
import usecases.user.add.UserAddOutput;
import usecases.user.add.UserAddOutputStatus;

import java.io.IOException;

public final class UserAddInteractor implements IUserAddUseCase {

    private final IUserFactory userFactory;
    private final IUserRepository userRepository;

    public UserAddInteractor(IUserFactory userFactory, IUserRepository userRepository){
        this.userFactory = userFactory;
        this.userRepository = userRepository;
    }

    @Override
    public UserAddOutput create(UserAddInput input) {
        if (input == null) {
            return new UserAddOutput(UserAddOutputStatus.INPUT_IS_NULL, null);
        }

        // userを作成
        IUser user = null;
        try {
            user = userFactory.create(input.userName);
        } catch (IllegalArgumentException e) {
            return new UserAddOutput(UserAddOutputStatus.USER_NAME_IS_INVALID, null);
        }

        // ストレージに登録
        try {
            userRepository.save(user);
        } catch (IOException e) {
            return new UserAddOutput(UserAddOutputStatus.FAIL_TO_SAVE_USER, user);
        }

        return new UserAddOutput(UserAddOutputStatus.SUCCESS, user);
    }
}
