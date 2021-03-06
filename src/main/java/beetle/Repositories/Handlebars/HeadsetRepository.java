package beetle.Repositories.Handlebars;

import beetle.Entities.Handlebars.HandlebarMaker;
import beetle.Entities.Handlebars.Headset;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by VitaliiZhuk on 05.06.2017.
 */
public interface HeadsetRepository extends JpaRepository<Headset, Long> {
    @Query("SELECT c FROM Headset c WHERE c.maker = :maker")
    List<Headset> findByHandlebarMakers(@Param("maker") HandlebarMaker maker, Pageable pageable);

    @Query("SELECT COUNT(c) FROM Headset c WHERE c.maker = :maker")
    long countByHandlebarMaker(@Param("maker") HandlebarMaker maker);

    @Query("SELECT c FROM Headset c WHERE c.url = :url")
    List<Headset> findByUrl(@Param("url") String url, Pageable pageable);

    @Query("SELECT c FROM Headset c WHERE c.article = :article")
    List<Headset> findByArticle(@Param("article") Long article, Pageable pageable);

    @Query("SELECT c FROM Headset c WHERE c.article = :article")
    Headset findOneByArticle(@Param("article") Long article);
}