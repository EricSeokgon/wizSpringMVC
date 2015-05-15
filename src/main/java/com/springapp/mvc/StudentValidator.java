package com.springapp.mvc;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Project: wizSpringMVC
 * FileName: StudentValidator
 * Date: 2015-05-15
 * Time: 오전 9:45
 * Author: Hadeslee
 * Note:
 * To change this template use File | Settings | File Templates.
 */
public class StudentValidator implements Validator {

    @Override
    public boolean supports(Class<?> arg0) {
        return Student.class.isAssignableFrom(arg0);  // 검증할 객체의 클래스 타입 정보
    }

    @Override
    public void validate(Object obj, Errors errors) {
        System.out.println("validate()");
        Student student = (Student) obj;

        /*String studentName = student.getName();
        if(studentName == null || studentName.trim().isEmpty()) {
            System.out.println("studentName is null or empty");
            errors.rejectValue("name", "trouble");
        }*/

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "trouble");

        /*int studentId = student.getId();
        if (studentId == 0) {
            System.out.println("studentId is 0");
            errors.rejectValue("id", "trouble");
        }*/

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "trouble");
    }

}
