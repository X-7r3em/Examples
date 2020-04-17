package com.example.springdata.lazyeager.onetoone;

import javax.persistence.*;

@Entity
@Table(name = "parents_e_e_o")
public class ParentEEO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @OneToOne(mappedBy = "parent", fetch = FetchType.EAGER)
    private ChildEEO child;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ChildEEO getChild() {
        return child;
    }

    public void setChild(ChildEEO children) {
        this.child = children;
    }
}
