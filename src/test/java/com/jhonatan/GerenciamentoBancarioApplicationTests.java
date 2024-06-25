package com.jhonatan;

import com.jhonatan.models.ClienteModel;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@SpringBootTest
class GerenciamentoBancarioApplicationTests {

	@Test
	void contextLoads() throws ParseException {

		ClienteModel cliente = new ClienteModel(1L,"jhonatan chaves",
				LocalDate.of(1998,06,06),"157.878.637-63");


	}

}
