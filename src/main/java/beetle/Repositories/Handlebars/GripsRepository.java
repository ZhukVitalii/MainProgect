package beetle.Repositories.Handlebars;

import beetle.Entities.Handlebars.Grips;
import beetle.Entities.Handlebars.HandlebarMaker;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by VitaliiZhuk on 05.06.2017.
 */
public interface GripsRepository extends JpaRepository<Grips, Long> {
    @Query("SELECT c FROM Grips c WHERE c.maker = :maker")
    List<Grips> findByHandlebarMakers(@Param("maker") HandlebarMaker maker, Pageable pageable);

    @Query("SELECT COUNT(c) FROM Grips c WHERE c.maker = :maker")
    long countByHandlebarMaker(@Param("maker") HandlebarMaker maker);

    @Query("SELECT c FROM Grips c WHERE c.url = :url")
    List<Grips> findByUrl(@Param("url") String url, Pageable pageable);

    @Query("SELECT c FROM Grips c WHERE c.article = :article")
    List<Grips> findByArticle(@Param("article") Long article, Pageable pageable);

    @Query("SELECT c FROM Grips c WHERE c.article = :article")
    Grips findOneByArticle(@Param("article") Long article);

}