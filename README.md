# Sistema de Controle de Despesas

Este projeto é um sistema de controle de despesas desenvolvido em Java. O objetivo é permitir que os usuários gerenciem suas despesas e pagamentos de forma eficiente. O sistema inclui funcionalidades para inserir despesas, registrar pagamentos, listar despesas por status, e gerenciar tipos de despesas e usuários.

## Funcionalidades

1. **Entrada de Despesa**: Adiciona uma nova despesa com descrição, valor, data de vencimento e categoria.
2. **Registro de Pagamento**: Marca uma despesa como paga.
3. **Listagem de Despesas**: Exibe despesas pagas ou pendentes.
4. **Gerenciamento de Tipos de Despesa**: Adiciona, lista e remove tipos de despesas.
5. **Gerenciamento de Usuários**: Adiciona e lista usuários cadastrados.

## Opções Contidas no Menu Principal

- **Entrar Despesa**: Permite adicionar uma nova despesa ao sistema. O usuário fornece descrição, valor, data de vencimento e categoria da despesa.
- **Anotar Pagamento**: Registra o pagamento de uma despesa existente. O usuário fornece a descrição da despesa e o sistema marca a despesa como paga.
- **Listar Despesas em Aberto**: Exibe todas as despesas que ainda não foram pagas.
- **Listar Despesas Pagas**: Mostra todas as despesas que já foram pagas.
- **Gerenciar Tipos de Despesa**: Permite adicionar, listar e remover categorias de despesas.
- **Gerenciar Usuários**: Permite cadastrar novos usuários e listar os usuários existentes.
- **Sair**: Encerra o sistema.

## Estrutura do Projeto

### `Despesa.java`

A classe `Despesa` representa uma despesa individual, contendo detalhes como descrição, valor, data de vencimento, categoria e status de pagamento.

#### Atributos Contidos

- **descricao**: Descrição da despesa.
- **valor**: Valor da despesa.
- **dataVencimento**: Data de vencimento da despesa no formato "dd/mm/aaaa".
- **categoria**: Categoria à qual a despesa pertence.
- **paga**: Booleano que indica se a despesa foi paga ou não.

#### Métodos

- **Despesa(String descricao, double valor, String dataVencimento, String categoria)**: Construtor que inicializa os atributos da despesa.
- **registrarPagamento()**: Marca a despesa como paga.
- **getDescricao()**: Retorna a descrição da despesa.
- **getValor()**: Retorna o valor da despesa.
- **getDataVencimento()**: Retorna a data de vencimento da despesa.
- **getCategoria()**: Retorna a categoria da despesa.
- **isPaga()**: Verifica se a despesa foi paga.
- **setDescricao(String descricao)**: Define uma nova descrição para a despesa.
- **setValor(double valor)**: Define um novo valor para a despesa.
- **setDataVencimento(String dataVencimento)**: Define uma nova data de vencimento para a despesa.
- **setCategoria(String categoria)**: Define uma nova categoria para a despesa.
- **toString()**: Retorna uma representação em string da despesa com detalhes formatados.

### `SistemaDespesa.java`

A classe `SistemaDespesa` é o controlador principal que gerencia as funcionalidades do sistema, como entrada de despesas, registro de pagamentos, e gerenciamento de tipos de despesas e usuários.

#### Atributos Contidos

- **menu**: Menu onde o usuario pode interagir
- **despesas**: Lista que armazena todas as despesas inseridas.
- **tiposDespesa**: Lista que gerencia as categorias de despesas.
- **usuarios**: Lista de usuários cadastrados.

 

#### Métodos

- **SistemaDespesa()**: Construtor que inicializa as listas de despesas, tipos de despesas e usuários.
- **adicionarDespesa(Scanner scanner)**: Lê os dados do usuário e cria uma nova despesa.
- **registrarPagamento(Scanner scanner)**: Procura uma despesa pela descrição e a marca como paga.
- **listarDespesas(boolean pagas, Scanner scanner)**: Lista as despesas filtrando por status (pagas ou pendentes) e permite editar ou excluir uma despesa.
- **editarDespesa(Despesa despesa, Scanner scanner)**: Permite editar os atributos de uma despesa selecionada.
- **excluirDespesa(Despesa despesa)**: Remove uma despesa da lista.
- **gerenciarTiposDespesa(Scanner scanner)**: Adiciona, lista ou remove tipos de despesas.
- **chamarGerenciamentoUsuarios(Scanner scanner)**: Chama o método de gerenciamento de usuários.
- **main(String[] args)**: Método principal que exibe o menu principal e executa ações com base na escolha do usuário.

### `Usuario.java`

A classe `Usuario` gerencia as informações dos usuários, incluindo a criptografia de senhas para segurança.

#### Atributos Contidos

- **login**: Nome de login do usuário.
- **senhaCriptografada**: Senha do usuário armazenada de forma criptografada usando SHA-256.

#### Métodos

- **Usuario(String login, String senha)**: Construtor que cria um novo usuário e criptografa sua senha.
- **criptografarSenha(String senha)**: Criptografa uma senha usando o algoritmo SHA-256.
- **getLogin()**: Retorna o nome de login do usuário.
- **validarSenha(String senha)**: Verifica se a senha fornecida corresponde à senha criptografada armazenada.
- **gerenciarUsuarios(ArrayList<Usuario> usuarios, Scanner scanner)**: Permite adicionar e listar usuários.

## Fluxo Geral do Sistema

1. **Menu Principal**: Inicia no menu principal, onde o usuário pode escolher entre inserir despesas, registrar pagamentos, listar despesas, gerenciar tipos de despesas e gerenciar usuários.
2. **Entrar Despesa**: Insere uma nova despesa com descrição, valor, data de vencimento e categoria.
3. **Anotar Pagamento**: Registra o pagamento de uma despesa específica.
4. **Listar Despesas**: Lista as despesas filtrando por pagas ou pendentes, com a opção de editar ou excluir despesas.
5. **Gerenciar Tipos de Despesa**: Cria, lista e remove tipos de despesas.
6. **Gerenciar Usuários**: Cadastra novos usuários e lista os existentes. As senhas são criptografadas antes de serem armazenadas.

## Criptografia de Senhas

A classe `Usuario` utiliza o algoritmo SHA-256 para criptografar senhas, garantindo que as senhas armazenadas sejam seguras. O método `criptografarSenha()` converte a senha em um hash irreversível. Ao tentar fazer login, a senha fornecida é comparada com o hash armazenado para validação.

## Resumo

Esta documentação fornece uma visão geral detalhada do sistema de controle de despesas, explicando as funcionalidades principais, atributos e métodos de cada classe. Ela serve como base para entender, manter e expandir o sistema.
