package mk.aleksandra.myfavoritecolors.Repository;

import mk.aleksandra.myfavoritecolors.Model.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ColorRepository extends JpaRepository<Color, Long> {

    Optional<Color> findByName(String name);
}
