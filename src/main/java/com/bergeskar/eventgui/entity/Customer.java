package com.bergeskar.eventgui.entity;

import javax.persistence.*;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="customer_id")
    private int customer_id;
    @Basic
    @Column(name="f_name")
    private String f_name;
    @Basic
    @Column(name="l_name")
    private String l_name;
    @Basic
    @Column(name="b_date")

    private String b_date;
    @Basic
    @Column(name="phone_nr")
    private String phone_nr;

    public Customer(){

    }
    public Customer(String f_name, String l_name, String b_date, String phone_nr){
        this.f_name=f_name;
        this.l_name=l_name;
        this.b_date=b_date;
        this.phone_nr=phone_nr;
    }




    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public String getB_date() {
        return b_date;
    }

    public void setB_date(String b_date) {
        this.b_date = b_date;
    }

    public String getPhone_nr() {
        return phone_nr;
    }

    public void setPhone_nr(String phone_nr) {
        this.phone_nr = phone_nr;
    }

    @Override
    public String toString() {
        return customer_id +" " + f_name +""+ l_name +" "+ b_date +" "+ phone_nr +" ";

    }
}
