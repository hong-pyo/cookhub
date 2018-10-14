package com.hong.cookhub.controller;

import com.hong.cookhub.model.AccountCreateForm;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by hong2 on 2018. 10. 14.
 * Time : PM 5:29
 */

@Controller
@RequestMapping("/accounts")
@SessionAttributes(types = AccountCreateForm.class)
public class AccountCreateController {

    @ModelAttribute("accountCreateForm")
    public AccountCreateForm setUpAccountCreateForm() {
        return new AccountCreateForm();
    }

    @RequestMapping(path = "create", method = RequestMethod.POST)
    public String create(@Validated AccountCreateForm from, BindingResult result,
                         @ModelAttribute("password") String password,
                         RedirectAttributes redirectAttributes) {
        return "redirect:/accounts/create?complete";
    }

    @RequestMapping(path = "create", params = "complete", method = RequestMethod.GET)
    public String createComplete(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "account/createComplete";
    }
}
