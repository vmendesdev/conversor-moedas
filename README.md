# Conversor de Moedas - Challenge One

Este é um projeto desenvolvido como parte da trilha em Java da One.  
O objetivo é criar um **Conversor de Moedas** em Java, que realiza conversões entre diferentes moedas utilizando dados obtidos em tempo real a partir da **Exchange Rate API**.

## Tecnologias Utilizadas

- **Java 21**
- **Gson** - Para manipulação de dados JSON
- **Exchange Rate API** - Utilizada para realizar conversões de moedas em tempo real.
- **dotenv** - Para carregar a chave de API de forma segura.

## Funcionalidades

- O programa permite a conversão entre várias moedas.
- A taxa de conversão é obtida em tempo real através de uma API externa.
- O histórico das conversões realizadas é armazenado localmente em um arquivo `.txt`.
- A chave da API é carregada de forma segura utilizando o arquivo `.env`, evitando expô-la em repositórios públicos.

## Pré-requisitos

Antes de rodar o projeto, é necessário ter o seguinte instalado em sua máquina:

- **Java 21** ou superior
- **Maven**

## Como Configurar

1. **Clone o repositório**:

   ```bash
   git clone https://github.com/vmendesdev/conversor-moedas.git
   ```

2. **Adicione o arquivo .env**:
   Na raiz do projeto, crie um arquivo chamado `.env` e adicione a chave da API, como mostrado abaixo:

   ```
   API_KEY=sua_chave_da_api_aqui
   ```

   **IMPORTANTE**: Não compartilhe sua chave da API e adicione o arquivo `.env` no `.gitignore` para garantir que a chave não seja exposta.

3. **Instale as dependências**:
   Execute o comando abaixo para instalar as dependências do projeto:

   ```bash
   mvn install
   ```

4. **Configure o .gitignore**:
   O arquivo `.gitignore` deve conter a linha a seguir para garantir que o arquivo `.env` não seja enviado ao GitHub:

   ```
   .env
   ```

## Como Executar

Execute o programa a partir do IntelliJ ou pela linha de comando:

```bash
mvn exec:java
```

## Interação com o Programa:
O programa pedirá que você insira a moeda de origem, a moeda de destino e o valor a ser convertido. Ele exibirá o valor convertido e perguntará se você deseja realizar outra conversão.

## Exemplo de Uso

```bash
=== Bem-vindo ao Conversor de Moedas ===

Digite a moeda de origem (ex.: USD, EUR, BRL) ou 'sair' para encerrar: USD
Digite a moeda de destino (ex.: BRL, USD, EUR): BRL
Digite o valor a ser convertido: 10

Valor convertido: 50,53 BRL

Deseja realizar outra conversão? (s/n): n
Programa encerrado. Até logo!
```

## Histórico de Conversões
Todas as conversões realizadas são registradas em um arquivo `historico_conversoes.txt` para posterior consulta.

## Contribuição
Se você deseja contribuir para o projeto, fique à vontade para criar um pull request! Ficarei feliz em receber sugestões de melhorias e novas funcionalidades.

## Para contribuir:

1. Faça um fork do repositório
2. Crie uma branch para sua feature (git checkout -b feature/nome-da-feature)
3. Faça commit das suas alterações (git commit -m 'Adiciona nova funcionalidade')
4. Envie para a branch principal (git push origin feature/nome-da-feature)
5. Abra um pull request

## Licença
Este projeto é licenciado sob a licença MIT. Para mais detalhes, consulte o arquivo LICENSE.

🛠️ Desenvolvido por Vanessa Melo Mendes  
Parte do challenge da ONE - One Next Education.
