package calculator.controllers;

import calculator.dao.ResultDAO;
import calculator.logic.CalcKt;
import calculator.models.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import calculator.logic.MainKt;



@Controller
public class FirstController {

    @Autowired
    private ResultDAO resultDAO;

    @GetMapping("/")
    public String firstPage() {
        return "firstpage";
    }
    @GetMapping("/calc")
    public String newExpression(@ModelAttribute("result") Result result) {
        return "calculate";
    }

    @PostMapping
    public String create(Result result) {
        result.setAnswer(MainKt.Calculation(result.getExpression()));

        resultDAO.addResult(result);
        return "redirect:/results";
    }

    @GetMapping("/results")
    public String results(Model model) {
        model.addAttribute("resultsList",resultDAO.getResults());
        return "results";
    }
}
