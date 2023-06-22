package com.codegym.backend.validation;


import com.codegym.backend.dto.UserDTO;
import com.codegym.backend.dto.UserDTOID;
import com.codegym.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Date;
import java.util.regex.Pattern;


@Component
public class UserCreateByRequestDtoValidator implements Validator {
    @Autowired
    private UserService userService;
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }
    @Override
    public void validate(Object target, Errors errors) {
        UserDTO userDTO = (UserDTO) target;
        Date date = new Date();
        String[] dateSplit = userDTO.getBirthday().split("-");
        dateSplit[0] = String.valueOf(Integer.parseInt(dateSplit[0]) - 1900);
        Date birthday = new Date(Integer.parseInt(dateSplit[0]), Integer.parseInt(dateSplit[1]) - 1, Integer.parseInt(dateSplit[2]));
        if (userDTO.getName() == null) {
            errors.rejectValue("name", "name.null", "Tên không được để trống");
        } else if (userDTO.getName().length() < 6) {
            errors.rejectValue("name", "name.length", "Tên phải lơn hơn 6 ký tự");
        } else if (!Pattern.compile("^[a-zA-ZàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ]+(\\s[a-zA-ZàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ]+)*$").matcher(userDTO.getName()).find()) {
            errors.rejectValue("name", "name.pattern", "Tên phải đúng định dạng");
        }
        if (userDTO.getBirthday() == null) {
            errors.rejectValue("birthday", "birthday.null", "Ngày sinh không được để trống");
        } else if (((date.getTime()) - (birthday.getTime())) / 1000 / 60 / 60 / 24 < 6570 || ((date.getTime()) - (birthday.getTime())) / 1000 / 60 / 60 / 24 > 36525) {
            errors.rejectValue("birthday", "birthday.format", "Ngày sinh phải từ 18 tuổi đến 100 tuổi");
        }
        if (userDTO.getAddress().length() > 100) {
            errors.rejectValue("address", "address.length", "Địa chỉ phải nhỏ hơn 100 ký tự");
        }
        if (userDTO.getPhoneNumber() == null) {
            errors.rejectValue("phone_number", "phone_number.null", "Số địa thoại không được để trống");
        } else if (!Pattern.compile("^(\\\\+?84|0)(3[2-9]|5[689]|7[0|6-9]|8[1-9]|9[0-9])[0-9]{7}$").matcher(userDTO.getPhoneNumber()).find()) {
            errors.rejectValue("phone_number", "phone_number.format", "Vui lòng nhập số địa thoại đúng định dạng 090xxxxxxx or 091xxxxxxx or (84) + 90xxxxxxx or (84) + 91xxxxxxx");
        } else if (userService.findByPhone(userDTO.getPhoneNumber()) > 0) {
            errors.rejectValue("phone_number", "phone_number.duplicate", "Số điện thoại đã tồn tại");
        }
    }
}
