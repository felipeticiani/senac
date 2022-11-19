/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.entidade;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author silvio.junior
 */
@Entity
@Table(name = "telefone")
public class Telefone implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 10, nullable = false)
    private String numero;    
    
    @Column(length = 4, nullable = false)
    private String ddd; 
    
    @Column(nullable = false)
    private String operadora; 
    
    @Column(nullable = false)
    private String tipo;  

    public Telefone() {
    }

    public Telefone(String numero, String ddd, String operadora,
            String tipo) {
        this.numero = numero;
        this.ddd = ddd;
        this.operadora = operadora;
        this.tipo = tipo;
    }    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getOperadora() {
        return operadora;
    }

    public void setOperadora(String operadora) {
        this.operadora = operadora;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Telefone)) {
            return false;
        }
        Telefone other = (Telefone) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "br.com.senac.entidade.Telefone[ id=" + id + " ]";
    }
    
}
