package com.aleksandra.myfavoritecolors.repository;

import com.aleksandra.myfavoritecolors.model.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ColorRepository extends JpaRepository<Color, Long> {

    Optional<Color> findColorByName(String name);

    Optional<Color> findColorByCode(String code);
}
