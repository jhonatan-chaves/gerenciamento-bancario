# gerenciamento-bancario
Sistema de gerenciamento bancario

## Levantamento de Requisitos - Sistema Bancário

### 1. Requisitos Funcionais

**1.1 Cadastro de Contas Bancárias:**

* **RF-01:** O sistema deve permitir o cadastro de novas contas bancárias por usuários autorizados.
* **RF-02:** Cada conta bancária deve ter um número único e um saldo inicial, ambos definidos pelo usuário.
* **RF-03:** O sistema deve validar a entrada de dados para garantir a unicidade do número da conta e a validade do saldo inicial.

**1.2 Consulta de Contas:**

* **RF-04:** O sistema deve permitir a consulta de detalhes de uma conta bancária pelo seu número único.
* **RF-05:** A consulta de detalhes da conta deve exibir informações como número da conta, saldo atual e histórico de transações.

**1.3 Transferência de Fundos:**

* **RF-06:** O sistema deve permitir a transferência de fundos entre contas bancárias do mesmo usuário.
* **RF-07:** O sistema deve validar se a conta de origem possui saldo suficiente para a transferência.
* **RF-08:** O sistema deve registrar a data, hora e valor da transferência.

**1.4 Pagamento de Contas (Boletos):**

* **RF-09:** O sistema deve permitir o pagamento de boletos usando o saldo da conta bancária do usuário.
* **RF-10:** O sistema deve validar se a conta possui saldo suficiente para o pagamento do boleto.
* **RF-11:** O sistema deve registrar o pagamento do boleto com a data, hora, valor e dados do boleto.

**1.5 Consulta de Saldo e Extrato:**

* **RF-12:** O sistema deve permitir a consulta do saldo atual de uma conta bancária.
* **RF-13:** O sistema deve permitir a visualização do extrato da conta com as transações realizadas em ordem cronológica.

### 2. Requisitos Não Funcionais

**2.1 Segurança:**

* **RNF-01:** As senhas dos usuários devem ser armazenadas de forma segura utilizando hashing criptográfico (ex: bcrypt, Argon2).
* **RNF-02:** O acesso às APIs do sistema deve ser protegido com autenticação JWT (JSON Web Token) para garantir a segurança das transações.
* **RNF-03:** O sistema deve implementar medidas de controle de acesso para garantir que apenas usuários autorizados tenham acesso às informações e operações.

**2.2 Performance:**

* **RNF-04:** O sistema deve ser capaz de processar até 1000 transações simultâneas sem afetar o desempenho e a disponibilidade do sistema.
* **RNF-05:** O sistema deve ter tempos de resposta rápidos para garantir uma experiência de usuário satisfatória.

**2.3 Usabilidade:**

* **RNF-06:** A interface do sistema deve ser intuitiva e fácil de usar para todos os tipos de usuários.
* **RNF-07:** O sistema deve fornecer mensagens claras e informativas para o usuário durante o uso.

**2.4 Escalabilidade:**

* **RNF-08:** O sistema deve ser capaz de lidar com um aumento significativo no número de contas e transações.
* **RNF-09:** A arquitetura do sistema deve ser modular e escalável para suportar um crescimento futuro.

**2.5 Confiabilidade:**

* **RNF-10:** O sistema deve ter uma taxa de disponibilidade de 99.9%, garantindo que as operações sejam sempre disponíveis para os usuários.
* **RNF-11:** O sistema deve implementar mecanismos de backup e recuperação de dados para garantir a integridade dos dados em caso de falha.

**2.6 Manutenibilidade:**

* **RNF-12:** O código do sistema deve ser modular e seguir boas práticas de desenvolvimento (ex: SOLID principles) para facilitar a manutenção e evolução do sistema.
* **RNF-13:** O sistema deve ter documentação completa e atualizada para facilitar a manutenção e a resolução de problemas.

### 3. Diagramas UML

**3.1 Diagrama de Casos de Uso:**

* **Atores:** Cliente, Administrador.
* **Casos de Uso:** Cadastro de Conta, Consulta de Conta, Transferência de Fundos, Pagamento de Conta, Consulta de Saldo e Extrato.

**3.2 Diagrama de Classes:**

* **Classes:** Conta, Transação, Cliente, Repositório de Conta, Serviço de Conta, Controlador de Conta.
* **Relações:** Associação, Agregação, Herança.

**3.3 Diagrama de Sequência:**

* **Cenários:** Cadastro de Conta, Transferência de Fundos.
* **Componentes:** Cliente, Controlador de Conta, Serviço de Conta, Repositório de Conta.

**3.4 Descrição Detalhada dos Diagramas:**

**3.4.1 Diagrama de Casos de Uso:**

* O diagrama de casos de uso mostra as interações entre os atores (cliente e administrador) e as funcionalidades do sistema (casos de uso).
* O cliente pode cadastrar uma conta, consultar informações da conta, realizar transferências, pagar boletos, consultar o saldo e visualizar o extrato.
* O administrador pode ter acesso a funcionalidades adicionais como gerenciar contas e usuários, além das funcionalidades do cliente.

**3.4.2 Diagrama de Classes:**

* O diagrama de classes representa as classes e seus relacionamentos no sistema.
* A classe **Conta** representa uma conta bancária com atributos como número da conta, saldo, data de criação, etc.
* A classe **Transação** representa uma operação realizada na conta, como transferências, pagamentos e depósitos.
* A classe **Cliente** representa um usuário do sistema com atributos como nome, CPF, senha, etc.
* A classe **Repositório de Conta** é responsável por gerenciar o armazenamento e acesso aos dados das contas no banco de dados.
* A classe **Serviço de Conta** implementa a lógica de negócios para as operações relacionadas a contas bancárias, como cadastro, consulta, transferência e pagamento.
* A classe **Controlador de Conta** é responsável por lidar com as requisições HTTP e traduzir as ações do usuário em chamadas para o serviço de conta.

**3.4.3 Diagrama de Sequência:**

* O diagrama de sequência ilustra a sequência de interações entre os objetos do sistema para realizar uma funcionalidade específica.
* O cenário de **Cadastro de Conta** mostra a sequência de interações entre o cliente, o controlador de conta, o serviço de conta e o repositório de conta.
* O cenário de **Transferência de Fundos** mostra a sequência de interações entre o cliente, o controlador de conta, o serviço de conta, o repositório de conta e a classe Transação.

### 
