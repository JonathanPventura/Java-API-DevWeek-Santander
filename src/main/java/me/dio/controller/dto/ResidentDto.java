package me.dio.controller.dto;

import me.dio.domain.Resident;

public record ResidentDto(
        Long id,
        String name,
        int cpf,
        String email,
        int phone,
        String bloco,
        String apartamento
) {

    public ResidentDto(Resident model){
        this(
                model.getId(),
                model.getName(),
                model.getCpf(),
                model.getEmail(),
                model.getPhone(),
                model.getBloco(),
                model.getApartamento()
        );
    }

    public Resident toModel(){
        Resident model = new Resident();
        model.setName(this.name);
        model.setEmail(this.email);
        model.setBloco(this.bloco);
        model.setApartamento(this.apartamento);
        model.setPhone(this.phone);
        return model;
    }


}
