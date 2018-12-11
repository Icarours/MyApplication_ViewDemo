package com.example.llyc.myapp.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.io.Serializable;

/**
 * Created by Bright on 2018/11/29.
 *
 * @Describe
 * @Called
 */
public class PersonEntity implements Serializable,MultiItemEntity {

    /**
     * person_id : 2
     * person_name : 刘伟
     * mobile_phone : 18064042686
     * photo_path : http://101.132.130.104:8088/EmpPicUpload/timg20180919153009.jpg
     * pin : 902
     * gender : M
     * birthday :
     * department_name : BIM工作室
     * card_no : 3955864506
     * cert_type : 2
     * cert_number : 420113198907310034
     * workname : null
     * "department_id": 57,
     * "department_name": "上级领导",
     * "person_counts": 2
     */

    private String person_id;
    private String person_name;
    private String mobile_phone;
    private String photo_path;
    private String pin;
    private String gender;
    private String birthday;
    private String department_name;
    private String card_no;
    private String cert_type;
    private String cert_number;
    private String workname;
    private Integer department_id;//有该字段的是具体数据
    private Integer person_counts;
    private Integer ItemType;

    public PersonEntity() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "person_id='" + person_id + '\'' +
                ", person_name='" + person_name + '\'' +
                ", mobile_phone='" + mobile_phone + '\'' +
                ", photo_path='" + photo_path + '\'' +
                ", pin='" + pin + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday='" + birthday + '\'' +
                ", department_name='" + department_name + '\'' +
                ", card_no='" + card_no + '\'' +
                ", cert_type='" + cert_type + '\'' +
                ", cert_number='" + cert_number + '\'' +
                ", workname='" + workname + '\'' +
                ", department_id=" + department_id +
                ", person_counts=" + person_counts +
                '}';
    }

    public String getPerson_id() {
        return person_id;
    }

    public void setPerson_id(String person_id) {
        this.person_id = person_id;
    }

    public String getPerson_name() {
        return person_name;
    }

    public void setPerson_name(String person_name) {
        this.person_name = person_name;
    }

    public String getMobile_phone() {
        return mobile_phone;
    }

    public void setMobile_phone(String mobile_phone) {
        this.mobile_phone = mobile_phone;
    }

    public String getPhoto_path() {
        return photo_path;
    }

    public void setPhoto_path(String photo_path) {
        this.photo_path = photo_path;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public String getCard_no() {
        return card_no;
    }

    public void setCard_no(String card_no) {
        this.card_no = card_no;
    }

    public String getCert_type() {
        return cert_type;
    }

    public void setCert_type(String cert_type) {
        this.cert_type = cert_type;
    }

    public String getCert_number() {
        return cert_number;
    }

    public void setCert_number(String cert_number) {
        this.cert_number = cert_number;
    }

    public String getWorkname() {
        return workname;
    }

    public void setWorkname(String workname) {
        this.workname = workname;
    }

    public Integer getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Integer department_id) {
        this.department_id = department_id;
    }

    public Integer getPerson_counts() {
        return person_counts;
    }

    public void setPerson_counts(Integer person_counts) {
        this.person_counts = person_counts;
    }

    public void setItemType(Integer itemType) {
        ItemType = itemType;
    }

    @Override
    public int getItemType() {
        return ItemType;
    }
}
