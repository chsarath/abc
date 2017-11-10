package com.employee.dao;


import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "employee")
public class Employee {
 
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 private int id;
 @Column
 private String name;
 @Column
 private int age;
 
 
 @Id
 @GeneratedValue(strategy = IDENTITY)
	 
 @Column(name = "id", unique = true, nullable = false)
 public int getId() {
 return id;
 }
 public void setId(int id) {
 this.id = id;
 }
 
 @Column(name = "name", length = 50)
 public String getName() {
 return name;
 }
 public void setName(String name) {
 this.name = name;
 }
 
 @Column(name = "age")
 public int getAge() {
 return age;
 }
 public void setAge(int age) {
 this.age = age;
 }
 
}