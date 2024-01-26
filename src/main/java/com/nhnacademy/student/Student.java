package com.nhnacademy.student;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Student {
    //아이디
    private  String id;
    //이름
    private  String name;
    //성별
    private  Gender gender;
    //나이
    private  int age;
    //생성일
    private LocalDateTime createdAt;


}