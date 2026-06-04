package br.com.DefesaAzul.main;

import br.com.DefesaAzul.dao.EmbarcacaoDao;
import br.com.DefesaAzul.entities.Embarcacao;

import javax.swing.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TesteEmbarcacao {

    static String texto(String j){
        return JOptionPane.showInputDialog(j);
    }

    static int inteiro(String j){
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }

    static double real(String j){
        return Double.parseDouble(JOptionPane.showInputDialog(j));
    }

    static LocalDate data(String j) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(JOptionPane.showInputDialog(j), formato);
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException, ParseException {

        Embarcacao objEmbarcacao = new Embarcacao();

        EmbarcacaoDao dao = new EmbarcacaoDao();

        objEmbarcacao.setIdEmbarcacao(texto("Id da Embarcação"));
        objEmbarcacao.setNome(texto("Nome da Embarcação"));
        objEmbarcacao.setMmsi(texto("MMSI da Embarcação"));
        objEmbarcacao.setBandeira(texto("Banderia da Embarcação (3 Carácteres EX: BRA)"));
        objEmbarcacao.setTipo(texto("Tipo da Embarcação"));
        objEmbarcacao.setDataCadastrada(data("Data de cadastro"));

        System.out.println(dao.inserir(objEmbarcacao));

    }
}
