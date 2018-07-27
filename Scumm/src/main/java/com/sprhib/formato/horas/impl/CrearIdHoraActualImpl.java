package com.sprhib.formato.horas.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class CrearIdHoraActualImpl {

	public String obtenerHora() {
		Date hora = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hhmmss");
		return simpleDateFormat.format(hora);
	}

}