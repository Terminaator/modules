package paul.liibert.modules.mvc.error;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import paul.liibert.modules.mvc.dto.ErrorDTO;
import paul.liibert.modules.mvc.error.type.InvalidValueException;
import paul.liibert.modules.mvc.error.type.NoSuchValueException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(value = {NoSuchValueException.class})
    protected ModelAndView NoSuchValueExceptionHandle(
            NoSuchValueException ex, Model model) {
        model.addAttribute("error", new ErrorDTO(ex.getMessage()));
        return new ModelAndView("forward:/");
    }

    @ExceptionHandler(value = {InvalidValueException.class})
    protected ModelAndView InvalidValueExceptionHandle(
            InvalidValueException ex, Model model) {
        return new ModelAndView("redirect:/module/" + ex.getModule());
    }
}
