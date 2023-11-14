package com.projetoGerenciamentoDePedidos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoGerenciamentoDePedidos.entities.Pedido;
import com.projetoGerenciamentoDePedidos.service.PedidoService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "pedido", description = "API REST DE GERENCIAMENTO DE PEDIDO")
@RestController
@RequestMapping("/pedido")
public class PedidoController {
	private final PedidoService pedidoService;

	@Autowired
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping("/{id}")
   
    public ResponseEntity<Pedido> buscaPedidoControlId (@PathVariable Long id){
    	Pedido pedido = pedidoService.buscaPedidoId(id);
    	if(pedido != null) {
    		return ResponseEntity.ok(pedido);
    	}
    	else {
    		return ResponseEntity.notFound().build();
    	}
    }
    @GetMapping("/")
   
    public ResponseEntity<List<Pedido>> buscaTodosPedidosControl(){
    	List<Pedido> pedido = pedidoService.buscaTodosPedidos();
    	return ResponseEntity.ok(pedido);
    }
    @PostMapping("/")
   
    public ResponseEntity<Pedido> salvaPedidoControl(@RequestBody @Valid Pedido pedido){
    	Pedido salvaPedido = pedidoService.savePedido(pedido);
    	return ResponseEntity.status(HttpStatus.CREATED).body(salvaPedido);
    }
    @PutMapping("/{id}")
   
    public ResponseEntity<Pedido> alterarPedidoControl(@PathVariable Long id, @RequestBody @Valid Pedido pedido){
    	Pedido alterarPedido = pedidoService.alterarPedido(id, pedido);
    	if (alterarPedido != null) {
    		return ResponseEntity.ok(pedido);
    	}
    	else {
    		return ResponseEntity.notFound().build();
    	}
    }
    @DeleteMapping("/{id}")
    
    public ResponseEntity<String> apagaPedidoControl(@PathVariable Long id){
    	boolean apagar = pedidoService.apagarPedido(id);
    	if(apagar) {	
    		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    	}
    	else {
    		return ResponseEntity.notFound().build();    	
    	}
    }
}

