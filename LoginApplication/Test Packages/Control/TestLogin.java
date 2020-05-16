package Control;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import DAO.UsuarioDAO;
import Entidad.Usuario;

public class TestLogin {
	
	private static ValidarLogin validar = new ValidarLogin();
	
	private String LONG_NOMBRE_INCORRECTA = "Longitud de nombre incorrecta";
	private String LONG_PASSWORD_INCORRECTA = "Longitud contraseña incorrecta";
	private String DATOS_INCORRECTOS = "Datos incorrectos!";
	private String USUARIO_AUTORIZADO = "Bienvenido";

	public TestLogin() {
		
	}
	
	@Before
	public void setUp() {
		
	}
	
	@Test
	public void testLongitudNombre() {
		
		
		Usuario u = new Usuario();
		u.setNombre("R");
		u.setPassword("123456");
		assertEquals(validar.validarLogin(u), LONG_NOMBRE_INCORRECTA);

		u.setNombre("Roberto");
		u.setPassword("123456");
		assertEquals(validar.validarLogin(u), LONG_NOMBRE_INCORRECTA);
		
		
	}
	
	@Test
	public void testLongitudPassword() {
		
		Usuario u = new Usuario();
		u.setNombre("Pepe");
		u.setPassword("12");
		assertEquals(validar.validarLogin(u), LONG_PASSWORD_INCORRECTA);

		u.setNombre("Pepe");
		u.setPassword("123456");
		assertEquals(validar.validarLogin(u), LONG_PASSWORD_INCORRECTA);
		 	
	}
	
	@Test
	public void testNombre() {
		
		Usuario u = new Usuario();
		u.setNombre("Henry");
		u.setPassword("12345");
		assertEquals(validar.validarLogin(u), DATOS_INCORRECTOS);
	}
	
	
	@Test
	public void testPassword() {
		
		Usuario u = new Usuario();
		u.setNombre("maria");
		u.setPassword("1234");
		assertEquals(validar.validarLogin(u), DATOS_INCORRECTOS);
	}
	
	@Test
	public void testDatos() {
		
		Usuario u = new Usuario();
		u.setNombre("Henry");
		u.setPassword("A234");
		assertEquals(validar.validarLogin(u), DATOS_INCORRECTOS);
	}
	
	@Test
	public void testTodoCorrecto() {
		
		Usuario u = new Usuario();
		u.setNombre("juan");
		u.setPassword("1234");
		assertEquals(validar.validarLogin(u), USUARIO_AUTORIZADO);
		
		u.setNombre("pedro");
		u.setPassword("123");
		assertEquals(validar.validarLogin(u), USUARIO_AUTORIZADO);
		
		u.setNombre("maria");
		u.setPassword("12345");
		assertEquals(validar.validarLogin(u), USUARIO_AUTORIZADO);
		
	}
	
	
	
	
	
	
	@BeforeClass
	public static void setUpClass() throws Exception {
		
		UsuarioDAO dao = new UsuarioDAO();
		
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    	
    	Usuario a = new Usuario();
    	Usuario b = new Usuario();
    	Usuario c = new Usuario();
    	
    	a.setNombre("juan");
    	a.setPassword("1234");
    	b.setNombre("pedro");
    	b.setPassword("123");
    	c.setNombre("maria");
    	c.setPassword("12345");
    	
    	usuarios.add(a);
    	usuarios.add(b);
    	usuarios.add(c);
    	
    	//sistema.setUsuarios(usuarios);
    	
    	for(Usuario u: usuarios) {
    		System.out.println(u.getNombre());
    		System.out.println(u.getPassword());
    		System.out.println("------------");
    		dao.crear(u);
    	}
		
	}
	
	

}
