package org.dav1nci.faq;

import org.dav1nci.dbservice.FAQEntity;
import org.dav1nci.dbservice.serviceimplementation.FAQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by dav1nci on 31.10.15.
 */
@Controller
@ComponentScan("org.dav1nci.faq")
public class FAQController
{
    @Autowired
    private FAQService faqService;
    /*@Inject
    private IPagination pagination;*/

    @RequestMapping(value = "/faq", method = RequestMethod.GET)
    public String faq(Model model)
    {
        /*Page<FAQEntity> page = faqService.getContent(pageNumber);
        int current = page.getNumber();
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, page.getTotalPages());*/
        model.addAttribute("unit", new FAQEntity());
        model.addAttribute("page", faqService.getContent());
        /*model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);*/
        return "faq/faq";
    }
}
