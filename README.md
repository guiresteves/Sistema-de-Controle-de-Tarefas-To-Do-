# Sistema de Controle de Tarefas (To-Do List CLI)

Este é um projeto simples desenvolvido em **Java puro (sem frameworks)** que simula um sistema de tarefas com persistência em arquivo. É executado totalmente no terminal (modo CLI) e permite **criar, listar, editar, concluir e excluir tarefas**, além de **salvar automaticamente ao sair** e **carregar ao iniciar**.

---

## Objetivos do Projeto

- Praticar os fundamentos de Java
- Aplicar conceitos de POO (Programação Orientada a Objetos)
- Trabalhar com Listas, arquivos e modularização
- Implementar um CRUD funcional no terminal
- Adicionar tratamento de erros e validações

---

## Tecnologias utilizadas

- Java 17 
- `Scanner`, `ArrayList`, `BufferedReader`, `BufferedWriter`
- Organização em pacotes: `model`, `service`, `repository`

---

## Funcionalidades

| Funcionalidade            | Descrição                                                                 |
|--------------------------|---------------------------------------------------------------------------|
| ✅ Adicionar Tarefa       | Cria uma nova tarefa com título, descrição e data de criação              |
| 📋 Listar Tarefas         | Exibe todas as tarefas salvas, incluindo status (concluída ou não)        |
| ✏️ Editar Tarefa          | Permite editar o título e descrição da tarefa pelo ID                     |
| ☑️ Marcar como Concluída  | Atualiza o status da tarefa para "concluída"                              |
| 🗑️ Remover Tarefa         | Exclui uma tarefa da lista pelo ID                                        |
| 💾 Salvar em Arquivo      | Salva automaticamente todas as tarefas ao sair                            |
| 📂 Carregar do Arquivo    | Carrega automaticamente as tarefas do último uso                          |
| ❌ Tratamento de Erros    | Entrada inválida, ID não encontrado, campos vazios                        |
