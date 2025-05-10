package com.igorsouza.games.services.users;

import com.igorsouza.games.models.User;

import java.util.UUID;

public interface UsersService {

    UUID saveUser(User user);
}
