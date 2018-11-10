package br.edu.utfpr.escola.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.edu.utfpr.escola.model.Matricula;
import br.edu.utfpr.escola.repositorio.MatriculaRepositorio;

@Service
@Transactional(readOnly=true, propagation=Propagation.REQUIRED)
public class MatriculaServiceImpl implements MatriculaService {

	@Autowired
	private MatriculaRepositorio matriculaRepositorio;
	
	@Autowired
	private UsuarioLogado usuarioLogado;
	
	@Transactional(readOnly=false, 
			propagation=Propagation.REQUIRED)
	@Override
	public Matricula matricular(Matricula matricula) {
		matricula.setUsuario(usuarioLogado.getUsuario());
		return matriculaRepositorio.save(matricula);
	}
	
	
	
	
	
	
	

}
