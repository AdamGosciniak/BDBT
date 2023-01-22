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
    //adoptujacy
    @RequestMapping("/adoptujacy")
    public String adoptujacyView(Model model){
        List<Adoptujacy> listAdoptujacy = daoAd.listAdmin();
        model.addAttribute("listAdoptujacy", listAdoptujacy);
        return "admin/adoptujacy";
    }
    @RequestMapping("/edit_adoptujacy/{nr_adoptujacego}")
    public ModelAndView showEditFormAdoptujacy(@PathVariable(name = "nr_adoptujacego") int nr_adoptujacego){
        ModelAndView mav = new ModelAndView("admin/edit_pracownicy");
        Adoptujacy adoptujacy = daoAd.get(nr_adoptujacego);
        mav.addObject("adoptujacy", adoptujacy);

        return mav;
    }
    @RequestMapping(value="/updateAdoptujacy", method=RequestMethod.POST)
    public String updateAdoptujacy(@ModelAttribute("adoptujacy") Adoptujacy adoptujacy){
        daoAd.update(adoptujacy);

        return "redirect:/adoptujacy";
    }

    //adresy
    @RequestMapping("/adresy")
    public String adresyView(Model model){
        List<Adresy> listAdresy = daoAdr.list();
        model.addAttribute("listAdresy", listAdresy);
        return "admin/adresy";
    }
    @RequestMapping("/edit_adresy/{nr_adresu}")
    public ModelAndView showEditFormAdresy(@PathVariable(name = "nr_adresu") int nr_adresu){
        ModelAndView mav = new ModelAndView("admin/edit_pracownicy");
        Adresy adresy = daoAdr.get(nr_adresu);
        mav.addObject("adresy", adresy);

        return mav;
    }
    @RequestMapping(value="/updateAdresy", method=RequestMethod.POST)
    public String updateAdresy(@ModelAttribute("adresy") Adresy adresy){
        daoAdr.update(adresy);

        return "redirect:/adresy";
    }

    //klatki
    @RequestMapping("/klatki")
    public String klatkiView(Model model){
        List<Klatki> listStudia = daoKl.list();
        model.addAttribute("listStudia", listStudia);
        return "admin/klatki";
    }
    @RequestMapping("/edit_klatki/{nr_klatki}")
    public ModelAndView showEditFormStudia(@PathVariable(name = "nr_klatki") int nr_klatki){
        ModelAndView mav = new ModelAndView("admin/edit_klatki");
        Klatki klatki = daoKl.get(nr_klatki);
        mav.addObject("klatki", klatki);

        return mav;
    }
    @RequestMapping(value="/updateKlatki", method=RequestMethod.POST)
    public String updateStudia(@ModelAttribute("klatki") Klatki klatki){
        daoKl.update(klatki);

        return "redirect:/klatki";
    }

    //pracownicy
    @RequestMapping("/pracownicy")
    public String pracownicyView(Model model){
        List<Pracownicy> listPracownicy = daoPr.list();
        model.addAttribute("listPracownicy", listPracownicy);
        return "admin/pracownicy";
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

        return "redirect:/pracownicy";
    }

    //zwierzeta
    @RequestMapping("/zwierzeta")
    public String zwierzetaView(Model model){
        List<Zwierzeta> listZwierzeta = daoZw.list();
        model.addAttribute("listZwierzeta", listZwierzeta);
        return "admin/zwierzeta";
    }
   // @RequestMapping("/new_zwierzeta")
   // public String showNewFormZwierzeta(Model model) {
   //     Zwierzeta zwierzeta = new Zwierzeta();
   //     model.addAttribute("zwierzeta", zwierzeta);
   //     return "admin/new_zwierzeta";
   // }
    // tutaj coś nie działa
    // ogólnie więcej nie mam pomysłu jak zrobić

    @RequestMapping(value="/saveZwierzeta", method=RequestMethod.POST)
    public String saveZwierzeta(@ModelAttribute("zwierzeta") Zwierzeta zwierzeta){
        daoZw.save(zwierzeta);
        return "redirect:/zwierzeta";
    }
    @RequestMapping("/edit_zwierzeta/{nr_zwierzecia}")
    public ModelAndView showEditFormZwierzeta(@PathVariable(name = "nr_zwierzecia") int nr_zwierzecia){
        ModelAndView mav = new ModelAndView("admin/edit_sprzety");
        Zwierzeta zwierzeta = daoZw.get(nr_zwierzecia);
        mav.addObject("zwierzeta", zwierzeta);

        return mav;
    }
    @RequestMapping(value="/updateZwierzeta", method=RequestMethod.POST)
    public String updateZwierzeta(@ModelAttribute("zwierzeta") Zwierzeta zwierzeta){
        daoZw.update(zwierzeta);

        return "redirect:/zwierzeta";
    }

    @RequestMapping("/delete/{nr_zwierzecia}")
    public String deleteZwierzeta(@PathVariable(name = "nr_zwierzecia") int nr_zwierzecia){
        daoZw.delete(nr_zwierzecia);

        return "redirect:/zwierzeta";
    }


}

