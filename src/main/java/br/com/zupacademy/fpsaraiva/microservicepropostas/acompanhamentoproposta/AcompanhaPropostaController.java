package br.com.zupacademy.fpsaraiva.microservicepropostas.acompanhamentoproposta;

import br.com.zupacademy.fpsaraiva.microservicepropostas.criacaoproposta.Proposta;
import br.com.zupacademy.fpsaraiva.microservicepropostas.criacaoproposta.PropostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
public class AcompanhaPropostaController {

    @Autowired
    private PropostaRepository propostaRepository;

    @GetMapping("/propostas")
    public ResponseEntity<PropostaDetalheResponse> consultaProposta(@RequestParam String id) {
        try {
            UUID idConvertido = UUID.fromString(id);
            Optional<Proposta> propostaBuscada = propostaRepository.findById(idConvertido);

            if(propostaBuscada.isEmpty()){
                return ResponseEntity.notFound().build();
            }
            Proposta proposta = propostaBuscada.get();

            return ResponseEntity.ok().body(new PropostaDetalheResponse(proposta));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
