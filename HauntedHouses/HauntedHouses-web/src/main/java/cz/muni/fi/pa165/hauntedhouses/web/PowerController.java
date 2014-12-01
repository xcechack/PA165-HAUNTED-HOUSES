package cz.muni.fi.pa165.hauntedhouses.web;

import cz.muni.fi.pa165.hauntedhouses.service.dto.PowerDTO;
import cz.muni.fi.pa165.hauntedhouses.service.services.PowerManager;
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
 * @author Michal Zbranek
 */
@Controller
@RequestMapping("/power")
public class PowerController {

    final static Logger log = LoggerFactory.getLogger(PowerController.class);

    @Autowired
    private PowerManager powerManager; //musi mit stejne jmeno jako v appcontext!!

    @Autowired
    private MessageSource messageSource;

    @ModelAttribute("powers")
    public List<PowerDTO> allPower() {
        log.debug("allPowers()");
        return powerManager.getAllPowers();
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        log.debug("list()");
        model.addAttribute("power", new PowerDTO());
        return "power/list";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable long id, RedirectAttributes redirectAttributes, Locale locale, UriComponentsBuilder uriBuilder) {
        log.debug("delete({})", id);
        PowerDTO power = powerManager.getPowerById(id);
        powerManager.deletePower(power);
        redirectAttributes.addFlashAttribute(
                "message",
                messageSource.getMessage("power.delete.message", new Object[]{power.getName(), power.getDescription()}, locale)
        );
        return "redirect:" + uriBuilder.path("/power/list").build();
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update_form(@PathVariable long id, Model model) {
        PowerDTO power = powerManager.getPowerById(id);
        model.addAttribute("power", power);
        log.debug("update_form(model={})", model);
        return "power/edit";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute PowerDTO power, BindingResult bindingResult, RedirectAttributes redirectAttributes, UriComponentsBuilder uriBuilder, Locale locale) {
        log.debug("update(locale={}, power={})", locale, power);
        if (bindingResult.hasErrors()) {
            log.debug("binding errors");
            for (ObjectError ge : bindingResult.getGlobalErrors()) {
                log.debug("ObjectError: {}", ge);
            }
            for (FieldError fe : bindingResult.getFieldErrors()) {
                log.debug("FieldError: {}", fe);
            }
            return power.getId()==null?"power/list":"power/edit";
        }
        if (power.getId() == null) {
            powerManager.addPower(power);
            redirectAttributes.addFlashAttribute(
                    "message",
                    messageSource.getMessage("power.add.message", new Object[]{power.getName(), power.getDescription()}, locale)
            );
        } else {
            powerManager.updatePower(power);
            redirectAttributes.addFlashAttribute(
                    "message",
                    messageSource.getMessage("power.updated.message", new Object[]{power.getName(), power.getDescription()}, locale)
            );
        }
        return "redirect:" + uriBuilder.path("/power/list").build();
    }

}
