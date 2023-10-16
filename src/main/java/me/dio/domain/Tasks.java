package me.dio.domain;

import jakarta.persistence.Entity;

@Entity(name = "tb_tasks")
public class Tasks extends Itens{
    private String types;
    private String status;

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
