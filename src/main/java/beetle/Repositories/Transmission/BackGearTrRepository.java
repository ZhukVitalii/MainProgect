package beetle.Repositories.Transmission;

import beetle.Entities.Transmission.*;
import beetle.Entities.Wheels.BackSprocketNumber;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by VitaliiZhuk on 04.07.2017.
 */
public interface BackGearTrRepository extends JpaRepository<BackGearTr, Long> {

    @Query("SELECT c FROM BackGearTr c WHERE c.maker = :maker")
    List<BackGearTr> findByTransmissionMakers(@Param("maker") TransmissionMaker maker, Pageable pageable);

    @Query("SELECT COUNT(c) FROM BackGearTr c WHERE c.maker = :maker")
    long countByTransmissionMakers(@Param("maker")  TransmissionMaker maker);

    @Query("SELECT c FROM BackGearTr c WHERE c.backSprocketNumber = :backSprocketNumber")
    List<BackGearTr> findByBackSprocketNumber(@Param("backSprocketNumber") BackSprocketNumber backSprocketNumber, Pageable pageable);

    @Query("SELECT c FROM BackGearTr c WHERE c.url = :url")
    List<BackGearTr> findByUrl(@Param("url") String url, Pageable pageable);

    @Query("SELECT c FROM BackGearTr c WHERE c.article = :article")
    List<BackGearTr> findByArticle(@Param("article") Long article, Pageable pageable);

    @Query("SELECT c FROM BackGearTr c WHERE c.article = :article")
    BackGearTr findOneByArticle(@Param("article") Long article);

    @Query("SELECT c FROM BackGearTr c WHERE c.backSprocketMax = :backSprocketMax")
    List<BackGearTr> findByBackSprocketMax(@Param("backSprocketMax") BackSprocketMax backSprocketMax, Pageable pageable);

    @Query("SELECT c FROM BackGearTr c WHERE c.backSprocketMin = :backSprocketMin")
    List<BackGearTr> findByBackSprocketMin(@Param("backSprocketMin") BackSprocketMin backSprocketMin, Pageable pageable);

    @Query("SELECT c FROM BackGearTr c WHERE c.backSprocketSize = :backSprocketSize")
    List<BackGearTr> findByBackSprocketSize(@Param("backSprocketSize") BackSprocketSize backSprocketSize, Pageable pageable);

    @Query("SELECT c FROM BackGearTr c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :pattern, '%'))")
    List<BackGearTr> findByPattern(@Param("pattern") String pattern, Pageable pageable);
}