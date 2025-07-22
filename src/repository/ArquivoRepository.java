package repository;

import model.Tarefa;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ArquivoRepository {

    private static final String NOME_ARQUIVO = "arquivo-tarefas";

    public void salvar(List<Tarefa> tarefas){
        try (BufferedWriter write = new BufferedWriter(new FileWriter(NOME_ARQUIVO))) {
            for (Tarefa tarefa : tarefas) {
                String Linha = tarefa.getId() + ";" +
                               tarefa.getTitulo() + ";" +
                               tarefa.getDescricao() + ";" +
                               tarefa.isConcluido() + ";" +
                               tarefa.getDataCriacao() + ";";

                write.write(Linha);
                write.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo: " + e.getMessage());
        }
    }

    public List<Tarefa> carregar() {
        List<Tarefa> tarefas = new ArrayList<>();
        File arquivo = new File(NOME_ARQUIVO);

        if (!arquivo.exists()) {
            return tarefas;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(NOME_ARQUIVO))) {
            String linha;
            while ((linha = reader.readLine()) != null) {

                String[] partes = linha.split(";");
                if (partes.length == 5) {
                    int id = Integer.parseInt(partes[0]);
                    String titulo = partes[1];
                    String descricao = partes[2];
                    boolean concluido = Boolean.parseBoolean(partes[3]);
                    LocalDate dataCriacao = LocalDate.parse(partes[4]);


                    Tarefa tarefa = new Tarefa(id, titulo, descricao, concluido, dataCriacao);
                    tarefas.add(tarefa);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar arquivo: " + e.getMessage());
        }

        return tarefas;
    }
}
