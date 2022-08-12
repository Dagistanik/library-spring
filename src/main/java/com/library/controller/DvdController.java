package com.library.controller;

import com.library.project.Library;
import com.library.project.products.DVD;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/dvd")
public class DvdController {
    Library library = Library.getInstance();

    @GetMapping("/list")
    public String dvds(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("dvds", library.getDvds());
        return "view-dvds";
    }

    @GetMapping("/add")
    public String addDvdView(HttpServletResponse resp, HttpServletRequest req) {
        return "add-dvd";
    }

    @PostMapping("/add")
    public String addDvd(
            @RequestParam(name="id",required = true) String id,
            @RequestParam(name="title",required = true) String title,
            @RequestParam(name="size",required = true) String size,
            HttpServletRequest req, HttpServletResponse resp) {
        DVD dvd = new DVD(
                NumberUtils.toInt(id),
                title,
                NumberUtils.toInt(size));
        library.add(dvd);

        return "redirect:list";
    }
}
