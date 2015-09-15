package br.com.mercadinho;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import br.com.mercadinho.service.lista.IncluirListaComprasService;
import br.com.mercadinho.utils.entity.ListaComprasEntity;
import br.com.mercadinho.utils.exception.RegraNegocioException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ServiceApplication.class)
@IntegrationTest({"server.port:0", "security.user.password:foo", "security.user.name:marcelo@com"})
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class IncluirListaComprasTest  {
	
	@Value("${local.server.port}")
	private int port;
	
	private String host;
	
	private RestTemplate template = new TestRestTemplate("marcelo@com", "foo");

	@Autowired
	private IncluirListaComprasService incluirListaComprasService;
	
	@Before
	public void init(){
		host = "http://localhost:"	+ port;
	}
	
	@Test
	public void incluir(){
		
		ListaComprasEntity lista = new ListaComprasEntity();
		lista.setNome("Nova lista");
		
		try {
			incluirListaComprasService.incluir(lista);
		} catch (RegraNegocioException e) {
			fail();
		}
	}
	
	
	
	
	
	
	
}
