package beetle.service.impl;

import beetle.entity.forks.TubeDiameter;
import beetle.entity.Manufacturer;
import beetle.entity.frame.BikeType;
import beetle.entity.handlebars.*;
import beetle.repository.ManufacturerRepository;
import beetle.repository.frame.BikeTypeRepository;
import beetle.repository.handlebars.*;
import beetle.service.HandlebarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
public class HandlebarServiceImpl  implements HandlebarService {
    @Autowired
    private HandlebarRepository handlebarRepository;
    @Autowired
    private WindingRepository windingRepository;
    @Autowired
    private GripsRepository gripsRepository;
    @Autowired
    private HeadsetRepository headsetRepository;
    @Autowired
    private StemRepository stemRepository;

    @Autowired
    private HandlebarDiameterRepository handlebarDiameterRepository ;
    @Autowired
    private ManufacturerRepository manufacturerRepository;
    @Autowired
    private HeadsetTypeRepository headsetTypeRepository ;
    @Autowired
    private BikeTypeRepository bikeTypeRepository;

    //Lists with articles of components, that user added to cart
    public List<Long> articlesHandlebar = new ArrayList<>();
    public List<Long> articlesStem = new ArrayList<>();
    public List<Long> articlesGrips = new ArrayList<>();
    public List<Long> articlesHeadset = new ArrayList<>();
    public List<Long> articlesWinding = new ArrayList<>();

    //For handlebar
    //add articles to List
    public void addToArticleHandlebar(Long article) {
        articlesHandlebar.add(article);
        getSizeHandlebar();
    }
    //get article from List
    public Long getArticleHandlebarFromCart (int a) {
        Long b = articlesHandlebar.get(a);
        return b;
    }
    //get size of List
    public int getSizeHandlebar() {
        int a = articlesHandlebar.size();
        return a;
    }

    //For stem
    //add articles to List
    public void addToArticleStem(Long article) {
        articlesStem.add(article);
        getSizeStem();
    }
    //get article from List
    public Long getArticleStemFromCart (int a) {
        Long b = articlesStem.get(a);
        return b;
    }
    //get size of List
    public int getSizeStem() {
        int a = articlesStem.size();
        return a;
    }

    //For grips
    //add articles to List
    public void addToArticleGrips(Long article) {
        articlesGrips.add(article);
        getSizeGrips();
    }
    //get article from List
    public Long getArticleGripsFromCart (int a) {
        Long b = articlesGrips.get(a);
        return b;
    }
    //get size of List
    public int getSizeGrips() {
        int a = articlesGrips.size();
        return a;
    }

    //For headset
    //add articles to List
    public void addToArticleHeadset(Long article) {
        articlesHeadset.add(article);
        getSizeHeadset();
    }
    //get article from List
    public Long getArticleHeadsetFromCart (int a) {
        Long b = articlesHeadset.get(a);
        return b;
    }
    //get size of List
    public int getSizeHeadset() {
        int a = articlesHeadset.size();
        return a;
    }

    //For winding
    //add articles to List
    public void addToArticleWinding(Long article) {
        articlesWinding.add(article);
        getSizeWinding();
    }
    //get article from List
    public Long getArticleWindingFromCart (int a) {
        Long b = articlesWinding.get(a);
        return b;
    }
    //get size of List
    public int getSizeWinding() {
        int a = articlesWinding.size();
        return a;
    }

    //  add

    @Transactional
    public void addHandlebar(Handlebar handlebar) {
        handlebarRepository.save(handlebar);
    }

    @Transactional
    public  void addWinding (Winding winding) {
        windingRepository.save(winding);
    }

    @Transactional
    public  void addGrips (Grips grips) {
        gripsRepository.save(grips);
    }

    @Transactional
    public  void addHeadset (Headset headset) {
        headsetRepository.save(headset);
    }

    @Transactional
    public  void addStem (Stem stem) {
        stemRepository.save(stem);
    }

    @Transactional
    public void addHandlebarMaker(Manufacturer handlebarMaker) {
        manufacturerRepository.save(handlebarMaker);
    }

    //delete component from database for admin

    @Transactional
    public void deleteHandlebar(long[] idList) {
        for (long id : idList)
            handlebarRepository.delete(id);
    }

    @Transactional
    public void deleteWinding(long[] idList) {
        for (long id : idList)
            windingRepository.delete(id);
    }

    @Transactional
    public void deleteGrips(long[] idList) {
        for (long id : idList)
            gripsRepository.delete(id);
    }

    @Transactional
    public void deleteHeadset(long[] idList) {
        for (long id : idList)
            headsetRepository.delete(id);
    }

    @Transactional
    public void deleteStem(long[] idList) {
        for (long id : idList)
            stemRepository.delete(id);
    }

    //find all components from database

    @Transactional(readOnly=true)
    public List<Handlebar> findAll(Pageable pageable) {
        return handlebarRepository.findAll(pageable).getContent();
    }

