package my.test.spring.boot.controller;

import my.test.spring.boot.mapper.DialogMapper;
import my.test.spring.boot.model.DialogModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class DialogController {

    @Inject
    private DialogMapper dialogMapper;

    @RequestMapping("/dialog/save")
    public String saveDialog(HttpServletRequest request) {
        String dialog = request.getParameter("dialog");
        dialogMapper.insert(dialog);
        return "redirect:/dialog/index";
    }

    @RequestMapping("/dialog/index")
    public String selectAll(Model model) {
        List<DialogModel> list = dialogMapper.selectAll();
        model.addAttribute("list",list);
        return "dialog/index";
    }

    @RequestMapping("/dialog/delete")
    public String delete(Integer id) {
        dialogMapper.delete(id);
        return "redirect:/dialog/index";
    }

}
