package beetle.Handlebars;

import beetle.Bakes.BikeType;
import beetle.Frames.Frame;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

/**
 * Created by VitaliiZhuk on 03.06.2017.
 */
public interface HandlebarRepository extends JpaRepository<Handlebar, Long> {

    @Query("SELECT c FROM Handlebar c WHERE c.handlebarMaker = :handlebarMaker")
    List<Handlebar> findByHandlebarMakers(@Param("handlebarMaker") HandlebarMaker handlebarMaker, Pageable pageable);


    @Query("SELECT c FROM Handlebar c WHERE c.handlebarDiameter = :handlebarDiameter")
    List<Handlebar> findByHandlebarDiameter(@Param("handlebarDiameter") HandlebarDiameter handlebarDiameter, Pageable pageable);

    @Query("SELECT c FROM Handlebar c WHERE c.url = :url")
    List<Handlebar> findByUrl(@Param("url") String url, Pageable pageable);

    @Query("SELECT c FROM Handlebar c WHERE c.article = :article")
    List<Handlebar> findByArticle(@Param("article") Long article, Pageable pageable);

    @Query("SELECT c FROM Handlebar c WHERE c.bikeType = :bikeType")
    List<Handlebar> findByBikeType(@Param("bikeType")BikeType bikeType, Pageable pageable);

    @Query("SELECT COUNT(c) FROM Handlebar c WHERE c.handlebarMaker = :handlebarMaker")
    long countByHandlebarMaker(@Param("handlebarMaker") HandlebarMaker handlebarMaker);

    @Query("SELECT COUNT(c) FROM Handlebar c WHERE c.bikeType = :bikeType")
    long countByBikeType(@Param("bikeType") BikeType bikeType);

    @Query("SELECT COUNT(c) FROM Handlebar c WHERE c.handlebarDiameter = :handlebarDiameter")
    long countByHandlebarDiameter(@Param("handlebarDiameter") HandlebarDiameter handlebarDiameter);


    @Query("SELECT c FROM Handlebar c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :pattern, '%'))")
    List<Handlebar> findByPattern(@Param("pattern") String pattern, Pageable pageable);


}
