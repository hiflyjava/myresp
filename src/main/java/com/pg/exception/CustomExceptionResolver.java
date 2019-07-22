package com.pg.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by harden yan on 2019/6/17.
 */
@Component
public class CustomExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse response, Object o, Exception e) {
        ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
        Map<String, Object> map = new HashMap<>();

            map.put("status", 500);
            map.put("msg", e.toString());

        mv.addAllObjects(map);
        return mv;
    }

}