package com.apirest.spring;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vo.campeonatoVO;
import vo.clubVO;
import vo.faltaVO;
import vo.golVO;
import vo.jugadorVO;
import vo.miembroVO;
import vo.partidoVO;
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
	
	@RequestMapping("/getJugadorById")
	public jugadorVO getJugador(@RequestParam(name = "idJugador") Integer idJugador) throws usuarioException {
		return ControladorTPO.getInstance().ObtenerJugadorPorIdVO(idJugador);
	} 
	
	@RequestMapping("/getFaltaById")
	public faltaVO getFalta(@RequestParam(name = "idFalta") Integer idFalta) throws usuarioException {
		return ControladorTPO.getInstance().ObtenerFaltaPorIdVO(idFalta);
	}
	
	@RequestMapping("/getGolById")
	public golVO getGol(@RequestParam(name = "idGol") Integer idGol) throws usuarioException {
		return ControladorTPO.getInstance().ObtenerGolPorIdVO(idGol);
	}
	
	@RequestMapping("/getPartidoById")
	public partidoVO getPartido(@RequestParam(name = "idPartido") Integer idPartido) throws usuarioException {
		return ControladorTPO.getInstance().ObtenerPartidoPorIdVO(idPartido);
	}
	
	@RequestMapping("/getResponsableById")
	public responsableVO getResponsable(@RequestParam(name = "idResponsable") Integer idResponsable) throws usuarioException {
		return ControladorTPO.getInstance().ObtenerResponsablePorIdVO(idResponsable);
	}
	
	@RequestMapping("/getMiembroById")
	public miembroVO getMiembro(@RequestParam(name = "idMiembro") Integer idMiembro) throws usuarioException {
		return ControladorTPO.getInstance().ObtenerMiembroPorIdVO(idMiembro);
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
	
	@PostMapping("/addMiembro")
	public void addMiembro(@RequestParam (name = "idJugador") Integer idJugador,@RequestParam (name = "idClub") Integer idClub,@RequestParam (name = "idPartido") Integer idPartido) throws usuarioException {
		ControladorTPO.getInstance().agregarMiembroVO(idJugador,idPartido,idClub);
	}
	
	@PostMapping("/addPartido")
	public void addPartido(@RequestBody partidoVO club,@RequestParam (name= "idClubL")Integer idClubL,@RequestParam (name= "idClubV")Integer idClubV,@RequestParam (name= "idCampeonato")Integer idCampeonato) throws usuarioException {
		ControladorTPO.getInstance().agregarPartidoVO(club,idClubL,idClubV,idCampeonato);
	}
	
	@PostMapping("/addGol")
	public void addGol(@RequestParam (name= "idJugador")Integer idJugador,@RequestParam (name= "idPartido")Integer idPartido,@RequestParam (name= "sentido")String sentido,@RequestParam (name= "minuto")Integer minuto) throws usuarioException {
		ControladorTPO.getInstance().agregarGolVO(idJugador,idPartido,sentido,minuto);
	}
	
	@PostMapping("/addFalta")
	public void addFalta(@RequestParam (name= "idCampeonato")Integer idCampeonato,@RequestParam (name= "idPartido")Integer idPartido,@RequestParam (name= "idJugador")Integer idJugador,@RequestParam (name= "tipo")String tipo,@RequestParam (name= "minuto")Integer minuto) throws usuarioException {
		ControladorTPO.getInstance().agregarFaltaVO(idCampeonato,idJugador,idPartido,tipo,minuto);
	}
}

