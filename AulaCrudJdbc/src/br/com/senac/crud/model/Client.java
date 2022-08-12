/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.crud.model;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author felipe.ticiani
 */
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client implements Serializable {
    private Long id;
    private String name;
    private String cpf;
    private String rg;
    private Double salary;
}
