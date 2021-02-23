package com.inventory.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@Table(name="store")
public class Store {

    public Store(String name, Boolean bopusEligible) {
        this.name = name;
        this.bopusEligible = bopusEligible;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="store_id_seq")
    @SequenceGenerator(name="store_id_seq", sequenceName="store_id_seq", allocationSize=1)
    @Column(name = "id", unique = true, nullable = false)
    private Integer storeId;

    @Column(name = "name")
    private String name;

    @Column(name = "bopus")
    private Boolean bopusEligible;

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getBopusEligible() {
        return bopusEligible;
    }

    public void setBopusEligible(Boolean bopusEligible) {
        this.bopusEligible = bopusEligible;
    }
}
