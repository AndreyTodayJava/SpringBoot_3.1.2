package ru.andrey.SpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.andrey.SpringBoot.model.User;

@Repository
public interface UsersRepository extends JpaRepository<User, Integer> {
}
