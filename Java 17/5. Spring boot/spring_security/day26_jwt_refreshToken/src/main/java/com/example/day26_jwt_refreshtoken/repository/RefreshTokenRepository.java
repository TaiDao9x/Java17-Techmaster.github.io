package com.example.day26_jwt_refreshtoken.repository;

import com.example.day26_jwt_refreshtoken.entity.RefreshToken;
import com.example.day26_jwt_refreshtoken.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

    Optional<RefreshToken> findByUserAndRefreshTokenAndInvalidated(User user, String refeshToken, boolean invalidated);

    @Modifying
    @Query("update RefreshToken r set r.invalidated = true where r.user.id = :id")
    void logout(Long id);

}
