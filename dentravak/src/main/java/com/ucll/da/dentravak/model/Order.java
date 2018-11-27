package com.ucll.da.dentravak.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "`order`")
public class Order {
    private @Id @GeneratedValue Long id;
    private BreadType breadType;
    private String mobilePhoneNumber;
    private LocalDateTime creationDate;
    private @ManyToOne Sandwich sandwich;

    @PrePersist
    public void before() {
        if (creationDate == null)
            this.creationDate = LocalDateTime.now();
    }
}
