/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author pupil
 */
@Entity
public class Journal implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Person person;
    @OneToOne
    private Subject subject;
    @Basic()
    @Column()
    private int grade;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Temporal(TemporalType.TIMESTAMP)
    private Date changedate;
    
    public Journal() {
    }

    public Journal(Person person, Subject subject, int gradeValue, Date date, Date changedate) {
        this.person = person;
        this.subject = subject;
        this.grade = gradeValue;
        this.date = date;
        this.changedate = changedate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public Date getChangeDate() {
        return changedate;
    }

    public void setChangeDate(Date changedate) {
        this.changedate = changedate;
    }

    @Override
    public String toString() {
        
        if(changedate == null){
            return "Journal{" + "id=" + id 
                + ", person=" + person.getFirstname()
                + " " + person.getLastname()   
                + ", subject=" + subject.getName()
                + ", grade=" + grade
                + ", date=" + date 
                 
                + '}';
        }else{
           return "Journal{" + "id=" + id 
                + ", person=" + person.getFirstname()
                + " " + person.getLastname()   
                + ", subject=" + subject.getName()
                + ", grade=" + grade
                + ", date=" + date 
                + ", changedate=" + changedate   
                   
                + '}';
        }
        
    }
    
}