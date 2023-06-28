package com.codegym.backend.validation;

import com.codegym.backend.dto.CreateFeedback;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

@Component
public class FeedbackCreateDto implements Validator {
    String regexName = "^[a-zA-Z\'-\'\\sáàảãạăâắằấầặẵẫậéèẻ ẽẹếềểễệóêòỏõọôốồổỗộ ơớờởỡợíìỉĩịđùúủũụưứửữự ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠ ƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼ ỀỂỄỆỈỊỌỎỐỒỔỖỘỚỜỞ ỠỢỤỨỪỬỮỰỲỴÝỶỸửữựỵ ỷỹ]*$";
    String regexEmail = "[a-zA-Z][a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CreateFeedback createFeedback = (CreateFeedback) target;
        String name = createFeedback.getName();
        String email = createFeedback.getEmail();
        String content = createFeedback.getContent();
        if (name == "") {
            errors.rejectValue("name", "name.null", "Tên không được phép trống");
        } else if (!Pattern.compile(regexName).matcher(name).find()) {
            errors.rejectValue("name", "name.pattern", "Tên không chứa số hoặc kí tự đặc biệt");
        }
        if (email == "") {
            errors.rejectValue("email", "email.null", "Email không được phép trống");
        } else if (!Pattern.compile(regexEmail).matcher(email).find()) {
            errors.rejectValue("email", "email.pattern", "Email không đúng định dạng");
        }
        if (content == "") {
            errors.rejectValue("content", "content.null", "Nội dung phản hồi không được phép trống");
        } else if (content.length() < 10) {
            errors.rejectValue("content", "content.length", "Nội dung phản hồi dài hơn 10 kí tự");
        } else if (content.length() > 1000) {
            errors.rejectValue("content", "content.length", "Nội dung phản hồi nhỏ hơn 1000 kí tự");
        }
    }
}

