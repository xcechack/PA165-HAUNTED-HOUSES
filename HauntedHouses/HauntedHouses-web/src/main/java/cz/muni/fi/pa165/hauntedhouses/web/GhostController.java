package cz.muni.fi.pa165.hauntedhouses.web;

import cz.muni.fi.pa165.hauntedhouses.service.dto.GhostDTO;
import cz.muni.fi.pa165.hauntedhouses.service.services.GhostManager;
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
import org.springframework.dao.DataAccessException;

/**
 *
 * @author Michal Zbranek
 */
@Controller
@RequestMapping("/ghost")
public class GhostController {

    final static Logger log = LoggerFactory.getLogger(PowerController.class);

    @Autowired
    private GhostManager ghostManager; //musi mit stejne jmeno jako v appcontext!!

    @Autowired
    private MessageSource messageSource;

    @ModelAttribute("ghosts")
    public List<GhostDTO> allGhost() {
        log.debug("allGhosts()");
        return ghostManager.getAllGhosts();
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        log.debug("list()");
        model.addAttribute("ghost", new GhostDTO());
        return "ghost/list";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable long id, RedirectAttributes redirectAttributes, Locale locale, UriComponentsBuilder uriBuilder) {
        log.debug("delete({})", id);
        GhostDTO ghost = ghostManager.getGhostById(id);
        ghostManager.deleteGhost(ghost);
        redirectAttributes.addFlashAttribute(
                "message",
                messageSource.getMessage("ghost.delete.message", new Object[]{ghost.getName(), ghost.getInfo()}, locale)
        );
        return "redirect:" + uriBuilder.path("/ghost/list").build();
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update_form(@PathVariable long id, Model model) {
        GhostDTO ghost = ghostManager.getGhostById(id);
        model.addAttribute("power", ghost);
        log.debug("update_form(model={})", model);
        return "power/edit";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute GhostDTO ghost, BindingResult bindingResult, RedirectAttributes redirectAttributes, UriComponentsBuilder uriBuilder, Locale locale) {
        log.debug("update(locale={}, ghost={})", locale, ghost);
        if (bindingResult.hasErrors()) {
            log.debug("binding errors");
            for (ObjectError ge : bindingResult.getGlobalErrors()) {
                log.debug("ObjectError: {}", ge);
            }
            for (FieldError fe : bindingResult.getFieldErrors()) {
                log.debug("FieldError: {}", fe);
            }
        }
        else if (ghost.getId() == null) {
//            try{
                ghostManager.addGhost(ghost);
                redirectAttributes.addFlashAttribute("message",messageSource.getMessage("ghost.add.message", new Object[]{ghost.getName(), ghost.getInfo()}, locale));
//            }catch(Exception ex){
//                    redirectAttributes.addFlashAttribute("message", messageSource.getMessage("ghost.add.error.message", null, locale));
//            }
            
        } else {
            ghostManager.updateGhost(ghost);
            redirectAttributes.addFlashAttribute(
                    "message",
                    messageSource.getMessage("ghost.updated.message", new Object[]{ghost.getName(), ghost.getInfo()}, locale)
            );
        }
        return "redirect:" + uriBuilder.path("/ghost/list").build();
    }

}