    @Transactional(readOnly=true)
    public List<Winding> findAllTwo(Pageable pageable) {
        return windingRepository.findAll(pageable).getContent();
    }

    @Transactional(readOnly=true)
    public List<Grips> findAllThree(Pageable pageable) {
        return gripsRepository.findAll(pageable).getContent();
    }

    @Transactional(readOnly=true)
    public List<Headset> findAllFor(Pageable pageable) {
        return headsetRepository.findAll(pageable).getContent();
    }

    @Transactional(readOnly=true)
    public List<Stem> findAllFive(Pageable pageable) {
        return stemRepository.findAll(pageable).getContent();
    }

    @Transactional(readOnly=true)
    public List<Manufacturer> findHandlebarMakers() {
        return manufacturerRepository.findAll();
    }

    @Transactional(readOnly=true)
    public List<BikeType> findBikeType() {
        return bikeTypeRepository.findAll();
    }

    @Transactional(readOnly=true)
    public List<HandlebarDiameter> findHandlebarDiameter() {
        return handlebarDiameterRepository.findAll();
    }

    @Transactional(readOnly=true)
    public List<HeadsetType> findHeadsetType() {
        return headsetTypeRepository.findAll();
    }

    //select from database by parametrs

    @Transactional(readOnly=true)
    public List<Stem> findByHandlebarDiamAndTubeDiam(HandlebarDiameter handlebarDiameter,
                                                     TubeDiameter tubeDiameter,
                                                     Pageable pageable) {
        return stemRepository.findByHandlebarDiamAndTubeDiam(handlebarDiameter,
                tubeDiameter,
                pageable);
    }

    @Transactional(readOnly=true)
    public List<Handlebar> findHandlebarByArticle(Long article, Pageable pageable) {
        return handlebarRepository.findByArticle(article, pageable);
    }

    @Transactional(readOnly=true)
    public List<Handlebar> findHandlebarByUrl(String url, Pageable pageable) {
        return handlebarRepository.findByUrl(url,pageable);
    }

    @Transactional(readOnly=true)
    public List<Stem> findStemByArticle(Long article, Pageable pageable) {
        return stemRepository.findByArticle(article, pageable);
    }

    @Transactional(readOnly=true)
    public List<Stem> findStemByUrl(String url, Pageable pageable) {
        return stemRepository.findByUrl(url,pageable);
    }

    @Transactional(readOnly=true)
    public List<Grips> findGripsByArticle(Long article, Pageable pageable) {
        return gripsRepository.findByArticle(article, pageable);
    }

    @Transactional(readOnly=true)
    public List<Grips> findGripsByUrl(String url, Pageable pageable) {
        return gripsRepository.findByUrl(url,pageable);
    }

    @Transactional(readOnly=true)
    public List<Headset> findHeadsetByArticle(Long article, Pageable pageable) {
        return headsetRepository.findByArticle(article, pageable);
    }

    @Transactional(readOnly=true)
    public List<Headset> findHeadsetByUrl(String url, Pageable pageable) {
        return headsetRepository.findByUrl(url,pageable);
    }

    @Transactional(readOnly=true)
    public List<Winding> findWindingByArticle(Long article, Pageable pageable) {
        return windingRepository.findByArticle(article, pageable);
    }

    @Transactional(readOnly=true)
    public List<Winding> findWindingByUrl(String url, Pageable pageable) {
        return windingRepository.findByUrl(url,pageable);
    }

    @Transactional(readOnly=true)
    public List<Handlebar> findByHandlebarMakers(Manufacturer handlebarMaker, Pageable pageable) {
        return handlebarRepository.findByHandlebarMakers(handlebarMaker, pageable);
    }

    @Transactional(readOnly = true)
    public List<Handlebar> findByBikeType(BikeType bikeType, Pageable pegeable) {
        return  handlebarRepository.findByBikeType(bikeType, pegeable);
    }

    @Transactional(readOnly=true)
    public List<Handlebar> findByPattern(String pattern, Pageable pageable) {
        return handlebarRepository.findByPattern(pattern, pageable);
    }

    // count by

    @Transactional(readOnly = true)
    public long countByHandlebarMaker(Manufacturer handlebarMaker) {
        return handlebarRepository.countByHandlebarMaker(handlebarMaker);
    }

    @Transactional(readOnly = true)
    public long count() {
        return handlebarRepository.count();
    }

    //find by id
    @Transactional(readOnly = true)
    public Handlebar findHandlebar(long id) {
        return handlebarRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public Manufacturer findHandlebarMaker(long id) {
        return manufacturerRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public BikeType findBikeType(long id) {
        return bikeTypeRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public HandlebarDiameter findHandlebarDiameter(long id) {
        return handlebarDiameterRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public HeadsetType findHeadsetType(long id) {
        return headsetTypeRepository.findOne(id);
    }
}