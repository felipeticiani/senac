# language: pt

  Funcionalidade: Cadastrar sala

    Cenário: Validar campo Sala como obrigatório
      - O campo Sala é obrigatório
      Dado que o usuário está logado no sistema
      Quando o usuário acessar a modal Cadastrar Sala
      Então no campo Sala deve aparecer um asterisco