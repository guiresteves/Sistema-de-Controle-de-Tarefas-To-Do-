import model.Tarefa;
import service.TarefaService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TarefaService tarefaService = new TarefaService();

        while (true) {
            try {
                System.out.println("\n==== MENU DE TAREFAS ====");
                System.out.println("1. Adicionar Tarefa");
                System.out.println("2. Listar Tarefa");
                System.out.println("3. Editar Tarefa");
                System.out.println("4. Concluir Tarefa");
                System.out.println("5. Remover Tarefa");
                System.out.println("6. Sair");
                System.out.print("Escolha uma opção: ");
                int opcao = Integer.parseInt(input.nextLine());

                switch (opcao) {
                    case 1:
                        System.out.print("\nTitulo: ");
                        String titulo = input.nextLine();
                        System.out.print("Descricao: ");
                        String descricao = input.nextLine();

                        if (titulo.isEmpty() || descricao.isEmpty()) {
                            System.out.println("Não pode ter campos vazios!");
                            break;
                        }

                        tarefaService.adicionarTarefa(titulo, descricao);
                        System.out.println("Tarefa adicionada com sucesso!");
                        break;

                    case 2:
                        if (tarefaService.listarTarefas().isEmpty()) {
                            System.out.println("\n Nenhuma Tarefa Cadastrada!");
                        } else {
                            for (Tarefa t : tarefaService.listarTarefas()) {
                                System.out.println("\nID: " + t.getId());
                                System.out.println("Título: " + t.getTitulo());
                                System.out.println("Descrção: " + t.getDescricao());
                                System.out.println("Concluido: " + (t.isConcluido() ? "SIM" : "NAO"));
                                System.out.println("Data de Criação: " + t.getDataCriacao());
                            }
                        }
                        break;

                    case 3:
                        System.out.print("\nID da Tarefa para editar: ");
                        int idEditar = Integer.parseInt(input.nextLine());

                        Tarefa tarefaEditar = tarefaService.buscarPorId(idEditar);

                        if (tarefaEditar == null) {
                            System.out.println("Tarefa não encontrada!");
                            break;
                        }

                        System.out.print("Titulo: ");
                        String novoTitulo = input.nextLine();
                        System.out.print("Descricao: ");
                        String novoDescricao = input.nextLine();

                        if (novoTitulo.isEmpty() || novoDescricao.isEmpty()) {
                            System.out.println("\n Não pode ter compos vazios");
                            break;
                        }

                        tarefaService.atualizarTarefa(idEditar, novoTitulo, novoDescricao);
                        System.out.println("Tarefa atualizada com sucesso!");
                        break;

                    case 4:
                        System.out.print("\nID da Tarefa para marcar concluída: ");
                        int idConcluir = Integer.parseInt(input.nextLine());

                        if (tarefaService.concluirTarefa(idConcluir)) {
                            System.out.println("Tarefa Concluída!");
                        } else {
                            System.out.println("Tarefa não encontrada.");
                        }
                        break;

                    case 5:
                        System.out.print("\nID da Tarefa para remover: ");
                        int idRemover = Integer.parseInt(input.nextLine());

                        if (tarefaService.removerTarefa(idRemover)) {
                            System.out.println("Tarefa removida!");
                        } else {
                            System.out.println("Tarefa não encontrada.");
                        }
                        break;

                    case 6:
                        tarefaService.salvarEmArquivo();
                        System.out.println("\nSaindo...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opção Inválida. Tente Novamente");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada Inválida! Digite apenas números onde for necessário.");
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }
}