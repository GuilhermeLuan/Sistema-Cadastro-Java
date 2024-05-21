# Sistema de cadastro - README
## Descrição

Este projeto é um sistema de registro de usuários em Java. Ele permite que usuários insiram seus dados pessoais, valide as entradas, armazene informações e interaja com um menu de opções. Os dados dos usuários são salvos em arquivos de texto para futuras consultas.

## Funcionalidades

1. **Registrar Usuário**: Permite o registro de novos usuários após validação dos dados inseridos.
2. **Listar Usuários**: Exibe a lista de todos os usuários registrados.
3. **Adicionar Pergunta**: Permite adicionar novas perguntas ao formulário de registro.
4. **Remover Pergunta**: Permite remover perguntas existentes do formulário.
5. **Pesquisar Usuário**: Pesquisa usuários pelo nome ou email.

## Tecnologia utilizadas

- Orientação a Objetos
- Java io
- Streams, lambda
- Exceções

## Estrutura do Projeto

- **Pacote `application`**: Contém a classe principal `Main` que executa o programa.
- **Pacote `entities`**: Contém a classe `Client` e exceções personalizadas (`AgeException`, `EmailException`, `HeightException`, `NameException`).
- **Pacote `entities.exceptions`**: Define exceções para validação dos dados dos usuários.
- **Pacote `utils`**: Inclui utilitários para manipulação de arquivos (`FileUtil`) e exibição de menus (`Menu`).
- 
## Uso

Ao iniciar o programa, você verá um menu com as seguintes opções:

1. **Registrar Usuário**: Inicia o processo de registro de um novo usuário. As seguintes informações são solicitadas e validadas:
    - Nome
    - Email
    - Idade
    - Altura
2. **Listar Usuários**: Exibe a lista de usuários registrados.
3. **Adicionar Pergunta**: Adiciona uma nova pergunta ao formulário de registro de usuários.
4. **Remover Pergunta**: Remove uma pergunta existente do formulário.
5. **Pesquisar Usuário**: Pesquisa usuários pelo nome, idade ou email.
6. **Sair**: Encerra o programa.

## Validação

As seguintes validações são realizadas durante o registro:

- **Nome**: Deve ser não vazio e deve possuir mais de 10 carácteres.
- **Email**: Deve ser único e seguir o formato padrão de email.
- **Idade**: Deve ser um número inteiro válido e maior de 18 anos
- **Altura**: Deve ser um número válido.

## Manipulação de Arquivos

- **Leitura de Arquivo**: O formulário de perguntas é lido do arquivo `src/formulario.txt`.
- **Escrita em Arquivo**: Os dados dos usuários são salvos em arquivos de texto, nomeados com base no índice do usuário e seu nome.
