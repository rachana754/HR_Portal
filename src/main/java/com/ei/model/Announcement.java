package com.ei.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ei.enums.AnnouncementColor;

import lombok.Data;

@Data
@Entity
@Table(name = "Announcement")
public class Announcement implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "subject")
    private String subject;

    @Column(name = "description")
    private String description;

    @Column(name = "color")
    @Enumerated(value = EnumType.STRING)
    private AnnouncementColor color;

    @Column(name = "link")
    private String link;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "last_modified_date", nullable = true)
    private Date lastModifiedDate;

    @Column(name = "delete_date", nullable = true)
    private Date deleteDate;

}