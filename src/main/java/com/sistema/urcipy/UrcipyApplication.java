package com.sistema.urcipy;

import com.sistema.urcipy.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class UrcipyApplication implements CommandLineRunner {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(UrcipyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
		/*try{
			Usuario usuario= new Usuario();
			usuario.setNombre("Carlos");
			usuario.setApellido("Narvaez");
			usuario.setUsername("karlral");
	//		usuario.setPassword("12345");

			System.out.println("Empezo bien");
			usuario.setPassword(bCryptPasswordEncoder.encode("12345"));

			System.out.println("Empezo bien2");

			usuario.setEmail("@");
			usuario.setTelefono("0981");
			usuario.setPerfil("miperfil");

			System.out.println("Empezo bien3");

			Regional regional= new Regional();
			regional.setNomregional("URCI");
			regional.setIdregional(1);

			usuario.setRegional(regional);

			System.out.println("Empezo bien4");
			Rol rol= new Rol();
			rol.setNombre("ADMINISTRADOR");
			rol.setIdroles(1);

			System.out.println("Empezo bien 5");
			Set<UsuarioRol> usuarioRoles= new HashSet<>();
			UsuarioRol usuarioRol= new UsuarioRol();
			usuarioRol.setRol(rol);
			usuarioRol.setUsuario(usuario);
			usuarioRoles.add(usuarioRol);
			System.out.println("Empezo bien 6");
			Usuario usuarioGuardado= usuarioService.guardarUsuario(usuario,usuarioRoles);
			System.out.println(usuarioGuardado.toString());
			System.out.println("Empezo bien"+usuarioGuardado.toString());
		}catch (UsuarioFoundException exception){
			exception.printStackTrace();
			System.out.println("error al asignar el password"+exception.toString());
		}*/

    }
}
