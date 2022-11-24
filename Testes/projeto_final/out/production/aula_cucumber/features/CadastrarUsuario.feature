# language: pt

  Funcionalidade: Acessar componentes.html

    Contexto:
      Dado que o usuário acessou a página Campo de treinamento

      Cenário: Validar cadastro
        Dado que o usuário preencheu o campo nome
        E preencheu o campo sobrenome
        E preencheu o campo sexo
        E preencheu o campo comida favorita
        E prencheu o campo escolaridade
        E preencheu o campo esportes
        Quando clicar no botão Cadastrar
        Então as informações cadastradas devem ser exibidas

      Cenário: Validar campo obrigatório Nome
        Dado que o usuário não preencheu o campo Nome
        Quando clicar no botão Cadastrar
        Então deve exibir um alerta informando que o campo Nome é obrigatório

      Cenário: Validar campo obrigatório Sobrenome
        Dado que o usuário não preencheu o campo Sobrenome
        Quando clicar no botão Cadastrar
        Então deve exibir um alerta informando que o campo Sobrenome é obrigatório

      Cenário: Validar campo obrigatório Sexo
        Dado que o usuário não preencheu o campo Sexo
        Quando clicar no botão Cadastrar
        Então deve exibir um alerta informando que o campo Sexo é obrigatório