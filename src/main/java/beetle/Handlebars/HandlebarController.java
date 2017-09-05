package beetle.Handlebars;

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
import beetle.Forks.ForkService;
import beetle.Forks.TubeDiameter;

import java.util.List;

/**
 * Created by VitaliiZhuk on 03.06.2017.
 */
@Controller
public class HandlebarController {
    static final int DEFAULT_GROUP_ID = -1;
    static final int ITEMS_PER_PAGE = 6;


    @Autowired
    private HandlebarService handlebarService;
    @Autowired
    private ForkService forkService;








    @RequestMapping("/show_handlebarsComponents")
    public String brakesComponentsVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;

        return "handlebarsComponents";
    }

    @RequestMapping("/show_handlebarsAdmin")
    public String handlebarsAdminVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;

        List<Handlebar> handlebars = handlebarService
                .findAll(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        List<Winding> windings = handlebarService
                .findAllTwo(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));

        List<Grips> grips = handlebarService
                .findAllThree(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        List<Headset> headsets = handlebarService
                .findAllFor(new PageRequest(page,ITEMS_PER_PAGE,Sort.Direction.DESC,"id"));
        List<Stem> stems = handlebarService
                .findAllFive(new PageRequest(page,ITEMS_PER_PAGE,Sort.Direction.DESC,"id"));



        model.addAttribute("handlebarMakers", handlebarService.findHandlebarMakers());

        model.addAttribute("bikeType", handlebarService.findBikeType());

        model.addAttribute("handlebarDiameter", handlebarService.findHandlebarDiameter());


        model.addAttribute("tubeDiameter", forkService.findTubeDiameter());
        model.addAttribute("headsetType", handlebarService.findHeadsetType());

        model.addAttribute("handlebars", handlebars);
        model.addAttribute("windings", windings);
        model.addAttribute("grips", grips);
        model.addAttribute("headsets", headsets);
        model.addAttribute("stems", stems);

        model.addAttribute("allPages", getPageCount());

        return "handlebarsAdmin";
    }

    @RequestMapping("/show_handlebars")
    public String handlebarsVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;

        List<Handlebar> handlebars = handlebarService
                .findAll(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));


        model.addAttribute("handlebarMakers", handlebarService.findHandlebarMakers());
        model.addAttribute("bikeType", handlebarService.findBikeType());
        model.addAttribute("handlebarDiameter", handlebarService.findHandlebarDiameter());
        model.addAttribute("handlebars", handlebars);
        model.addAttribute("allPages", getPageCount());

        return "handlebars";
    }


    @RequestMapping("/show_stems")
    public String stemsVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;

        List<Stem> stems = handlebarService
                .findAllFive(new PageRequest(page,ITEMS_PER_PAGE,Sort.Direction.DESC,"id"));

        model.addAttribute("handlebarMakers", handlebarService.findHandlebarMakers());
        model.addAttribute("handlebarDiameter", handlebarService.findHandlebarDiameter());
        model.addAttribute("tubeDiameter", forkService.findTubeDiameter());
        model.addAttribute("headsetType", handlebarService.findHeadsetType());
        model.addAttribute("stems", stems);

        model.addAttribute("allPages", getPageCount());

        return "stems";
    }
    @RequestMapping("/show_windings")
    public String windingsVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;

        List<Winding> windings = handlebarService
                .findAllTwo(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));

        model.addAttribute("handlebarMakers", handlebarService.findHandlebarMakers());
        model.addAttribute("windings", windings);
        model.addAttribute("allPages", getPageCount());

        return "windings";
    }

    @RequestMapping("/show_headsets")
    public String headsetsVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;

        List<Headset> headsets = handlebarService
                .findAllFor(new PageRequest(page,ITEMS_PER_PAGE,Sort.Direction.DESC,"id"));

        model.addAttribute("handlebarMakers", handlebarService.findHandlebarMakers());
        model.addAttribute("tubeDiameter", forkService.findTubeDiameter());
        model.addAttribute("headsetType", handlebarService.findHeadsetType());
        model.addAttribute("headsets", headsets);
        model.addAttribute("allPages", getPageCount());

        return "headsets";
    }
    @RequestMapping("/show_grips")
    public String gripsVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;

        List<Grips> grips = handlebarService
                .findAllThree(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));

        model.addAttribute("handlebarMakers", handlebarService.findHandlebarMakers());
        model.addAttribute("grips", grips);
        model.addAttribute("allPages", getPageCount());

        return "grips";
    }



    @RequestMapping("/handlebars_add_page")
    public String contactAddPage(Model model) {

        model.addAttribute("handlebarMakers", handlebarService.findHandlebarMakers());

        model.addAttribute("bikeType", handlebarService.findBikeType());

        model.addAttribute("handlebarDiameter", handlebarService.findHandlebarDiameter());


        model.addAttribute("tubeDiameter", forkService.findTubeDiameter());

        return "handlebars_add_page";
    }

    @RequestMapping("/winding_add_page")
    public String windingAddPage(Model model) {

        model.addAttribute("handlebarMakers", handlebarService.findHandlebarMakers());
        return "winding_add_page";
    }

    @RequestMapping("/grips_add_page")
    public String gripsAddPage(Model model) {

        model.addAttribute("handlebarMakers", handlebarService.findHandlebarMakers());
        return "grips_add_page";
    }

    @RequestMapping("/headset_add_page")
    public String headsetAddPage(Model model) {

        model.addAttribute("handlebarMakers", handlebarService.findHandlebarMakers());
        model.addAttribute("headsetType", handlebarService.findHeadsetType());

        model.addAttribute("tubeDiameter", forkService.findTubeDiameter());
        return "headset_add_page";
    }

    @RequestMapping("/stem_add_page")
    public String stemAddPage(Model model) {

        model.addAttribute("handlebarMakers", handlebarService.findHandlebarMakers());
        model.addAttribute("handlebarDiameter", handlebarService.findHandlebarDiameter());

        model.addAttribute("tubeDiameter", forkService.findTubeDiameter());
        return "stem_add_page";
    }


    @RequestMapping("/handlebarMaker_add_page")
    public String handlebarMakerAddPage() {
        return "handlebarMaker_add_page";
    }

    @RequestMapping("/handlebarMaker/{id}")
    public String listHandlebarMaker(
            @PathVariable(value = "id") long handlebarMakerId,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        HandlebarMaker handlebarMaker = (handlebarMakerId != DEFAULT_GROUP_ID) ? handlebarService.findHandlebarMaker(handlebarMakerId) : null;


        if (page < 0) page = 0;

        List<Handlebar> handlebars = handlebarService
                .findByHandlebarMakers(handlebarMaker, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));


        model.addAttribute("handlebarMakers", handlebarService.findHandlebarMakers());

        model.addAttribute("handlebars", handlebars);

        model.addAttribute("byHandlebarMakerPages", getPageCount(handlebarMaker));

        model.addAttribute("groupId", handlebarMakerId);

        return "handlebars";
    }


    @RequestMapping(value = "/handlebar/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> delete(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            handlebarService.deleteHandlebar(toDelete);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value = "/winding/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteOne(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            handlebarService.deleteWinding(toDelete);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value = "/grips/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteTwo(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            handlebarService.deleteGrips(toDelete);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value = "/headset/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteThree(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            handlebarService.deleteHeadset(toDelete);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/stem/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteFor(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            handlebarService.deleteHeadset(toDelete);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @RequestMapping(value="/handlebar/add", method = RequestMethod.POST)
    public String handlebarAdd(
            @RequestParam(value = "handlebarMaker") long handlebarMakerId,
            @RequestParam Long article,
            @RequestParam String url,
            @RequestParam String name,
            @RequestParam(value = "bikeType") long bikeTypeId,
            @RequestParam String handlebarWide,
            @RequestParam(value = "handlebarDiameter") long handlebarDiameterId,
            @RequestParam String handlebarHeight,
            @RequestParam String material,
            @RequestParam String weight,
            @RequestParam String color,
            @RequestParam Double price,
            @RequestParam String description,
            @RequestParam String way)
    {
        HandlebarMaker handlebarMaker = (handlebarMakerId != DEFAULT_GROUP_ID) ? handlebarService.findHandlebarMaker(handlebarMakerId) : null;
        BikeType bikeType = (bikeTypeId != DEFAULT_GROUP_ID) ? handlebarService.findBikeType(bikeTypeId) : null;
        HandlebarDiameter handlebarDiameter = (handlebarDiameterId != DEFAULT_GROUP_ID) ? handlebarService.findHandlebarDiameter(handlebarDiameterId) : null;
        Handlebar handlebar = new Handlebar(handlebarMaker,article, url,  name, bikeType, handlebarWide, handlebarDiameter, handlebarHeight,material,weight, color ,
                 price, description, way);


        handlebarService.addHandlebar(handlebar);

        return "redirect:/show_handlebars";
    }


    @RequestMapping(value="/winding/add", method = RequestMethod.POST)
    public String windingAdd(
            @RequestParam(value = "handlebarMaker") long handlebarMakerId,
            @RequestParam String name,
            @RequestParam String length,
            @RequestParam String wide,
            @RequestParam String material,
            @RequestParam String color,
            @RequestParam Double price,
            @RequestParam String description,
            @RequestParam String way)
    {
        HandlebarMaker handlebarMaker = (handlebarMakerId != DEFAULT_GROUP_ID) ? handlebarService.findHandlebarMaker(handlebarMakerId) : null;
        Winding winding = new Winding(handlebarMaker,  name, length, wide, material, color ,
                price, description, way);


        handlebarService.addWinding(winding);

        return "redirect:/show_handlebars";
    }

    @RequestMapping(value="/headset/add", method = RequestMethod.POST)
    public String headsetAdd(
            @RequestParam(value = "handlebarMaker") long handlebarMakerId,
            @RequestParam String name,
            @RequestParam(value = "headsetType") long headsetTypeId,
            @RequestParam (value = "tubeDiameter") long tubeDiameterId,
            @RequestParam String material,
            @RequestParam String size,
            @RequestParam String color,
            @RequestParam Double price,
            @RequestParam String description,
            @RequestParam String way)
    {
        HandlebarMaker handlebarMaker = (handlebarMakerId != DEFAULT_GROUP_ID) ? handlebarService.findHandlebarMaker(handlebarMakerId) : null;
        HeadsetType headsetType = (headsetTypeId != DEFAULT_GROUP_ID) ?  handlebarService.findHeadsetType(headsetTypeId) : null;
        TubeDiameter tubeDiameter = (tubeDiameterId != DEFAULT_GROUP_ID) ?  forkService.findTubeDiameter(tubeDiameterId) : null;
        Headset headset = new Headset(handlebarMaker,  name, headsetType, tubeDiameter, material,size, color ,
                price, description, way);


        handlebarService.addHeadset(headset);

        return "redirect:/show_handlebars";
    }
    @RequestMapping(value="/stem/add", method = RequestMethod.POST)
    public String stemAdd(
            @RequestParam(value = "handlebarMaker") long handlebarMakerId,
            @RequestParam String name,
            @RequestParam String angle,
            @RequestParam(value = "handlebarDiameter") long handlebarDiameterId,
            @RequestParam (value = "tubeDiameter") long tubeDiameterId,
            @RequestParam String material,
            @RequestParam String length,
            @RequestParam String color,
            @RequestParam Double price,
            @RequestParam String description,
            @RequestParam String way)
    {
        HandlebarMaker handlebarMaker = (handlebarMakerId != DEFAULT_GROUP_ID) ? handlebarService.findHandlebarMaker(handlebarMakerId) : null;
        HandlebarDiameter handlebarDiameter = (handlebarDiameterId != DEFAULT_GROUP_ID) ? handlebarService.findHandlebarDiameter(handlebarDiameterId) : null;
        TubeDiameter tubeDiameter = (tubeDiameterId != DEFAULT_GROUP_ID) ?  forkService.findTubeDiameter(tubeDiameterId) : null;
        Stem stem = new Stem(handlebarMaker,  name, angle, handlebarDiameter, tubeDiameter, material,length, color ,
                price, description, way);


        handlebarService.addStem(stem);

        return "redirect:/show_handlebars";
    }

    @RequestMapping(value="/grips/add", method = RequestMethod.POST)
    public String gripsAdd(
            @RequestParam(value = "handlebarMaker") long handlebarMakerId,
            @RequestParam String name,
            @RequestParam String length,
            @RequestParam String weight,
            @RequestParam String material,
            @RequestParam String color,
            @RequestParam Double price,
            @RequestParam String description,
            @RequestParam String way)
    {
        HandlebarMaker handlebarMaker = (handlebarMakerId != DEFAULT_GROUP_ID) ? handlebarService.findHandlebarMaker(handlebarMakerId) : null;
        Grips grips = new Grips(handlebarMaker,  name, length, weight, material, color ,
                price, description, way);


        handlebarService.addGrips(grips);

        return "redirect:/show_handlebars";
    }

    @RequestMapping(value="/handlebarMaker/add", method = RequestMethod.POST)
    public String handlebarMakerAdd(@RequestParam String name) {
        handlebarService.addHandlebarMaker(new HandlebarMaker(name));
        return "redirect:/show_handlebars";
    }





    private long getPageCount() {
        long totalCount = handlebarService.count();
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }

    private long getPageCount(HandlebarMaker handlebarMaker) {
        long totalCount = handlebarService.countByHandlebarMaker(handlebarMaker);
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
    private long getPageCount(BikeType bikeType) {
        long totalCount = handlebarService.countByBikeType(bikeType);
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
    private long getPageCount(HandlebarDiameter handlebarDiameter) {
        long totalCount = handlebarService.countByHandlebarDiameter(handlebarDiameter);
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }


}
