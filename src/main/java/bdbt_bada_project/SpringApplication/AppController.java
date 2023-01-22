package bdbt_bada_project.SpringApplication;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Configuration
public class AppController implements WebMvcConfigurer {


    private PracownicyDAO daoPr;
    private ZwierzetaDAO daoZw;
    private AdoptujacyDAO daoAd;
    private KlatkiDAO daoKl;
    private AdresyDAO daoAdr;

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/main_admin").setViewName("admin/main_admin");
        registry.addViewController("/main_user").setViewName("user/main_user");
    }

    @Controller
    public class DashboardController
    {
        @RequestMapping
                ("/main")
        public String defaultAfterLogin
                (HttpServletRequest request) {
            if
            (request.isUserInRole("ADMIN")) {
                return "redirect:/main_admin";
            }
            else if
            (request.isUserInRole("USER")) {
                return "redirect:/main_user";
            }
            else
            {
                return "redirect:/index";
            }
        }
    }

    @RequestMapping(value={"/main_admin"})
    public String showAdminPage(Model model) {
        return "admin/main_admin";
    }
    @RequestMapping(value={"/main_user"})
    public String showUserPage(Model model) {
        return "user/main_user";
    }
    //user--------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //amdin-------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //pracownicy
    @RequestMapping("/pracownicy_zarzad")
    public String pracownicyView(Model model){
        List<Pracownicy> listPracownicy = daoPr.list();
        model.addAttribute("listPracownicy", listPracownicy);
        return "admin/pracownicy_zarzad";
    }
    @RequestMapping("/edit_pracownicy/{nr_pracownika}")
    public ModelAndView showEditFormPracownicy(@PathVariable(name = "nr_pracownika") int nr_pracownika){
        ModelAndView mav = new ModelAndView("admin/edit_pracownicy");
        Pracownicy pracownicy = daoPr.get(nr_pracownika);
        mav.addObject("pracownicy", pracownicy);

        return mav;
    }
    @RequestMapping(value="/updatePracownicy", method=RequestMethod.POST)
    public String updatePracownicy(@ModelAttribute("pracownicy") Pracownicy pracownicy){
        daoPr.update(pracownicy);

        return "redirect:/pracownicy_zarzad";
    }



}

