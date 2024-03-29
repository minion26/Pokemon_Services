package com.fiipractic.Model;

public class Pokemon {
    private Integer id;
    private String name;
    private Integer baseTotal;

    private  Integer baseEggSteps;

    public Pokemon(){

    }

    public Pokemon(Integer id, String name, Integer baseTotal, Integer baseEggSteps) {
        this.id = id;
        this.name = name;
        this.baseTotal = baseTotal;
        this.baseEggSteps = baseEggSteps;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBaseTotal(Integer baseTotal) {
        this.baseTotal = baseTotal;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getBaseTotal() {
        return baseTotal;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", baseTotal=" + baseTotal +
                ", baseEggSteps=" + baseEggSteps +
                '}';
    }

    public Integer getBaseEggSteps() {
        return baseEggSteps;
    }

    public void setBaseEggSteps(Integer baseEggSteps) {
        this.baseEggSteps = baseEggSteps;
    }

}
