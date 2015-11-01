package com.andrzejpe.spring.web;

import com.andrzejpe.spring.dao.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by jedrek on 2015-11-01.
 */
@Controller
public class FlashAttributeController {


    @RequestMapping(value = "/noflash", method = RequestMethod.GET)
    public String redirectNoFlashAttribute(Model model) {
        User user = new User("panLam", "paslo");
        model.addAttribute(user);
        return "redirect:/user/nouser";
    }

    @RequestMapping(value = "/redUrl", method = RequestMethod.GET)
    public String getRedirectInUrl(Model model) {
        User user = new User("urlUser", "pasloUrl");
        model.addAttribute("pasloUrl", user.getPassword());
        return "redirect:/user/"+ user.getName();
    }

    @RequestMapping(value = "/flashatt", method = RequestMethod.GET)
    public String getFlashAtt(RedirectAttributes redirectAttributes) {
        User user = new User("flashUser", "flashpasslo");
        redirectAttributes.addFlashAttribute("flashUser", user);
        return "redirect:/user/" + user.getName();
    }

    @RequestMapping(value = "/user/{userName}", method = RequestMethod.GET)
    public String userEndpoint(@PathVariable("userName") String userName,
                               @RequestParam(value = "pasloUrl", defaultValue = "no")String pasloUrl,
                               Model model) {
        boolean panLamExists = model.asMap().containsKey("panLam");
        model.addAttribute("panLamExists", panLamExists);

        model.addAttribute("userName", userName);
        model.addAttribute("pasloUrl", pasloUrl);


        return "redirections";
    }
}
