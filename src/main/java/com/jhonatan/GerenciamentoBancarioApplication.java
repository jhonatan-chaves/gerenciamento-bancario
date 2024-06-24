package com.jhonatan;

import com.jhonatan.models.ClienteModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class GerenciamentoBancarioApplication {

	public static void main(String[] args) throws ParseException {
		SpringApplication.run(GerenciamentoBancarioApplication.class, args);

		ClienteModel cliente = new ClienteModel();
		cliente.setIdCliente(1L);
		cliente.setNome("jhonatan chaves");
		cliente.setDataNascimento(LocalDate.of(1998, 06, 06));
		cliente.setCpf("122.333.444-85");



		System.out.println(cliente.toString());

	}

}
