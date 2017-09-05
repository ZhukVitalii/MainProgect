package beetle.Forks;

import beetle.Bakes.BikeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by VitaliiZhuk on 20.05.2017.
 */
@Controller
public class ForkController {
    static final int DEFAULT_GROUP_ID = -1;
    static final int ITEMS_PER_PAGE = 6;


    @Autowired
    private ForkService forkService;



    @RequestMapping("/show_forks")
    public String forksVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;

        List<Fork> forks = forkService
                .findAll(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));



        model.addAttribute("forkMakers", forkService.findForkMakers());
        model.addAttribute("bikeType", forkService.findBikeType());
        model.addAttribute("tubeDiameter", forkService.findTubeDiameter());
        model.addAttribute("wheelsDiams", forkService.findWheelsDiam());
        model.addAttribute("brakesTypes", forkService.findBrakesType());
        model.addAttribute("forks", forks);
        model.addAttribute("allPages", getPageCount());

        return "forks";
    }

    @RequestMapping("/fork_add")
    public String contactAddPage(Model model) {
        model.addAttribute("forkMakers", forkService.findForkMakers());
        model.addAttribute("bikeTypes", forkService.findBikeType());
        model.addAttribute("tubeDiameters", forkService.findTubeDiameter());
        model.addAttribute("wheelsDiams", forkService.findWheelsDiam());
        model.addAttribute("brakesTypes", forkService.findBrakesType());

        return "fork_add";
    }

    @RequestMapping("/forkMaker_add_page")
    public String forkMakerAddPage() {
        return "forkMaker_add_page";
    }

    @RequestMapping("/forkMaker/{id}")
    public String listForkMaker(
            @PathVariable(value = "id") long forkMakerId,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        ForkMaker forkMaker = (forkMakerId != DEFAULT_GROUP_ID) ? forkService.findForkMaker(forkMakerId) : null;


        if (page < 0) page = 0;

        List<Fork> forks = forkService
                .findByForkMakers(forkMaker, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));


        model.addAttribute("forkMakers", forkService.findForkMakers());

        model.addAttribute("forks", forks);

        model.addAttribute("byForkMakerPages", getPageCount(forkMaker));

        model.addAttribute("groupId", forkMakerId);

        return "index";
    }


    @RequestMapping(value = "/fork/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> delete(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            forkService.deleteForks(toDelete);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value="/fork/add", method = RequestMethod.POST)
    public String forkAdd(
            @RequestParam(value = "forkMaker") long forkMakerId,
            @RequestParam Long article,
            @RequestParam String url,
            @RequestParam String name,
            @RequestParam(value = "bikeType") long bikeTypeId,
            @RequestParam(value = "wheelsDiam") long wheelsDiamId,
            @RequestParam(value = "tubeDiameter") long tubeDiameterId,
            @RequestParam String stTubeLength,
            @RequestParam(value = "brakesType") long brakesTypeId,
            @RequestParam String forkMaterial,
            @RequestParam String weight,
            @RequestParam String color,
            @RequestParam String move,
            @RequestParam Double price,
            @RequestParam String description,
            @RequestParam String way)
    {
        ForkMaker forkMaker = (forkMakerId != DEFAULT_GROUP_ID) ? forkService.findForkMaker(forkMakerId) : null;
        BikeType bikeType = (bikeTypeId != DEFAULT_GROUP_ID) ? forkService.findBikeType(bikeTypeId) : null;
        TubeDiameter tubeDiameter = (tubeDiameterId != DEFAULT_GROUP_ID) ? forkService.findTubeDiameter(tubeDiameterId) : null;
        WheelsDiam wheelsDiam = (wheelsDiamId != DEFAULT_GROUP_ID) ? forkService.findWheelsDiam(wheelsDiamId) : null;
        BrakesType brakesType = (brakesTypeId != DEFAULT_GROUP_ID) ? forkService.findBrakesType(brakesTypeId) : null;

        Fork fork = new Fork(forkMaker,article,url,  name, bikeType,  wheelsDiam,  tubeDiameter, stTubeLength, brakesType,  forkMaterial ,
                weight, color, move, price, description, way);


        forkService.addFork(fork);

        return "redirect:/show_forks";
    }

    @RequestMapping(value="/forkMaker/add", method = RequestMethod.POST)
    public String forkMakerAdd(@RequestParam String name) {
        forkService.addForkMaker(new ForkMaker(name));
        return "redirect:/show_forks";
    }





    private long getPageCount() {
        long totalCount = forkService.count();
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }

    private long getPageCount(ForkMaker forkMaker) {
        long totalCount = forkService.countByForkMaker(forkMaker);
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
    private long getPageCount(BikeType bikeType) {
        long totalCount = forkService.countByBikeType(bikeType);
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
    private long getPageCount(TubeDiameter tubeDiameter) {
        long totalCount = forkService.countByTubeDiameter(tubeDiameter);
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
    private long getPageCount(BrakesType brakesType) {
        long totalCount = forkService.countByBrakesType(brakesType);
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }


}

