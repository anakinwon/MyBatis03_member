package com.spring.mybatis02.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class MybatisMember {
	
	@Id
	@Size(min=3, max=20, message="아이디는 3~20자리로 입력해야 합니다!!!")
    private String id;	
	@Size(min=2, max=50, message="이름은 최소2자리부터 입력해야 합니다!!!")
    private String name;
	
	@Pattern(regexp="^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@!%*#?&])[A-Za-z\\d@!%*#?&]{8,}$", message="비밀번호는 최소 8자,하나의 이상의 문자, 숫자, 특수 문자 포함되어야 합니다.")
    private String pwd;
	
	@Pattern(regexp="\\d{3}-\\d{3,4}-\\d{4}", message="전화번호 형식(010-1234-4567)이 아닙니다!!!")
    private String tel;
	
	@Pattern(regexp="^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message="이메일 형식이 아닙니다!!!")
    private String email;
    
    //getter, setter
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
