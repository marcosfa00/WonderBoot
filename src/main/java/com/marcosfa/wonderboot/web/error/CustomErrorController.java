package com.marcosfa.wonderboot.web.error;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class CustomErrorController implements ErrorController {
    @RequestMapping("/error")
    String error(final HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status != null) {
            HttpStatus httpStatus = HttpStatus.resolve((Integer) status);
            if (httpStatus == HttpStatus.NOT_FOUND) {
                return "error-404";
            } else if (httpStatus == HttpStatus.FORBIDDEN) {
                return "error-403";
            }
        }
        return "error";
    }

}
