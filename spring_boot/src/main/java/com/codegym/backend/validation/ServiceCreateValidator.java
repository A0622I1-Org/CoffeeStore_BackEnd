package com.codegym.backend.validation;

import com.codegym.backend.dto.CServiceDto;
import com.codegym.backend.dto.UserDTO;
import com.codegym.backend.service.IServiceService;
import com.codegym.backend.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

@Component
public class ServiceCreateValidator implements Validator {
    @Autowired
    private IServiceService service;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CServiceDto serviceDto = (CServiceDto) target;
        System.out.println(target);
        List<CServiceDto> listService = service.findAllForRegister();
        String price = "price";
        String name = "name";
        if (serviceDto.getName() == null) {
            errors.rejectValue(name, name +".null", "Vui lòng nhập tên món.");
        }else if (listService.contains(serviceDto)) {
            errors.rejectValue(name, name +".duplicate", "Tên món đã tồn tại.");
        }else if (!Pattern.compile("^[a-zA-Z0-9]+$").matcher(serviceDto.getName()).find()) {
            errors.rejectValue(name, name +".format", "Tên món không được nhập ký tự đặt biệt.");
        } else if (serviceDto.getName().length() < 6 && serviceDto.getName().length() > 40) {
            errors.rejectValue(name, name +".length", "Tên món phải có độ dài là từ 6 đến 40 ký tự");
        }
        if (serviceDto.getPrice() == null) {
            errors.rejectValue(price, price +".null", "Vui lòng nhập đơn giá.");
        } else if (serviceDto.getPrice() < 1) {
            errors.rejectValue(price, price +".min", "Đơn giá phải lớn hơn 0.");
        } else if (serviceDto.getPrice() > 1000000000) {
            errors.rejectValue(price, price +".max", "Đơn giá quá lớn.");
        }

    }
}
