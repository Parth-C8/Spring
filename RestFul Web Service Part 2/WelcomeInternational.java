package com.example.restfulWebServiceTwo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class WelcomeInternational {

    @Autowired
    private MessageSource messageSource;

    @GetMapping(path="/morning-user")
    public String helloUser()
    {
        return messageSource.getMessage("morning.message",null, LocaleContextHolder.getLocale());
    }
    @GetMapping(path="/hello-user/{name}")
    public String helloWorldInternationalized(
            @RequestHeader(name="Accept-Language",required = false)Locale locale,@PathVariable String name)
    {
        final String[] params = new String[]{name};
        return messageSource.getMessage("hello.user",params,locale);
    }
}
