# Sistema de Cadastro 📋🧍‍♂️

Um sistema simples de cadastro de pessoas desenvolvido em **Java**, com integração ao **MySQL**.  
O projeto foi criado para fins de estudo e demonstração de conceitos de **JDBC**, **DAO** e **CRUD (Create, Read, Update, Delete)**.

---

## 🚀 Funcionalidades

- Cadastrar pessoas (nome e idade)  
- Listar pessoas cadastradas  
- Atualizar dados existentes  
- Excluir registros  
- Integração completa com banco de dados MySQL  

---

## 🧠 Tecnologias utilizadas

- **Java 17+**
- **MySQL 8.0+**
- **JDBC**
- **Maven** (para gerenciamento de dependências)
- **IDE recomendada:** NetBeans ou IntelliJ IDEA

---
## 🧩 Estrutura do Projeto
```
sistema-cadastro/
├── application/
│   └── SistemaCadastro.java          # Classe principal que inicializa o sistema
│
├── dao/
│   └── CadastroRepository.java       # Classe responsável pelas operações CRUD no banco
│
├── model/
│   └── Cadastro.java                 # Modelo que representa a entidade Pessoa/Cadastro
│
├── view/
│   ├── CadastroView.java             # Tela para cadastrar uma nova pessoa
│   └── ListCadastroView.java         # Tela para listar, editar ou excluir cadastros
│
├── util/
│   ├── ConexaoFactory.java           # Cria o banco e tabela automaticamente e gerencia a conexão
│   └── AtualizarCampos.java          # Classe auxiliar para atualizar dados dinamicamente
│
└── pom.xml                           # Configuração do Maven
```


## ⚙️ Como configurar o projeto

### 1️⃣ Clonar o repositório
```bash
git clone https://github.com/joseroberrto/sistema-cadastro.git
cd sistema-cadastro
```


### 2️⃣ Configurar o MySQL

Certifique-se de que o MySQL esteja instalado e rodando.

#### a) Ajustar usuário e senha

Abra `util/ConexaoFactory.java` e configure:

```java
private static final String URL = "jdbc:mysql://localhost:3306/sistema_cadastro";
private static final String USER = "root";          // Seu usuário MySQL
private static final String PASSWORD = "sua_senha"; // Sua senha MySQL
```

> ⚡ Dica: crie um usuário específico no MySQL para o sistema, se desejar.

#### b) Criação automática do banco e tabela

O sistema cria automaticamente o banco `sistema_cadastro` e a tabela `pessoa` ao iniciar.

### 3️⃣ Compilar e executar

O projeto é **Maven**, então qualquer IDE que suporte Java e Maven pode compilar e rodar o sistema:

#### 🔹 Usando IntelliJ IDEA, Eclipse ou NetBeans

1. Importe o projeto como **Maven Project**.
2. Aguarde a IDE baixar as dependências do Maven.
3. Localize a classe principal `application.SistemaCadastro`.
4. Clique em **Run** ou **Executar projeto**.

#### 🔹 Usando terminal e Maven 
> **Requisito:** JDK + Maven instalados no computador

1. Abra o terminal e navegue até a pasta do projeto:

```bash
cd ~/user/sistema-cadastro
```

2. Compile o projeto e rode a classe principal:

```bash
mvn clean package
mvn exec:java -Dexec.mainClass="application.SistemaCadastro"
```

> ✅ Vantagem: inclui automaticamente todas as dependências do Maven e funciona em qualquer IDE ou terminal.
