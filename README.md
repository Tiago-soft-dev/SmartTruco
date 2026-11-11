# 🃏 SmartTruco

> Um aplicativo Android moderno e intuitivo desenvolvido em Kotlin para gerenciar placares, pontuações e histórico de partidas do clássico jogo de cartas Truco.

---

## 📱 Sobre o Projeto

O SmartTruco foi criado para substituir o tradicional papel e caneta na hora de contar os pontos de uma partida de truco. Com uma interface limpa, botões de pontuação rápida e suporte a personalização de nomes e histórico de vitórias, o app garante que você se preocupe apenas em blefar e vencer a partida!

---

## ✨ Funcionalidades

- Placar Dinâmico: Acompanhe a pontuação em tempo real de dois jogadores (até 12 pontos).
- Botões de Pontuação Rápida: Adicione pontos instantaneamente (+1, +3, +6, +9 e +12).
- Detecção de Fim de Jogo: Alerta automático quando um jogador atinge 12 pontos, contabilizando a vitória na partida.
- Personalização de Nomes: Tela dedicada para definir os nomes personalizados dos jogadores (ActivityResultContracts).
- Histórico e Placar de Vitórias: Acompanhe o histórico de vitórias de cada jogador.
- Zerar Partida/Histórico: Reinicie o placar ou limpe o histórico de forma rápida.
- Design Adaptativo (Edge-to-Edge): Suporte nativo a telas modernas com barras de navegação imersivas.

---

## 🛠️ Tecnologias Utilizadas

- Linguagem: Kotlin
- Interface (UI): XML com ConstraintLayout e Material Design Components
- Gerenciamento de Views: View Binding
- Navegação e Intents: ActivityResultContracts para retorno seguro de dados entre Activities
- Arquitetura / Padrões: AppCompat, Edge-to-Edge APIs

---

## 🚀 Como Executar o Projeto

1. Clone o repositório: git clone https://github.com/seu-usuario/SmartTruco.git
2. Abra o projeto no Android Studio (versão Hedgehog ou superior recomendada).
3. Aguarde a sincronização do Gradle.
4. Conecte um dispositivo Android ou inicie um Emulador.
5. Clique no botão Run (Shift + F10) para compilar e executar o aplicativo.

---

## 📂 Estrutura do Código

- [MainActivity.kt](file:///home/dev/AndroidStudioProjects/SmartTruco/app/src/main/java/com/example/smarttruco/MainActivity.kt): Controla o placar principal, lógica de pontuação, detecção de vitória (12 pontos) e navegação entre telas.
- [informarNomes.kt](file:///home/dev/AndroidStudioProjects/SmartTruco/app/src/main/java/com/example/smarttruco/informarNomes.kt): Gerencia a entrada de nomes personalizados dos jogadores e retorna os dados via Intent.
- [HistoricoJogadas.kt](file:///home/dev/AndroidStudioProjects/SmartTruco/app/src/main/java/com/example/smarttruco/HistoricoJogadas.kt): Exibe o resumo e histórico de vitórias da partida.

---

## 🤝 Contribuindo

Contribuições são sempre bem-vindas! Sinta-se à vontade para abrir uma issue ou enviar um pull request com melhorias, novas funcionalidades ou correções de bugs.

---

## 📄 Licença

Este projeto está sob a licença MIT.
