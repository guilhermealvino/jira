package br.com.jira.core.business;

import br.com.jira.commons.StatusAtividade;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class AtividadeTest {

    @Test
    public void test_activity_creation_sets_initial_state() {
        String nome = "Test Activity";

        Atividade atividade = new Atividade(nome);

        assertEquals(nome, atividade.getNome());
        assertEquals(StatusAtividade.NAO_RELACIONADO, atividade.getStatus());
        assertNotNull(atividade.getDataCriacao());
        assertTrue(atividade.getDataCriacao().isBefore(LocalDateTime.now().plusSeconds(1)));
        assertTrue(atividade.getDataCriacao().isAfter(LocalDateTime.now().minusSeconds(1)));
    }

    @Test
    public void test_cannot_start_activity_in_wrong_status() {
        Atividade atividade = new Atividade("Test Activity");
        atividade.iniciar();

        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> atividade.iniciar()
        );

        assertEquals("A atividade já foi iniciada.", exception.getMessage());
        assertEquals(StatusAtividade.PENDENTE, atividade.getStatus());
    }

    @Test
    public void test_add_minutes_to_pendente_activity() {
        Atividade atividade = new Atividade("Test Activity");
        atividade.iniciar();

        atividade.adicionarHoras(30, "Worked for 30 minutes");

        assertEquals(30, atividade.getMinutosTrabalhados());
    }

    @Test
    public void test_add_zero_minutes_throws_exception() {
        Atividade atividade = new Atividade("Test Activity");
        atividade.iniciar();

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> atividade.adicionarHoras(0, "Invalid minutes")
        );

        assertEquals("Os minutos devem ser maiores que zero.", exception.getMessage());
    }

    @Test
    public void test_adicionar_horas_zero_minutes_throws_exception() {
        Atividade atividade = new Atividade("Test Activity");
        atividade.iniciar();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            atividade.adicionarHoras(0, "Attempt to add zero minutes");
        });

        assertEquals("Os minutos devem ser maiores que zero.", exception.getMessage());
    }

    @Test
    public void testFinalizarStatusFinalizado(){

        Atividade atividade = new Atividade("Testando Atividade");
        atividade.iniciar();

        atividade.finalizar();

        assertEquals(StatusAtividade.FINALIZADA, atividade.getStatus());
        assertNotNull(atividade.getDataFinalizacao());
    }

}