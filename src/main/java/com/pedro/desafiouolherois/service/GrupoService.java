package com.pedro.desafiouolherois.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.pedro.desafiouolherois.entity.Grupo;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@Service
@Slf4j
@AllArgsConstructor
public class GrupoService {

    private List<String> vingadores;
    private List<String> ligaDaJustica;
    private Environment environment;
    private ObjectMapper objectMapper;

    @PostConstruct
    private void lerVingadores() {
        try {
            var uri = URI.create(Objects.requireNonNull(environment.getProperty("app.vingadores.url")));
            final var jsonNode = objectMapper.readTree(uri.toURL());
            final var listaVingadores = (ArrayNode) jsonNode.get("vingadores");


            for(JsonNode item : listaVingadores) {
                this.vingadores.add(item.get("codinome").asText());
            }
        } catch (Exception e) {
            log.error("Não foi possível ler aqruio de Vingadores", e);
        }

    }


    @PostConstruct
    private void lerLigaDaJustica() {
        try {
            final var factory = DocumentBuilderFactory.newInstance();
            final var builder = factory.newDocumentBuilder();
            final var document = builder.parse(environment.getProperty("app.liga.da.justica.url"));

            NodeList listaCodinomes = document.getElementsByTagName("codinome");

            for (int i = 0; i < listaCodinomes.getLength(); i++) {
                Element codinomeElement = (Element) listaCodinomes.item(i);
                this.ligaDaJustica.add(listaCodinomes.item(i).getTextContent());
            }

        } catch (Exception e) {
            log.error("Não foi possível ler arquivo de Liga da Justiça", e);
        }
    }

    public String getCodinome(Grupo grupo) {
        if (Grupo.VINGADORES.equals(grupo)) {
            final var personangemVingadores = vingadores.stream().findFirst()
                    .orElseThrow(() -> new NoSuchElementException("Não há mais elementos para a lista " + Grupo.VINGADORES));

            this.vingadores.remove(personangemVingadores);
            return personangemVingadores;
        }

        final var peronsagemLigaJustica = ligaDaJustica.stream().findFirst()
                .orElseThrow(() -> new NoSuchElementException("Não há mais elementos para a lista " + Grupo.LIGA_DA_JUSTICA));

        ligaDaJustica.remove(peronsagemLigaJustica);
        return peronsagemLigaJustica;
    }

}
