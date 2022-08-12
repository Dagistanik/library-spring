package com.library.controller;

import com.library.project.Library;
import com.library.project.products.Periodical;
import com.library.project.random.MothsOfYear;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/periodical")
public class PeriodicalController {
    Library library = Library.getInstance();

    @GetMapping("/list")
    public String periodicals(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("periodicals", library.getPeriodicals());
        return "view-periodicals";
    }
    @GetMapping("/add")
    public String addPeriodicalView(HttpServletRequest req, HttpServletResponse resp) {
        return "add-periodical";
    }
    @PostMapping("/add")
    public String addPeriodicals(
            @RequestParam(name = "id") String id,
            @RequestParam(name = "title") String title,
            @RequestParam(name = "month", required = false) MothsOfYear month,
            HttpServletRequest peq, HttpServletResponse resp) {

        Periodical periodical = new Periodical(
                NumberUtils.toInt(id),
                title,
                month);
        System.out.println("abc");
        library.add(periodical);

        return "redirect:list";
    }
}
