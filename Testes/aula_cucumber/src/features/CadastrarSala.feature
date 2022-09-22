# language: pt

  Funcionalidade: Cadastrar sala

    Contexto:
      Dado que o usuário está logado no sistema
      E que o usuário acessou a modal Cadastrar Sala

    # O campo Sala deve estar marcado visualmente que é obrigatório

    Cenário: Exibir campo Sala como obrigatório
      - O campo Sala é obrigatório
      Quando o sistema exibir a modal
      Então o campo Sala deve ser exibido para preenchimento
      E conter um asterisco indicando ser obrigatório

    # O campo Sala deve ser obrigatório

    Cenário: Validar preenchimento do campo obrigatório Sala
      - "Campos obrigatórios não preenchidos!"
      Dado que o usuário não preencheu o campo sala
      Quando o usuário clicar no botão Salvar
      Então deve ser exibida uma mensagem de feedback

    # Além do campo obrigatório Sala, a interface deverá ter somente o campo Descrição;

    Cenário: Exibir campo Descrição
      Quando o sistema exibir a modal
      Então o campo Descrição deve ser exibido para preenchimento opcional

    # O campo descrição deverá ter no máximo 500 caracteres;

    Esquema do Cenário: Validar preenchimento do campo Descrição
      - O campo deve ser preenchido com um máximo de 500 caracteres
      Dado que o usuário tenha preenchido o campo com <quantidade> caracteres
      Quando o usuário clicar em Salvar
      Então <resultado>
      Exemplos:
      | quantidade | resultado                                                                                             |
      | 499        | permitir o cadastro do campo Descrição                                                                |
      | 500        | permitir o cadastro do campo Descrição                                                                |
      | 501        | deve ser exibida uma mensagem de feedback "O campo Descrição não pode conter mais de 500 caracteres!" |

    # Não deve ser possível cadastrar duas salas com o mesmo nome

    Cenário: Cadastro duplicado de sala
      - "Não é possível cadastrar a sala. Já existe uma sala cadastrada com o mesmo nome. Altere o nome e tente novamente."
      Dado que o usuário preencheu o campo nome com o mesmo de uma sala que já existe no banco de dados
      Quando o usuário clicar no botão Salvar
      Então deve ser exibida uma mensagem de feedback

    # Após Salvar deverá ser apresentada a mensagem de feedback: "Sala salva com sucesso!"

    Cenário: Sala cadastrada com sucesso
      - "Sala salva com sucesso!"
      Dado que o usuário preencheu os dados corretamente
      E não existe uma sala com o mesmo nome cadastrado
      Quando o usuário clicar no botão Salvar
      Então exibir uma mensagem de feedback
      E a sala deverá ser apresentada na listagem de salas

    # O botão Cancelar deverá cancelar o cadastro da sala
    # Caso exista algum valor nos campos sala e descrição, após clicar em Cancelar os campos devem ser limpos

    Cenário: Cancelar o cadastro da sala
      Quando o usuário clicar no botão Cancelar
      Então os campos preenchidos devem ser limpos
      E o sistema deve cancelar o cadastro e retornar para a tela anterior