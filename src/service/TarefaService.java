package service;

import model.Tarefa;
import repository.ArquivoRepository;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TarefaService {

    private List<Tarefa> listaTarefa = new ArrayList<>();
    private long proximoId = 0;
    private ArquivoRepository arquivoRepository;

    public TarefaService() {
        this.arquivoRepository = new ArquivoRepository();
        this.listaTarefa = arquivoRepository.carregar();

        this.proximoId = listaTarefa.stream().mapToLong(Tarefa::getId).max().orElse(0) + 1;

    }

    public void adicionarTarefa(String titulo, String descricao) {
        Tarefa tarefa  = new Tarefa(proximoId++, titulo, descricao, false, LocalDate.now());
        listaTarefa.add(tarefa);
    }

    public List<Tarefa> listarTarefas() {
        return listaTarefa;
    }

    public Tarefa buscarPorId(long id) {
        for (Tarefa tarefa : listaTarefa) {
            if (tarefa.getId() == id) {
                return tarefa;
            }
        }

        return null;
    }

    public boolean removerTarefa(long id) {
        Tarefa tarefa = buscarPorId(id);
        if (tarefa != null) {
            listaTarefa.remove(tarefa);
            return true;
        }

        return false;
    }

    public boolean atualizarTarefa(long id, String novoTitulo, String novaDescricao) {
        Tarefa tarefa = buscarPorId(id);
        if (tarefa != null) {
            tarefa.setTitulo(novoTitulo);
            tarefa.setDescricao(novaDescricao);
            return true;
        }

        return false;
    }

    public boolean concluirTarefa(long id) {
        Tarefa tarefa = buscarPorId(id);
        if (tarefa != null) {
            tarefa.setConcluido(true);
            return true;
        }

        return false;
    }

    public void salvarEmArquivo() throws IOException {
        arquivoRepository.salvar(listaTarefa);
    }
}
