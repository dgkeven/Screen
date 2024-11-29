# Dashboard Application

Este projeto é um aplicativo simples em Java que utiliza **Swing** para criar uma interface gráfica interativa. O programa exibe um botão centralizado em uma janela que, ao ser clicado, executa uma animação de aumento e redução e, ao final, abre um link no navegador padrão.

## Funcionalidades

- **Interface gráfica**: Janela com botão interativo.
- **Animação**: O botão realiza um efeito de aumento e redução de escala ao ser clicado.
- **Ação final**: Ao término da animação, o aplicativo abre um vídeo no YouTube.
- **Restrições de design**: Janela não redimensionável para manter o layout.

---

## Estrutura do Projeto

O projeto possui os seguintes pacotes e classes:

### Pacotes

1. **`dashboard.screen`**: Contém a lógica da interface gráfica e interação.
2. **`dashboard.test`**: Classe de teste para inicializar a aplicação.

### Classes

1. **`Screen`**: Classe principal responsável pela interface gráfica e lógica de animação.
   - Gerencia o layout e ações do botão.
   - ![image](https://github.com/user-attachments/assets/ec7181e6-37ef-4c95-b722-013deb0ae292)
   - Abre um link para um vídeo no YouTube após a animação.
   - ![image](https://github.com/user-attachments/assets/df8665fe-e8ac-4a7c-afcd-6561a3dc7df8)
   
2. **`Test01`**: Classe auxiliar para executar o programa.

---

## Pré-requisitos

Certifique-se de ter instalado:

- **Java JDK** 8 ou superior
- Um IDE como **IntelliJ IDEA**, **Eclipse**, ou outro editor de texto compatível com Java.
- Conexão com a internet para abrir o link ao final da animação.

---

## Como Executar

1. **Clonar o projeto**:
   ```bash
   git clone https://github.com/dgkeven/Screen.git
   ```
   
2. **Compilar e Executar**:
   - Abra o projeto em sua IDE preferida.
   - Navegue até a classe `Test01` no pacote `dashboard.test`.
   - Execute o método `main`.

3. **Interagir com o aplicativo**:
   - Clique no botão "BAKER".
   - Observe a animação do botão.
   - Aguarde a abertura do vídeo no navegador padrão.

---

## Customizações

- **Texto do botão**:
  - Para alterar o texto do botão, modifique a linha:
    ```java
    jButton = new JButton("BAKER");
    ```
  
- **URL do link**:
  - Para alterar o link aberto, edite:
    ```java
    Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=T-64_HO5bJo"));
    ```
  
- **Velocidade da animação**:
  - Modifique o intervalo do `Timer` (em milissegundos):
    ```java
    timer = new Timer(30, new ActionListener() {
    ```

---

## Tecnologias Utilizadas

- **Java Swing**: Para a interface gráfica.
- **Desktop API**: Para abrir o navegador padrão.

---

