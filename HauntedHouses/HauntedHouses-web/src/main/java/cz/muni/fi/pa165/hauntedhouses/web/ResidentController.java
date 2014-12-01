package cz.muni.fi.pa165.hauntedhouses.web;


import cz.muni.fi.pa165.hauntedhouses.entity.Resident;
import cz.muni.fi.pa165.hauntedhouses.service.dto.ResidentDTO;
import cz.muni.fi.pa165.hauntedhouses.service.services.ResidentManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;
import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author Markéta Kružliaková
 */
@Controller
@RequestMapping("/resident")
public class ResidentController {

    final static Logger log = LoggerFactory.getLogger(ResidentController.class);

    @Autowired
    private ResidentManager residentManager; //musi mit stejne jmeno jako v appcontext!!

    @Autowired
    private MessageSource messageSource;

    @ModelAttribute("resident")
    public ResidentDTO getResident() {
        log.debug("allResidents()");
        return new ResidentDTO();
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        log.debug("list()");
        model.addAttribute("residents", residentManager.getAllResidents());
        return "resident/list";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable long id, RedirectAttributes redirectAttributes, Locale locale, UriComponentsBuilder uriBuilder) {
        log.debug("delete({})", id);
        ResidentDTO resident = residentManager.getResidentById(id);
        residentManager.deleteResident(resident);
        redirectAttributes.addFlashAttribute(
                "message",
                messageSource.getMessage("resident.delete.message", new Object[]{resident.getFirstName(), resident.getLastName()}, locale)
        );
        return "redirect:" + uriBuilder.path("/resident/list").build();
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update_form(@PathVariable long id, Model model) {
        ResidentDTO resident = residentManager.getResidentById(id);
        model.addAttribute("resident", resident);
        log.debug("update_form(model={})", model);
        return "resident/edit";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute("resident") ResidentDTO resident, BindingResult bindingResult, RedirectAttributes redirectAttributes, UriComponentsBuilder uriBuilder, Locale locale) {
        log.debug("update(locale={}, resident={})", locale, resident);
        log.debug("--------------------------------------------------------");
        log.debug("ResidentDTO{" + "id=" + resident.getId() + ", firstName=" + resident.getFirstName() 
                + ", lastName=" + resident.getLastName() + ", age=" + resident.getAge() + '}');
        if (bindingResult.hasErrors()) {
            log.debug("binding errors");
            for (ObjectError ge : bindingResult.getGlobalErrors()) {
                log.debug("ObjectError: {}", ge);
            }
            for (FieldError fe : bindingResult.getFieldErrors()) {
                log.debug("FieldError: {}", fe);
            }
            return resident.getId()==null?"resident/list":"resident/edit";
        }
        if (resident.getId() == null) {
            residentManager.addResident(resident);
            redirectAttributes.addFlashAttribute(
                    "message",
                    messageSource.getMessage("resident.add.message", new Object[]{resident.getFirstName(), resident.getLastName()}, locale)
            );
        } else {
            residentManager.updateResident(resident);
            redirectAttributes.addFlashAttribute(
                    "message",
                    messageSource.getMessage("resident.updated.message", new Object[]{resident.getFirstName(), resident.getLastName()}, locale)
            );
        }
        return "redirect:" + uriBuilder.path("/resident/list").build();
    }

}
