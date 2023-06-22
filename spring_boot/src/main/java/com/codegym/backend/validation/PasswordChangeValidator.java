package com.codegym.backend.validation;

import com.codegym.backend.dto.AccountDTO;
import com.codegym.backend.service.impl.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

public class PasswordChangeValidator implements Validator {

    @Autowired
    AccountService accountService;
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        AccountDTO accountDTO = (AccountDTO) target;
        if (accountDTO.getCurrentPassword() == null){
            errors.rejectValue("currentPassword", "currentPassword.null","Mật khẩu hiện tại không được để trống");
        }
        if (accountDTO.getNewPassword() == null){
            errors.rejectValue("newPassword", "newPassword.null","Mật khẩu mới không được để trống");
        }else if (!Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[@$!%*?&-_])[A-Za-z@$!%*?&-_]{6,}$").matcher(accountDTO.getNewPassword()).find()){
            errors.rejectValue("newPassword", "newPassword.pattern", "Từ 8 -15 ký tự, gồm chữ thường, chữ hoa, ký tự đặc biệt");

        }
    }
}
