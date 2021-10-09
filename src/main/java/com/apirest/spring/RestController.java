package com.apirest.spring;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vo.campeonatoVO;
import vo.clubVO;
import vo.jugadorVO;
import vo.responsableVO;
import controlador.ControladorTPO;
import exceptions.usuarioException;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	@RequestMapping("/getCampeonatoById")
	public campeonatoVO getCampeonato(@RequestParam(name = "legajo") Integer legajo) throws usuarioException {
		return ControladorTPO.getInstance().ObtenerCampeonadoPorIdVO(legajo);
	}
	@RequestMapping("/getClubById")
	public clubVO getClub(@RequestParam(name = "legajo") Integer legajo) throws usuarioException {
		return ControladorTPO.getInstance().ObtenerClubPorIdVO(legajo);
	} 
	@PostMapping("/addParticipante")
	public void addParticipante(@RequestParam(name = "idClub")Integer idClub,@RequestParam(name = "idCampeonato")Integer idCampeonato) throws usuarioException {
		ControladorTPO.getInstance().agregarParticipante(idClub, idCampeonato);
	}
	
	@PostMapping("/addCampeonato")
	public void addCampeonato(@RequestBody campeonatoVO campeonato) throws usuarioException {
		ControladorTPO.getInstance().agregarCampeonatoVO(campeonato);
	}
	
	@PostMapping("/addJugador")
	public void addJugador(@RequestBody jugadorVO jugador,@RequestParam (name = "idClub")Integer idClub) throws usuarioException {
		ControladorTPO.getInstance().agregarJugadorVO(jugador,idClub);
	}
	
	@PostMapping("/addResponsable")
	public void addJugador(@RequestBody responsableVO responsable,@RequestParam (name = "idClub")Integer idClub) throws usuarioException {
		ControladorTPO.getInstance().agregarResponsableVO(idClub,responsable);
	}
	
	@PostMapping("/addClub")
	public void addJugador(@RequestBody clubVO club) throws usuarioException {
		ControladorTPO.getInstance().agregarClubVO(club);
	}
}

