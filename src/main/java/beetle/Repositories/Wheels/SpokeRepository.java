package beetle.Repositories.Wheels;

import beetle.Entities.Wheels.Spoke;
import beetle.Entities.Wheels.WheelMaker;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by VitaliiZhuk on 11.06.2017.
 */
public interface SpokeRepository extends JpaRepository<Spoke, Long> {
    @Query("SELECT c FROM Spoke c WHERE c.maker = :maker")
    List<Spoke> findByWheelMakers(@Param("maker") WheelMaker maker, Pageable pageable);

    @Query("SELECT c FROM Spoke c WHERE c.url = :url")
    List<Spoke> findByUrl(@Param("url") String url, Pageable pageable);

    @Query("SELECT c FROM Spoke c WHERE c.article = :article")
    List<Spoke> findByArticle(@Param("article") Long article, Pageable pageable);

    @Query("SELECT c FROM Spoke c WHERE c.article = :article")
    Spoke findOneByArticle(@Param("article") Long article);

    @Query("SELECT COUNT(c) FROM Spoke c WHERE c.maker = :maker")
    long countByWheelMakers(@Param("maker")  WheelMaker maker);

    @Query("SELECT c FROM Spoke c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :pattern, '%'))")
    List<Spoke> findByPattern(@Param("pattern") String pattern, Pageable pageable);
}
