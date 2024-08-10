package com.jhonatan.services;

import com.jhonatan.models.ClienteModel;
import com.jhonatan.models.ContaBancariaModel;
import com.jhonatan.repository.ClienteRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class ContaClienteTest {

   // @InjectMocks
    //ContaClienteService contaClienteService;

    //@Mock
    //ContaClienteRepository contaClienteRepository;

    @Mock
    ClienteRepository clienteRepository;

    ContaBancariaModel contaBancariaModel;
    ClienteModel clienteModel;
/*
    @BeforeEach
    public void setUp(){

        contaBancariaModel = new ContaBancariaModel(1L,"12345678-9","corrente",
                "ativa", "jhonatan chaves",
                LocalDate.of(1998,06,06), new BigDecimal("2500.00"), clienteModel);

        clienteModel = new ClienteModel(1L,"jhonatan chaves",
                LocalDate.of(1998,06,06),"123.456.789-10");
    }
    @Test
    void deveBuscarContaPorNumeroDeContaComSucesso(){
        when(contaClienteRepository.findByNumeroConta(contaBancariaModel.getNumeroConta()))
                .thenReturn(Optional.ofNullable(contaBancariaModel));

        ContaBancariaModel conta =  contaClienteService.buscaContaPorNumeroConta(contaBancariaModel.getNumeroConta());

        assertEquals(contaBancariaModel, conta);
        verify(contaClienteRepository).findByNumeroConta(contaBancariaModel.getNumeroConta());
        verifyNoMoreInteractions(contaClienteRepository);
    }

    @Test
    void criarContaClienteComSucesso(){
        when(clienteRepository.findById(clienteModel.getIdCliente())).thenReturn(Optional.ofNullable(clienteModel));
        when(contaClienteRepository.save(any(ContaBancariaModel.class))).thenReturn(contaBancariaModel);

        ContaBancariaModel novaConta = contaClienteService.criarContaCliente(clienteModel.getIdCliente(), contaBancariaModel);

        assertNotNull(novaConta);
        assertEquals(contaBancariaModel.getNumeroConta(), novaConta.getNumeroConta());
        assertEquals(clienteModel.getNome(), novaConta.getTitular());

        verify(clienteRepository).findById(clienteModel.getIdCliente());
        verify(contaClienteRepository).save(any(ContaBancariaModel.class));
        verifyNoMoreInteractions(clienteRepository);
        verifyNoMoreInteractions(contaClienteRepository);
    }

 */
}
