package metaPrograming;

import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Field;

public class Validador {

	public List<String> validar(Object c) {
		List<String> validados = new ArrayList<String>();
		Class<?> classe = c.getClass();
		Field[] atributo = classe.getDeclaredFields();
		for (Field field : atributo) {
			field.setAccessible(true);
			try {
				Object valor = field.get(c);
				if (valor == null) {
					if (field.isAnnotationPresent(Validacao.class)) {
						Validacao validacao = field.getAnnotation(Validacao.class);
						validados.add(validacao.descricao());
					}
					validados.add(field.getName());
				}
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return validados;
	}

}
