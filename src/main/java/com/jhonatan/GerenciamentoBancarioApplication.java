package com.jhonatan;

import com.jhonatan.exceptions.SaldoInsuficioneteException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;

@SpringBootApplication
public class GerenciamentoBancarioApplication  {

	//@Autowired
	//private ClienteService clienteService;

	public static void main(String[] args) throws ParseException, SaldoInsuficioneteException {
		SpringApplication.run(GerenciamentoBancarioApplication.class, args);
/*
		ClienteModel cliente1 = new ClienteModel(001L,"jhonatan chaves",
				LocalDate.of(1998,06,06),"111.222.333-45");
		ClienteModel cliente2 = new ClienteModel(002L,"thaisa ribeiro",
				LocalDate.of(2000,01,30),"222.555.888-10");

		ContaPoupancaModel conta1 = new ContaPoupancaModel(01L, "123456789-10",
				StatusConta.ATIVA,cliente1.getNome(), cliente1,new  BigDecimal("0.1"));
		ContaPoupancaModel conta2 = new ContaPoupancaModel(02L, "987654321-10",
				StatusConta.ATIVA,cliente2.getNome(), cliente2,new  BigDecimal("0.1"));

		System.out.println(conta1.toString());
		System.out.println(conta2.toString());

		conta1.depositar(new BigDecimal("2500.26"));
		conta1.transferir(new BigDecimal("1000"),conta2);

		System.out.println(conta1.toString());
		System.out.println(conta2.toString());


		conta2.transferir(new BigDecimal("520.35"),conta1);
		System.out.println(conta1.getTransacoes());
		System.out.println(conta2.getTransacoes());

		/*
		System.out.println(conta1.getTransacoes());
		System.out.println("=========================================================================================================================================");
		System.out.println(conta2.getTransacoes());

		 */






	}


}
