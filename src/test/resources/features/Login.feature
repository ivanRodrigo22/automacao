#language: pt
  Funcionalidade: Realizar login com cadastro ja criado
    Cenario: Realizar login no site
      Dado que acesso o conexaoQA
      E clico no login
      Quando coloco "usuario" e "senha"
      Entao e exibido tela de dashboard
      E o botao de criar perfil estara sendo exibido
      E visualizo a tela de criacao do perfil