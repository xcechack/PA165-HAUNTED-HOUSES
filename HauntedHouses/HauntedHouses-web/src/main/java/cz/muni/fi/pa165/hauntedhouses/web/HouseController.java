package cz.muni.fi.pa165.hauntedhouses.web;

import cz.muni.fi.pa165.hauntedhouses.service.dto.HouseDTO;
import cz.muni.fi.pa165.hauntedhouses.service.services.HouseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author Michal Zbranek
 */
@Controller
@RequestMapping("/house")
public class HouseController {

    final static Logger log = LoggerFactory.getLogger(PowerController.class);
    
    @Autowired
    HouseManager houseManager;
    @Autowired
    MessageSource messageSource;

    @ModelAttribute("houses")
    public List<HouseDTO> allHouses() {
        log.debug("allGhosts()");
        return houseManager.getAllHouses();
    }
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        log.debug("list()");
        model.addAttribute("ghost", new HouseDTO());
        return "house/list";
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable long id, RedirectAttributes redirectAttributes, Locale locale, UriComponentsBuilder uriBuilder) {
        log.debug("delete({})", id);
        HouseDTO house = houseManager.getHouseById(id);
        houseManager.deleteHouse(house);
        redirectAttributes.addFlashAttribute(
                "message",
                messageSource.getMessage("house.delete.message", new Object[]{house.getName(), house.getHistory()}, locale)
        );
        return "redirect:" + uriBuilder.path("/house/list").build();
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update_form(@PathVariable long id, Model model) {
        HouseDTO house = houseManager.getHouseById(id);
        model.addAttribute("house", house);
        log.debug("update_form(model={})", model);
        return "house/edit";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute HouseDTO house, BindingResult bindingResult, RedirectAttributes redirectAttributes, UriComponentsBuilder uriBuilder, Locale locale) {
        log.debug("update(locale={}, house={})", locale, house);
        if (bindingResult.hasErrors()) {
            log.debug("binding errors");
            for (ObjectError ge : bindingResult.getGlobalErrors()) {
                log.debug("ObjectError: {}", ge);
            }
            for (FieldError fe : bindingResult.getFieldErrors()) {
                log.debug("FieldError: {}", fe);
            }
        }
        else if (house.getId() == null) {
//            try{
                houseManager.addHouse(house);
                redirectAttributes.addFlashAttribute("message",messageSource.getMessage("house.add.message", new Object[]{house.getName(), house.getHistory()}, locale));
//            }catch(Exception ex){
//                    redirectAttributes.addFlashAttribute("message", messageSource.getMessage("ghost.add.error.message", null, locale));
//            }
            
        } else {
            houseManager.updateHouse(house);
            redirectAttributes.addFlashAttribute(
                    "message",
                    messageSource.getMessage("house.updated.message", new Object[]{house.getName(), house.getHistory()}, locale)
            );
        }
        return "redirect:" + uriBuilder.path("/house/list").build();
    }
}